package com.github.donnebelin.umldoc.builder;

public interface Builder<T> {
    T build(String signature);
}
