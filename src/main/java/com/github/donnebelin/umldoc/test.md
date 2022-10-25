@startuml

    class com_github_forax_umldoc_core_AssociationDependency$Cardinality {
      +ZERO_OR_ONE: AssociationDependency$Cardinality
			+MANY: AssociationDependency$Cardinality
			+ONLY_ONE: AssociationDependency$Cardinality
    }

    class com_github_forax_umldoc_core_SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class com_github_forax_umldoc_core_Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class com_github_forax_umldoc_core_Package {
      -entities: java_util_List<com_github_forax_umldoc_core_Entity>
			-name: String
			-dependencies: java_util_List<com_github_forax_umldoc_core_Dependency>
    }

    class com_github_forax_umldoc_core_Field {
      -modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-typeInfo: TypeInfo
			-name: String
    }

    class com_github_forax_umldoc_core_AssociationDependency {
      -left: AssociationDependency$Side
			-right: AssociationDependency$Side
    }

    class com_github_forax_umldoc_core_Method {
      -modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-returnTypeInfo: TypeInfo
			-parameters: java_util_List<com_github_forax_umldoc_core_Method$Parameter>
			-name: String
    }

    class com_github_forax_umldoc_core_Method$Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com_github_forax_umldoc_core_AssociationDependency$Side {
      -entity: Entity
			-cardinality: AssociationDependency$Cardinality
			-label: java_util_Optional<java_lang_String>
			-navigability: boolean
    }

    class com_github_forax_umldoc_classfile_ClassFileParser$EntityBuilder {
      -name: String
    }

    class com_github_forax_umldoc_core_Entity$Stereotype {
      +CLASS: Entity$Stereotype
			+INTERFACE: Entity$Stereotype
			+ABSTRACT: Entity$Stereotype
			+ANNOTATION: Entity$Stereotype
			+RECORD: Entity$Stereotype
			+ENUM: Entity$Stereotype
    }

    class com_github_forax_umldoc_core_Entity {
      -type: TypeInfo
			-modifiers: java_util_Set<com_github_forax_umldoc_core_Modifier>
			-methods: java_util_List<com_github_forax_umldoc_core_Method>
			-stereotype: Entity$Stereotype
			-fields: java_util_List<com_github_forax_umldoc_core_Field>
    }

    class com_github_forax_umldoc_core_TypeInfo {
      -typeParameters: java_util_List<com_github_forax_umldoc_core_TypeInfo>
			-name: String
			-outer: java_util_Optional<com_github_forax_umldoc_core_TypeInfo>
    }

@enduml


```mermaid
classDiagram
    direction TB

    class com_github_forax_umldoc_core_AssociationDependency_Cardinality {
      +ZERO_OR_ONE: AssociationDependency_Cardinality
			+MANY: AssociationDependency_Cardinality
			+ONLY_ONE: AssociationDependency_Cardinality
    }

    class com_github_forax_umldoc_core_SubtypeDependency {
      -subtype: Entity
			-supertype: Entity
    }

    class com_github_forax_umldoc_core_Modifier {
      +PRIVATE: Modifier
			+FINAL: Modifier
			+STATIC: Modifier
			+PUBLIC: Modifier
			+PROTECTED: Modifier
			+PACKAGE: Modifier
    }

    class com_github_forax_umldoc_core_Package {
      -entities: java_util_List[com_github_forax_umldoc_core_Entity]
			-name: String
			-dependencies: java_util_List[com_github_forax_umldoc_core_Dependency]
    }

    class com_github_forax_umldoc_core_Field {
      -modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-typeInfo: TypeInfo
			-name: String
    }

    class com_github_forax_umldoc_core_AssociationDependency {
      -left: AssociationDependency_Side
			-right: AssociationDependency_Side
    }

    class com_github_forax_umldoc_core_Method {
      -modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-returnTypeInfo: TypeInfo
			-parameters: java_util_List[com_github_forax_umldoc_core_Method_Parameter]
			-name: String
    }

    class com_github_forax_umldoc_core_Method_Parameter {
      -typeInfo: TypeInfo
			-name: String
    }

    class com_github_forax_umldoc_core_AssociationDependency_Side {
      -entity: Entity
			-cardinality: AssociationDependency_Cardinality
			-label: java_util_Optional[java_lang_String]
			-navigability: boolean
    }

    class com_github_forax_umldoc_classfile_ClassFileParser_EntityBuilder {
      -name: String
    }

    class com_github_forax_umldoc_core_Entity_Stereotype {
      +CLASS: Entity_Stereotype
			+INTERFACE: Entity_Stereotype
			+ABSTRACT: Entity_Stereotype
			+ANNOTATION: Entity_Stereotype
			+RECORD: Entity_Stereotype
			+ENUM: Entity_Stereotype
    }

    class com_github_forax_umldoc_core_Entity {
      -type: TypeInfo
			-modifiers: java_util_Set[com_github_forax_umldoc_core_Modifier]
			-methods: java_util_List[com_github_forax_umldoc_core_Method]
			-stereotype: Entity_Stereotype
			-fields: java_util_List[com_github_forax_umldoc_core_Field]
    }

    class com_github_forax_umldoc_core_TypeInfo {
      -typeParameters: java_util_List[com_github_forax_umldoc_core_TypeInfo]
			-name: String
			-outer: java_util_Optional[com_github_forax_umldoc_core_TypeInfo]
    }

```