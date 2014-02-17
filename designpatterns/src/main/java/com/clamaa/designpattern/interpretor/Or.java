package com.clamaa.designpattern.interpretor;

/**
 * User: clamaa
 * Date: 5/13/13
 */
public class Or extends Expression {

    private Expression left, right;

    public Or(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Or or = (Or) o;

        if (left != null ? !left.equals(or.left) : or.left != null) return false;
        if (right != null ? !right.equals(or.right) : or.right != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public boolean interpret(Context context) {
        return left.interpret(context) || right.interpret(context);
    }

    public String toString(){
        return String.format("(%s OR %s)", left, right);
    }
}
