package com.clamaa.designpattern.interpretor;

/**
 * User: clamaa
 * Date: 5/13/13
 */
public class Not extends Expression {

    private Expression exp;

    public Not(Expression exp){
        this.exp = exp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Not not = (Not) o;

        if (exp != null ? !exp.equals(not.exp) : not.exp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return exp != null ? exp.hashCode() : 0;
    }

    @Override
    public boolean interpret(Context context) {
        return !exp.interpret(context);
    }

    public String toString(){
        return String.format("Not (%s)", exp);
    }
}
