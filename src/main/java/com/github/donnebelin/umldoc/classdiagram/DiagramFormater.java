package com.github.donnebelin.umldoc.classdiagram;

import com.github.forax.umldoc.core.AssociationDependency;
import com.github.forax.umldoc.core.Entity;
import com.github.forax.umldoc.core.Field;
import com.github.forax.umldoc.core.TypeInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class DiagramFormater {
  private final List<Entity> entities;
  private final HashMap<String, Set<String>> mappedEntitiesToPackage;

  public DiagramFormater(List<Entity> entities) {
    Objects.requireNonNull(entities);
    this.entities = entities;
    this.mappedEntitiesToPackage = mapPackageToEntities(entities);
  }


  private boolean entityNameExist(String entityName){
    return entities.stream().anyMatch(entity -> getEntityNameWithoutPackage(entity.type().name()).equals(getEntityNameWithoutPackage(entityName)));
  }

  private Optional<Entity> getEntityByName(String name) {
    return entities.stream().filter(entity -> getEntityNameWithoutPackage(entity.type().name()).equals(name)).findFirst();
  }

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
      var cardinality = getCardinality(typeInfo);
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
        .anyMatch(entityName -> entityName1.equals(entityName) && entityName2.equals(entityName));
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
    return Optional.empty();
  }

  private AssociationDependency.Cardinality getCardinality(TypeInfo typeInfo) {
    return typeInfo.outer().isPresent() ? AssociationDependency.Cardinality.MANY : AssociationDependency.Cardinality.ONLY_ONE;
  }

}
