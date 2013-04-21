package com.clamaa.algorithm.application;

import com.clamaa.algorithm.datastructure.JStack;
import com.clamaa.algorithm.exception.ContainerIndexException;

/**
 * User: clamaa
 * Date: 13-4-15
 */
public class PostExpressionEvaluator {

    private JStack<Integer> stack;

    public int doParse(String input) throws ContainerIndexException {
        stack = new JStack<Integer>(20);
        for(int j=0;j<input.length();j++){
            char ch = input.charAt(j);
            if(ch >= '0' && ch <= '9'){
                stack.push((int) (ch - '0'));
            } else{
                int num2 = stack.pop();
                int num1 = stack.pop();
                int temp = 0;
                switch (ch){
                    case '+':
                        temp = num1 + num2;
                        break;
                    case '-':
                        temp = num1 - num2;
                        break;
                    case '*':
                        temp = num1 * num2;
                        break;
                    case '/':
                        temp = num1 / num2;
                        break;
                    default:
                        temp = 0;
                }
                stack.push(temp);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) throws ContainerIndexException {
        PostExpressionEvaluator evaluator = new PostExpressionEvaluator();
        InToPostExpression expression = new InToPostExpression();
        System.out.println(expression.doTransfer("5*(4+3)-6/(1+2)"));
        System.out.println(evaluator.doParse(expression.doTransfer("5*(4+3)-6/(1+2)")));
    }

}
