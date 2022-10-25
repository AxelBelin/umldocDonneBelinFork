package com.github.donnebelin.umldoc.builder;

import static java.util.Objects.requireNonNull;

public final class GeneratorBuilder {
    public record PlantBuilder() implements Builder<String> {

        @Override
        public String build(String name) {
            requireNonNull(name);
            return name.replace('/', '_');
        }
    }

    public record MermaidBuilder() implements Builder<String> {

        @Override
        public String build(String name) {
            requireNonNull(name);
            return name
                    .replace('/', '_')
                    .replace('$', '_')
                    .replaceAll("<", "[")
                    .replaceAll(">", "]");
        }
    }
}
