package com.clamaa.algorithm.tree;

/**
 * User: clamaa
 * Date: 4/21/13
 */
public class JTreeNode<T extends Comparable> {

    private T data;
    private JTreeNode<T> leftNode;
    private JTreeNode<T> rightNode;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(JTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public JTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(JTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }
}
