package com.github.donnebelin.umldoc.classdiagram;

import com.github.forax.umldoc.core.AssociationDependency;
import com.github.forax.umldoc.core.Entity;
import com.github.forax.umldoc.core.Field;
import com.github.forax.umldoc.core.TypeInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DiagramFormater {
  private final Set<Entity> entities;
  private final HashMap<String, Set<String>> mappedEntitiesToPackage;

  public DiagramFormater(List<Entity> entities) {
    Objects.requireNonNull(entities);
    this.entities = entities.stream().collect(Collectors.toSet());
    this.mappedEntitiesToPackage = mapPackageToEntities(entities);
  }

  private boolean entityNameExist(String entityName){
    return entities.stream().anyMatch(entity -> getEntityNameWithoutPackage(entity.type().name()).equals(getEntityNameWithoutPackage(entityName)));
  }

  /**
   * Compute the associations between the entities.
   *
   * @return The computed list of associations
   */
  public List<AssociationDependency> createAssociationDependencies() {
    var associationList = new ArrayList<AssociationDependency>();
    for(var entity : entities) {
      for(var field : entity.fields()){
        var newAssociation = createAssociation(field,entity);
        if(newAssociation.isPresent()){
          associationList.add(newAssociation.get());
        }
      }
    }
    return associationList;
  }

  private Optional<AssociationDependency> createAssociation(Field field, Entity entityLeft){
    var fieldTypeInfo = getTypeInfo(entityLeft,field.typeInfo());
    if(fieldTypeInfo.isPresent()) {
      var typeInfo = fieldTypeInfo.get();
      var cardinality = getCardinalityFrom(typeInfo);
      var left = new AssociationDependency.Side(entityLeft, Optional.empty(), false, cardinality);
      var rightEntity = getEntityByName(typeInfo.name());
      if(rightEntity.isPresent()){
        var right = new AssociationDependency.Side(rightEntity.get(), Optional.empty(), true, cardinality);
        return Optional.of(new AssociationDependency(left, right));
      }
    }
    return Optional.empty();
  }

  private HashMap<String, Set<String>> mapPackageToEntities(List<Entity> entities){
    return entities.stream()
        .collect(
            Collectors.groupingBy(
                DiagramFormater::getPackageName,
                HashMap::new, Collectors.mapping(entity -> getEntityNameWithoutPackage(entity.type().name()),
                    Collectors.toSet())
            )
        );
  }

  private boolean entityAsSamePackage(String entityName1, String entityName2){
    return mappedEntitiesToPackage.entrySet().stream()
        .map(entry -> entry.getValue()).flatMap(Collection::stream)
        .anyMatch(entityName ->{
          var entityNameWithoutPackage = getEntityNameWithoutPackage(entityName);
          return entityName1.equals(entityNameWithoutPackage) && entityName2.equals(entityNameWithoutPackage);
        });
  }

  private static String getPackageName(Entity entity) {
    var packageWithName = entity.type().name();
    return packageWithName.substring(0, packageWithName.lastIndexOf("/"));
  }

  private static String getEntityNameWithoutPackage(String entityNameWithPackage) {
    var index = entityNameWithPackage.lastIndexOf("/");
    if(index < 0){
      return entityNameWithPackage;
    }
    return entityNameWithPackage.substring(index + 1);
  }

  private Optional<TypeInfo> getTypeInfo(Entity left, TypeInfo typeInfo) {
    if(entityAsSamePackage(getEntityNameWithoutPackage(left.type().name()),getEntityNameWithoutPackage(typeInfo.name()))){
      if (entityNameExist(getEntityNameWithoutPackage(typeInfo.name()))) {
        return Optional.of(typeInfo);
      }
    }

    for (var subTypeInfo : typeInfo.typeParameters()) {
      var subType = getTypeInfo(left,subTypeInfo);
      if (subType.isPresent()) {
        return subType;
      }
    }

    return Optional.empty();
  }

  private AssociationDependency.Cardinality getCardinalityFrom(TypeInfo typeInfo) {
    var outer = typeInfo.outer();
    if (outer.isPresent()) {
      var outerType = outer.get();
      var typeName = outerType.name();
      if (typeName.equals("java.util.Optional")) {
        return AssociationDependency.Cardinality.ZERO_OR_ONE;
      }
      return AssociationDependency.Cardinality.MANY;
    }
    return AssociationDependency.Cardinality.ONLY_ONE;
  }

  private Optional<Entity> getEntityByName(String name) {
    return entities.stream().filter(entity -> getEntityNameWithoutPackage(entity.type().name()).equals(name)).findFirst();
  }
}
