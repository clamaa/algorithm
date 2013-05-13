package com.clamaa.designpattern.interpretor;

import java.util.HashMap;
import java.util.Map;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class Context {

    private Map<Variable, Boolean> contextMap = new HashMap<Variable, Boolean>();

    public void assign(Variable var, boolean value){
        contextMap.put(var, value);
    }

    public boolean lookup(Variable  variable){
        Boolean value = contextMap.get(variable);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
