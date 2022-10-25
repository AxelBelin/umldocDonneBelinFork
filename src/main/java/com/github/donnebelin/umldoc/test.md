@startuml

SubtypeDependency "1" -->  "1" Entity : Not defined
SubtypeDependency "1" -->  "1" Entity : Not defined
Field "1" -->  "1" TypeInfo : Not defined
AssociationDependency "1" -->  "1" AssociationDependency$Side : Not defined
AssociationDependency "1" -->  "1" AssociationDependency$Side : Not defined
Method "1" -->  "1" TypeInfo : Not defined
Method$Parameter "1" -->  "1" TypeInfo : Not defined
AssociationDependency$Side "1" -->  "1" Entity : Not defined
AssociationDependency$Side "1" -->  "1" AssociationDependency$Cardinality : Not defined
Entity "1" -->  "1" TypeInfo : Not defined
Entity "1" -->  "1" Entity$Stereotype : Not defined
    class AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class Package {
      -entities: java_util_List<com_github_forax_umldoc_core_Entity>
			-name: String
			-dependencies: java_util_List<com_github_forax_umldoc_core_Dependency>
    }

    class Field {
      -modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-typeInfo: TypeInfo
			-name: String
    }

    class AssociationDependency {
      -left: AssociationDependency$Side
			-right: AssociationDependency$Side
    }

    class Method {
      -modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-returnTypeInfo: TypeInfo
			-parameters: java_util_List<com_github_forax_umldoc_core_Method$Parameter>
			-name: String
    }

    class Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class AssociationDependency$Side {
      -entity: Entity
			-cardinality: AssociationDependency$Cardinality
			-label: java_util_Optional<java_lang_String>
			-navigability: boolean
    }

    class ClassFileParser$EntityBuilder {
      -name: String
    }

    class Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ENUM: Entity$Stereotype
    }

    class Entity {
      -type: TypeInfo
			-modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-methods: java_util_List<com_github_forax_umldoc_core_Method>
			-stereotype: Entity$Stereotype
			-fields: java_util_List<com_github_forax_umldoc_core_Field>
    }

    class TypeInfo {
      -typeParameters: java_util_List<com_github_forax_umldoc_core_TypeInfo>
			-name: String
			-outer: java_util_Optional<com_github_forax_umldoc_core_TypeInfo>
    }

@enduml


```mermaid
classDiagram
    direction TB

SubtypeDependency --> "1" Entity : Not defined
SubtypeDependency --> "1" Entity : Not defined
Field --> "1" TypeInfo : Not defined
AssociationDependency --> "1" AssociationDependency$Side : Not defined
AssociationDependency --> "1" AssociationDependency$Side : Not defined
Method --> "1" TypeInfo : Not defined
Method$Parameter --> "1" TypeInfo : Not defined
AssociationDependency$Side --> "1" Entity : Not defined
AssociationDependency$Side --> "1" AssociationDependency$Cardinality : Not defined
Entity --> "1" TypeInfo : Not defined
Entity --> "1" Entity$Stereotype : Not defined
    class AssociationDependency_Cardinality {
      +ZERO_OR_ONE: AssociationDependency_Cardinality
			+MANY: AssociationDependency_Cardinality
			+ONLY_ONE: AssociationDependency_Cardinality
    }

    class SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class Package {
      -entities: java_util_List[com_github_forax_umldoc_core_Entity]
			-name: String
			-dependencies: java_util_List[com_github_forax_umldoc_core_Dependency]
    }

    class Field {
      -modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-typeInfo: TypeInfo
			-name: String
    }

    class AssociationDependency {
      -left: AssociationDependency_Side
			-right: AssociationDependency_Side
    }

    class Method {
      -modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-returnTypeInfo: TypeInfo
			-parameters: java_util_List[com_github_forax_umldoc_core_Method_Parameter]
			-name: String
    }

    class Method_Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class AssociationDependency_Side {
      -entity: Entity
			-cardinality: AssociationDependency_Cardinality
			-label: java_util_Optional[java_lang_String]
			-navigability: boolean
    }

    class ClassFileParser_EntityBuilder {
      -name: String
    }

    class Entity_Stereotype {
      +CLASS: Entity_Stereotype
			+INTERFACE: Entity_Stereotype
			+ABSTRACT: Entity_Stereotype
			+ANNOTATION: Entity_Stereotype
			+RECORD: Entity_Stereotype
			+ENUM: Entity_Stereotype
    }

    class Entity {
      -type: TypeInfo
			-modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-methods: java_util_List[com_github_forax_umldoc_core_Method]
			-stereotype: Entity_Stereotype
			-fields: java_util_List[com_github_forax_umldoc_core_Field]
    }

    class TypeInfo {
      -typeParameters: java_util_List[com_github_forax_umldoc_core_TypeInfo]
			-name: String
			-outer: java_util_Optional[com_github_forax_umldoc_core_TypeInfo]
    }

```