package com.github.donnebelin.umldoc;

import com.github.forax.umldoc.core.AssociationDependency;

public class Helper {

    public static String parseCardinalities(AssociationDependency.Cardinality card){
        return switch (card){
            case ONLY_ONE -> "1";
            case MANY -> "*";
            case ZERO_OR_ONE -> "0..1";
        };
    }
}
