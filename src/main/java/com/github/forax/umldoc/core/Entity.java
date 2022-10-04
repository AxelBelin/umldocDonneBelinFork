package com.github.forax.umldoc.core;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * An entity (a class, an interface, a record, etc).
 *
 * @param modifiers the entity modifier
 * @param name the entity name
 * @param stereotype the stereotype if it exists
 * @param fields the fields of the entity
 * @param methods the methods of the entity
 */
public record Entity(Set<Modifier> modifiers, String name,
                     Optional<String> stereotype,
                     List<Field> fields, List<Method> methods) { }
