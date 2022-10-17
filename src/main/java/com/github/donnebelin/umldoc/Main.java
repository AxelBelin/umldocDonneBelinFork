package com.github.donnebelin.umldoc;

import com.github.donnebelin.umldoc.classfile.JarParser;
import com.github.donnebelin.umldoc.gen.MermaidGenerator;
import com.github.donnebelin.umldoc.gen.PlantUmlGenerator;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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
//    var packages = parser.resolvePackages();
    var entities = parser.entities()
            .stream()
            .filter(entity -> entity.name().contains("forax_umldoc"))
            .toList();

    var filePath = Path.of(args[0]);
    var plantUmlGenerator = new PlantUmlGenerator();
    var mermaidGenerator = new MermaidGenerator();

    try (var writer =
                 Files.newBufferedWriter(filePath,
                         StandardCharsets.UTF_8)
    ) {
      plantUmlGenerator.generate(
              true,
              entities,
              parser.getAssociationDependencies(),
              writer);
      writer.append('\n')
              .append('\n')
              .append("```mermaid")
              .append('\n');
      mermaidGenerator.generate(
              true,
              entities,
              parser.getAssociationDependencies(),
              writer);
      writer.append("```");
    }
  }
}
