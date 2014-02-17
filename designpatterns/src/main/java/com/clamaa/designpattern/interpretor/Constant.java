package com.clamaa.designpattern.interpretor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class Constant extends Expression {

    private boolean value;

    public Constant(boolean value){
        this.value = value;
    }

    @Override
    public boolean interpret(Context context) {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Constant constant = (Constant) o;

        if (value != constant.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (value ? 1 : 0);
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }
}
