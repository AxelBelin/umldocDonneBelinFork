package com.github.donnebelin.umldoc.classfile;

import com.github.forax.umldoc.core.AssociationDependency;
import com.github.forax.umldoc.core.AssociationDependency.Side;
import com.github.forax.umldoc.core.AssociationDependency.Cardinality;
import com.github.forax.umldoc.core.Entity;
import com.github.forax.umldoc.core.Entity.Stereotype;
import com.github.forax.umldoc.core.Field;
import com.github.forax.umldoc.core.Modifier;
import java.io.IOException;
import java.lang.constant.ClassDesc;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * Class to parse a jar file.
 * This class uses ASM library to recover
 * entities, fields and methods
 * from .class files of the given jar.
 */
public final class JarParser {
  private final HashSet<Entity> entities = new HashSet<>();
  //private final HashSet<Field> fields = new HashSet<>();
  //private final HashSet<AssociationDependency> associations = new HashSet<>();

  private final HashMap<Entity,HashSet<Field>> fields = new HashMap<>();

  private final HashMap<Entity,HashSet<AssociationDependency>> associations = new HashMap<>();

  /**
   * Instantiate a new JarParser to parse all entities from a jar file.
   *
   * @throws IOException if I/O exception
   *                     occurred during parsing .class files
   */
  public JarParser() throws IOException {
    recoverEntitiesFromJar();
  }

  /**
   * Supplies a list of all Entities parsed from jar file
   *
   * @return A list of Entity object with all parsed entities discovered in the jar file.
   */
  public List<Entity> entities() {
    return List.copyOf(entities);
  }

  private void recoverEntitiesFromJar() throws IOException {
    var path = Path.of("target");
    var finder = ModuleFinder.of(path);
    for (var moduleReference : finder.findAll()) {
      try (
              var reader = moduleReference.open()
      ) {
        for (var filename :
                (Iterable<String>) reader.list()::iterator) {
          if (!filename.endsWith(".class")) {
            continue;
          }
          try (var inputStream = reader
                  .open(filename).orElseThrow()) {
            var classReader =
                    new ClassReader(inputStream);
            getASMData(classReader);
          }
        }
      }
    }
  }

  private static Stereotype resolveStereotype(String superName) {
    if(superName.contains("Record")) {
      return Stereotype.RECORD;
    }

    if(superName.contains("Enum")) {
      return Stereotype.ENUM;
    }

    if(superName.contains("Interface")) {
      return Stereotype.INTERFACE;
    }

    return Stereotype.CLASS;
  }

  private static Set<Modifier> modifiers(int access) {
    var modifiers = new HashSet<Modifier>();

    if (java.lang.reflect.Modifier.isStatic(access)) {
      modifiers.add(Modifier.STATIC);
    }

    if (java.lang.reflect.Modifier.isFinal(access)) {
      modifiers.add(Modifier.FINAL);
    }

    if (java.lang.reflect.Modifier.isPublic(access)) {
      modifiers.add(Modifier.PUBLIC);
    } else if (java.lang.reflect.Modifier.isPrivate(access)) {
      modifiers.add(Modifier.PRIVATE);
    } else if (java.lang.reflect.Modifier.isProtected(access)) {
      modifiers.add(Modifier.PROTECTED);
    } else {
      modifiers.add(Modifier.PACKAGE);
    }

    return modifiers;
  }

  // 1 asso avec 1 seul sens = 1 field dont le type est une Entity présente dans entities
  private void addFieldOrAssociation(int access, String name, String type) {


    /*
    var entityAsso = entities.stream()
            .filter(entity -> entity.name().equals(type))
            .findFirst();

    if(entityAsso.isEmpty()) {
      fields.add(new Field(
              modifiers(access),
              name.replace('$', '_'),
              type
      ));
      System.out.println(name + "  " + type);
    } else {
      var entityLeft = entityAsso.get();
      var entityRight = entities.stream()
              .filter(entity -> entity.name().equals(name))
              .findFirst().orElseThrow();



      var left = new Side(entityLeft, Optional.empty(), true, Cardinality.ZERO_OR_ONE);
      var right = new Side(entityRight, Optional.empty(), true, Cardinality.ZERO_OR_ONE);
      // TODO ajoiuter l'asso
    }
    */

  }

  private void getASMData(ClassReader classReader) {
    classReader.accept(new ClassVisitor(Opcodes.ASM9) {

      @Override
      public void visit(
              int version,
              int access,
              String name,
              String signature,
              String superName,
              String[] interfaces) {
        if (!name.equals("module-info")) {
          entities.add(new Entity(
                  Set.of(),
                  name.replace('/', '_').replace('$', '_'),
                  resolveStereotype(superName),
                  List.copyOf(fields),
                  List.of()
          ));
        }
      }

      @Override
      public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if(! name.contains("this")) {
          if(signature != null) {
            signature = signature.replaceAll(";", "").replaceAll("<", "</");
            addFieldOrAssociation(access, name, Arrays.stream(signature.split("/"))
                    .filter(part -> part.contains("<") || part.contains(">"))
                    .collect(Collectors.joining())
                    .replace('$', '_'));
          } else {
            addFieldOrAssociation(access, name, ClassDesc.ofDescriptor(descriptor).displayName());
          }
        }

        return null;
      }

    }, 0);
  }
}
