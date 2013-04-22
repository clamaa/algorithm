package com.clamaa.algorithm.tree;

/**
 * User: clamaa
 * Date: 4/21/13
 */
public class JTree<T extends Comparable> {

    private JTreeNode<T> root;

    public JTreeNode<T> find(T key) {
        JTreeNode<T> current = root;
        while (!current.getData().equals(key)) {
            current = current.getData().compareTo(key) > 0 ? current.getLeftNode() : current.getRightNode();
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(T data) {
        JTreeNode<T> node = new JTreeNode<T>();
        node.setData(data);
        if (root == null) {
            root = node;
        } else {
            JTreeNode<T> current = root;
            JTreeNode<T> parent = null;
            while (true) {
                parent = current;
                if (data.compareTo(current.getData()) < 0) {
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(node);
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(node);
                        return;
                    }
                }
            }
        }
    }

    public void preOrderTraverse(JTreeNode<T> currentNode){
        if(currentNode != null){
            //here to add traverse code
            System.out.println(currentNode.getData());
            preOrderTraverse(currentNode.getLeftNode());
            preOrderTraverse(currentNode.getRightNode());
        }
    }

    public void inOrderTraverse(JTreeNode<T> currentNode) {
        if (currentNode != null) {
            inOrderTraverse(currentNode.getLeftNode());
            //here to add traverse code
            System.out.println(currentNode.getData());
            inOrderTraverse(currentNode.getRightNode());
        }
    }

    public void postOrderTraverse(JTreeNode<T> currentNode){
        if(currentNode!=null){
            postOrderTraverse(currentNode.getLeftNode());
            postOrderTraverse(currentNode.getRightNode());
            //here to add traverse code
            System.out.println(currentNode.getData());
        }
    }

    public JTreeNode<T> findMinimum() {
        JTreeNode<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getLeftNode();
        }
        return last;
    }

    public JTreeNode<T> findMax() {
        JTreeNode<T> current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.getRightNode();
        }
        return last;
    }

    public boolean delete(T key) {
        JTreeNode<T> current = root;
        JTreeNode<T> parent = root;
        boolean isLeftChild = true;

        while (!current.getData().equals(key)) {
            parent = current;
            if (key.compareTo(current.getData()) < 0) {
                isLeftChild = true;
                current = current.getLeftNode();
            } else {
                isLeftChild = false;
                current = current.getRightNode();
            }
            if (current == null) {
                return false;
            }
        }

        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftNode(null);
            } else {
                parent.setRightNode(null);
            }
        } else if (current.getRightNode() == null) {
            if (current == root) {
                root = current.getLeftNode();
            } else if (isLeftChild) {
                parent.setLeftNode(current.getLeftNode());
            } else {
                parent.setRightNode(current.getLeftNode());
            }
        } else if (current.getLeftNode() == null) {
            if (current == root) {
                root = current.getRightNode();
            } else if (isLeftChild) {
                parent.setLeftNode(current.getRightNode());
            } else {
                parent.setRightNode(current.getRightNode());
            }
        } else {
            JTreeNode<T> successor = getSuccessor(current);
            if(current == root){
                root = successor;
            } else if(isLeftChild){
                current.setLeftNode(successor);
            } else {
                current.setRightNode(successor);
            }
            successor.setLeftNode(current.getLeftNode());
        }
        return true;
    }

    /**
     * Find the following successor child and reset default left node and right node.
     * @param delNode - node to delete
     * @return
     */
    private JTreeNode<T> getSuccessor(JTreeNode<T> delNode) {
        JTreeNode<T> successorParent = delNode;
        JTreeNode<T> successor = delNode;
        JTreeNode<T> current = delNode.getRightNode();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }
        if (successor != delNode.getRightNode()) {
            successorParent.setLeftNode(successor.getRightNode());
            successor.setRightNode(delNode.getRightNode());
        }
        return successor;
    }

}
