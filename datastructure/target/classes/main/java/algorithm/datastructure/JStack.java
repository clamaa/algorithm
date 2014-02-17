package algorithm.datastructure;

import algorithm.exception.ContainerIndexException;

/**
 * User: clamaa
 * Date: 13-4-14
 */
public class JStack<T> {
    private int stackSize;
    private Object[] stackArray;
    private int top;

    public JStack(int size) {
        this.stackSize = size;
        this.stackArray = new Object[this.stackSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public boolean isFull() {
        return this.top == stackSize - 1;
    }

    public void push(T data) throws ContainerIndexException {
        if (!isFull()) {
            stackArray[++top] = data;
            return;
        }
        throw new ContainerIndexException("The stack is full!");
    }

    public T pop() throws ContainerIndexException {
        if (!isEmpty()) {
            return (T) stackArray[top--];
        }
        throw new ContainerIndexException("The stack is empty!");
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) stackArray[top];
        }
        throw new ContainerIndexException("The stack is empty!");
    }


}
