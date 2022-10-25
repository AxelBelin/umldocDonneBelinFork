package com.github.donnebelin.umldoc;

import com.github.donnebelin.umldoc.classdiagram.DiagramFormater;
import com.github.donnebelin.umldoc.classfile.JarParser;
import com.github.donnebelin.umldoc.gen.MermaidGenerator;
import com.github.donnebelin.umldoc.gen.PlantUmlGenerator;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Contains the main method.
 * for this package
 */
public class Main {
  /**
   * main method of this package.
   *
   * @param args The path of the file
   *             for which the program will write
   *             Plant UML and Mermaid UML diagrams
   * @throws IOException if I/O exception
   *                     occurred during parsing
   */
  public static void main(String[] args)
          throws IOException {
    var parser = new JarParser();
    var entities = parser.entities()
            .stream()
            .filter(entity -> entity.type().name().contains("forax/umldoc")) // just to test with core classes
            .toList();
    var filePath = Path.of(args[0]);

    var diagramFormater = new DiagramFormater(entities);
    entities.forEach(ent -> System.out.println(ent.type().name()));
    System.out.println("FINAL RESULT + " + diagramFormater.createAssociationDependencies());
    diagramFormater.createAssociationDependencies().forEach(e -> System.out.println("RESULT = " + e.left().entity().type().name() + "  " + e.right().entity().type().name()));
    var plantUmlGenerator = new PlantUmlGenerator();
    var mermaidGenerator = new MermaidGenerator();

    try (var writer =
                 Files.newBufferedWriter(filePath,
                         StandardCharsets.UTF_8)
    ) {
      plantUmlGenerator.generate(
              true,
              entities,
              List.of(), // depandancies
              writer);
      writer.append('\n')
              .append('\n')
              .append("```mermaid")
              .append('\n');
      mermaidGenerator.generate(
              true,
              entities,
              List.of(), // depandancies
              writer);
      writer.append("```");
    }
  }
}
