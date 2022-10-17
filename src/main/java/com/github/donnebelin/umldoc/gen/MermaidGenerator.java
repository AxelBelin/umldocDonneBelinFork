package com.github.donnebelin.umldoc.gen;

import com.github.forax.umldoc.core.Dependency;
import com.github.forax.umldoc.core.Entity;
import com.github.forax.umldoc.core.Field;

import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

/**
 * Generate a class diagram using the mermaid format.
 */
public final class MermaidGenerator implements Generator {
  private static String escapeField(Field field) {
    return Generator.fieldToString(field).replaceAll("<", "[").replaceAll(">", "]");
  }

  @Override
  public void generate(boolean header, List<Entity> entities, List<Dependency> dependencies,
                       Writer writer) throws IOException {
    requireNonNull(entities);
    requireNonNull(dependencies);
    requireNonNull(writer);
    if (header) {
      writer.append("""
          classDiagram
              direction TB
          
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
                      .map(MermaidGenerator::escapeField)
                      .collect(Collectors.joining("\n\t\t\t"))
      ));
    }
  }
}
