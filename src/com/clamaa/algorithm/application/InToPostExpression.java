package com.clamaa.algorithm.application;

import com.clamaa.algorithm.datastructure.JStack;
import com.clamaa.algorithm.exception.ContainerIndexException;

/**
 * User: clamaa
 * Date: 13-4-15
 */
public class InToPostExpression {

    private JStack<Character> stack;
//    private String input;

    public InToPostExpression() {
//        this.input = in;
    }

    public String doTransfer(String input) throws ContainerIndexException {
        stack = new JStack<Character>(input.length());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                    result.append(getOperator(ch, 1));
                    break;
                case '*':
                case '/':
                    result.append(getOperator(ch, 2));
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    result.append(getParent());
                    break;
                default:
                    result.append(ch);
            }
        }
        while (!stack.isEmpty()){
            result.append(String.valueOf(stack.pop()));
        }
        return result.toString();
    }

    private String getOperator(char operator, int priority) throws ContainerIndexException {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            char topOperator = stack.pop();
            if(topOperator == '('){
                stack.push(topOperator);
                break;
            } else {
                int topPriority = topOperator == '+' || topOperator == '-' ? 1 : 2;
                if(topPriority < priority){
                    stack.push(topOperator);
                    break;
                } else {
                    result.append(topOperator);
                }
            }
        }
        stack.push(operator);
        return result.toString();
    }

    private String getParent() throws ContainerIndexException {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            char topOperator = stack.pop();
            if(topOperator == '('){
                break;
            } else {
                result.append(topOperator);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws ContainerIndexException {
        InToPostExpression expression = new InToPostExpression();
        System.out.println(expression.doTransfer("A*(B+C)-D/(E+F)"));
    }

}
