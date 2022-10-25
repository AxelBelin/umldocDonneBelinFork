@startuml

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class com/github/forax/umldoc/core/Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class com/github/forax/umldoc/core/Package {
      -entities: java/util/List<com/github/forax/umldoc/core/Entity>
			-name: String
			-dependencies: java/util/List<com/github/forax/umldoc/core/Dependency>
    }

    class com/github/forax/umldoc/core/Field {
      -modifiers: java/util/Set<com/github/forax/umldoc/core/Modifier>
			-typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -left: AssociationDependency$Side
			-right: AssociationDependency$Side
    }

    class com/github/forax/umldoc/core/Method {
      -modifiers: java/util/Set<com/github/forax/umldoc/core/Modifier>
			-returnTypeInfo: TypeInfo
			-parameters: java/util/List<com/github/forax/umldoc/core/Method$Parameter>
			-name: String
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -entity: Entity
			-cardinality: AssociationDependency$Cardinality
			-label: java/util/Optional<java/lang/String>
			-navigability: boolean
    }

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ENUM: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/Entity {
      -type: TypeInfo
			-modifiers: java/util/Set<com/github/forax/umldoc/core/Modifier>
			-methods: java/util/List<com/github/forax/umldoc/core/Method>
			-stereotype: Entity$Stereotype
			-fields: java/util/List<com/github/forax/umldoc/core/Field>
    }

    class com/github/forax/umldoc/core/TypeInfo {
      -typeParameters: java/util/List<com/github/forax/umldoc/core/TypeInfo>
			-name: String
			-outer: java/util/Optional<com/github/forax/umldoc/core/TypeInfo>
    }

@enduml


```mermaid
classDiagram
    direction TB

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class com/github/forax/umldoc/core/Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class com/github/forax/umldoc/core/Package {
      -entities: java/util/List[com/github/forax/umldoc/core/Entity]
			-name: String
			-dependencies: java/util/List[com/github/forax/umldoc/core/Dependency]
    }

    class com/github/forax/umldoc/core/Field {
      -modifiers: java/util/Set[com/github/forax/umldoc/core/Modifier]
			-typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -left: AssociationDependency$Side
			-right: AssociationDependency$Side
    }

    class com/github/forax/umldoc/core/Method {
      -modifiers: java/util/Set[com/github/forax/umldoc/core/Modifier]
			-returnTypeInfo: TypeInfo
			-parameters: java/util/List[com/github/forax/umldoc/core/Method$Parameter]
			-name: String
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -entity: Entity
			-cardinality: AssociationDependency$Cardinality
			-label: java/util/Optional[java/lang/String]
			-navigability: boolean
    }

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ENUM: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/Entity {
      -type: TypeInfo
			-modifiers: java/util/Set[com/github/forax/umldoc/core/Modifier]
			-methods: java/util/List[com/github/forax/umldoc/core/Method]
			-stereotype: Entity$Stereotype
			-fields: java/util/List[com/github/forax/umldoc/core/Field]
    }

    class com/github/forax/umldoc/core/TypeInfo {
      -typeParameters: java/util/List[com/github/forax/umldoc/core/TypeInfo]
			-name: String
			-outer: java/util/Optional[com/github/forax/umldoc/core/TypeInfo]
    }

```