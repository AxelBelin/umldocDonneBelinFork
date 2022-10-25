package com.github.donnebelin.umldoc.builder;

public sealed interface Builder<T> permits GeneratorBuilder.MermaidBuilder, GeneratorBuilder.PlantBuilder, TypeInfoBuilder {
    T build(String signature);
}
