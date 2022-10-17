package com.github.donnebelin.umldoc.gen;

import com.github.forax.umldoc.core.Dependency;
import com.github.forax.umldoc.core.Entity;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Generate a class diagram using the plantuml format.
 */
public final class PlantUmlGenerator implements Generator {
  @Override
  public void generate(boolean header, List<Entity> entities, List<Dependency> dependencies,
                       Writer writer) throws IOException {
    requireNonNull(entities);
    requireNonNull(dependencies);
    requireNonNull(writer);
    if (header) {
      writer.append("""
          @startuml
          
          """);
    }

    for (var entity : entities) {
      writer.append("""
              class %s {
                %s
              }

          """.formatted(
                  entity.name(),
                  entity.fields()
                          .stream()
                          .map(Generator::fieldToString)
                          .collect(Collectors.joining("\n\t\t\t"))
      ));
    }

    if (header) {
      writer.append("""
          @enduml
          """);
    }
  }
}
