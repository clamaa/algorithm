package com.clamaa.designpattern.interpretor;

/**
 * User: clamaa
 * Date: 5/13/13
 */
public class And extends Expression {

    private Expression left, right;

    public And(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) && right.interpret(context);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        And and = (And) o;

        if (left != null ? !left.equals(and.left) : and.left != null) return false;
        if (right != null ? !right.equals(and.right) : and.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    public String toString(){
        return String.format("(%s AND %s)", left, right);
    }
}
