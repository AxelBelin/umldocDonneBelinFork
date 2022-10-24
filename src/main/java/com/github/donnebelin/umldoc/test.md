@startuml

    class com/github/forax/umldoc/core/Field {
      -name: String
			-type: String
			-modifiers: Set
    }

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -supertype: Entity
			-subtype: Entity
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -navigability: boolean
			-cardinality: String
			-entity: Entity
    }

    class com/github/forax/umldoc/core/Method {
      -name: String
			-returnType: String
			-parameters: List
			-modifiers: Set
    }

    class com/github/forax/umldoc/core/Entity {
      -stereotype: Optional
			-name: String
			-modifiers: Set
			-fields: List
			-methods: List
    }

    class com/github/forax/umldoc/core/Package {
      -entities: List
			-name: String
			-dependencies: List
    }

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Modifier {
      +PROTECTED: Modifier
			+SEALED: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PRIVATE: Modifier
			+PACKAGE: Modifier
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -name: String
			-type: String
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ENUM: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -right: AssociationDependency$Side
			-left: AssociationDependency$Side
    }

@enduml


```mermaid
classDiagram
    direction TB

    class com/github/forax/umldoc/core/Field {
      -name: String
			-type: String
			-modifiers: Set
    }

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -supertype: Entity
			-subtype: Entity
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -navigability: boolean
			-cardinality: String
			-entity: Entity
    }

    class com/github/forax/umldoc/core/Method {
      -name: String
			-returnType: String
			-parameters: List
			-modifiers: Set
    }

    class com/github/forax/umldoc/core/Entity {
      -stereotype: Optional
			-name: String
			-modifiers: Set
			-fields: List
			-methods: List
    }

    class com/github/forax/umldoc/core/Package {
      -entities: List
			-name: String
			-dependencies: List
    }

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Modifier {
      +PROTECTED: Modifier
			+SEALED: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PRIVATE: Modifier
			+PACKAGE: Modifier
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -name: String
			-type: String
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ENUM: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -right: AssociationDependency$Side
			-left: AssociationDependency$Side
    }

```