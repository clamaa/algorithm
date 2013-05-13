package com.clamaa.designpattern.interpretor;

/**
 * User: clamaa
 * Date: 5/6/13
 */
public class Client {

    private static Context context;
    private static Expression expression;

    public static void main(String[] args){
        context = new Context();
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Constant c = new Constant(true);

        context.assign(x, false);
        context.assign(y, true);

        expression = new Or(new And(c, x), new And(y, new Not(x)));
        System.out.println(String.format("x=%s", x.interpret(context)));
        System.out.println(String.format("y=%s", y.interpret(context)));
        System.out.println(String.format("%s=%s", expression.toString(), expression.interpret(context)));
    }
}
