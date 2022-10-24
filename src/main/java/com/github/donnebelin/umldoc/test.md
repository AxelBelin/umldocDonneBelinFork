@startuml

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Method {
      -returnTypeInfo: TypeInfo
			-modifiers: Set<Ljava/util/Set<Lcom/github/forax/umldoc/core/Modifier;>;>
			-parameters: List<Ljava/util/List<Lcom/github/forax/umldoc/core/Method$Parameter;>;>
			-name: String
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -supertype: Entity
			-subtype: Entity
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -right: AssociationDependency$Side
			-left: AssociationDependency$Side
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +INTERFACE: Entity$Stereotype
			+CLASS: Entity$Stereotype
			+ENUM: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -cardinality: AssociationDependency$Cardinality
			-navigability: boolean
			-entity: Entity
			-label: Optional<Ljava/util/Optional<Ljava/lang/String;>;>
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/Modifier {
      +PACKAGE: Modifier
			+PROTECTED: Modifier
			+PUBLIC: Modifier
			+STATIC: Modifier
			+PRIVATE: Modifier
			+FINAL: Modifier
    }

    class com/github/forax/umldoc/core/Entity {
      -fields: List<Ljava/util/List<Lcom/github/forax/umldoc/core/Field;>;>
			-type: TypeInfo
			-methods: List<Ljava/util/List<Lcom/github/forax/umldoc/core/Method;>;>
			-modifiers: Set<Ljava/util/Set<Lcom/github/forax/umldoc/core/Modifier;>;>
			-stereotype: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/Package {
      -dependencies: List<Ljava/util/List<Lcom/github/forax/umldoc/core/Dependency;>;>
			-name: String
			-entities: List<Ljava/util/List<Lcom/github/forax/umldoc/core/Entity;>;>
    }

    class com/github/forax/umldoc/core/Field {
      -modifiers: Set<Ljava/util/Set<Lcom/github/forax/umldoc/core/Modifier;>;>
			-typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/TypeInfo {
      -typeParameters: List<Ljava/util/List<Lcom/github/forax/umldoc/core/TypeInfo;>;>
			-outer: Optional<Ljava/util/Optional<Lcom/github/forax/umldoc/core/TypeInfo;>;>
			-name: String
    }

@enduml


```mermaid
classDiagram
    direction TB

    class com/github/forax/umldoc/classfile/ClassFileParser$EntityBuilder {
      -name: String
    }

    class com/github/forax/umldoc/core/Method {
      -returnTypeInfo: TypeInfo
			-modifiers: Set[Ljava/util/Set[Lcom/github/forax/umldoc/core/Modifier;];]
			-parameters: List[Ljava/util/List[Lcom/github/forax/umldoc/core/Method$Parameter;];]
			-name: String
    }

    class com/github/forax/umldoc/core/SubtypeDependency {
      -supertype: Entity
			-subtype: Entity
    }

    class com/github/forax/umldoc/core/AssociationDependency {
      -right: AssociationDependency$Side
			-left: AssociationDependency$Side
    }

    class com/github/forax/umldoc/core/Entity$Stereotype {
      +INTERFACE: Entity$Stereotype
			+CLASS: Entity$Stereotype
			+ENUM: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency$Side {
      -cardinality: AssociationDependency$Cardinality
			-navigability: boolean
			-entity: Entity
			-label: Optional[Ljava/util/Optional[Ljava/lang/String;];]
    }

    class com/github/forax/umldoc/core/Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/Modifier {
      +PACKAGE: Modifier
			+PROTECTED: Modifier
			+PUBLIC: Modifier
			+STATIC: Modifier
			+PRIVATE: Modifier
			+FINAL: Modifier
    }

    class com/github/forax/umldoc/core/Entity {
      -fields: List[Ljava/util/List[Lcom/github/forax/umldoc/core/Field;];]
			-type: TypeInfo
			-methods: List[Ljava/util/List[Lcom/github/forax/umldoc/core/Method;];]
			-modifiers: Set[Ljava/util/Set[Lcom/github/forax/umldoc/core/Modifier;];]
			-stereotype: Entity$Stereotype
    }

    class com/github/forax/umldoc/core/AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
    }

    class com/github/forax/umldoc/core/Package {
      -dependencies: List[Ljava/util/List[Lcom/github/forax/umldoc/core/Dependency;];]
			-name: String
			-entities: List[Ljava/util/List[Lcom/github/forax/umldoc/core/Entity;];]
    }

    class com/github/forax/umldoc/core/Field {
      -modifiers: Set[Ljava/util/Set[Lcom/github/forax/umldoc/core/Modifier;];]
			-typeInfo: TypeInfo
			-name: String
    }

    class com/github/forax/umldoc/core/TypeInfo {
      -typeParameters: List[Ljava/util/List[Lcom/github/forax/umldoc/core/TypeInfo;];]
			-outer: Optional[Ljava/util/Optional[Lcom/github/forax/umldoc/core/TypeInfo;];]
			-name: String
    }

```