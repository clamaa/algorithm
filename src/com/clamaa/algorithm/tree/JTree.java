package com.clamaa.algorithm.tree;

/**
 * User: clamaa
 * Date: 4/21/13
 */
public class JTree<T extends Comparable> {

    private JTreeNode<T> root;

    public JTreeNode<T> find(T key){
        JTreeNode<T> current = root;
        while (!current.getData().equals(key)){
            current = current.getData().compareTo(key) > 0 ? current.getLeftNode() : current.getRightNode();
            if(current == null){
                return null;
            }
        }
        return current;
    }

    public void insert(T data){
        JTreeNode<T> node = new JTreeNode<T>();
        node.setData(data);
        if(root == null){
            root = node;
        } else{
            JTreeNode<T> current = root;
            JTreeNode<T> parent = null;
            while (true){
                parent = current;
                if(data.compareTo(current.getData()) < 0){
                    current = current.getLeftNode();
                    if(current == null){
                        parent.setLeftNode(node);
                        return;
                    }
                } else {
                    current = current.getRightNode();
                    if(current == null){
                        parent.setRightNode(node);
                        return;
                    }
                }
            }
        }
    }

    public void inOrderTraverse(JTreeNode<T> currentNode){
        if(currentNode != null){
            inOrderTraverse(currentNode.getLeftNode());
            //here to add traverse code
            System.out.println();
            inOrderTraverse(currentNode.getRightNode());
        }
    }

    public JTreeNode<T> findMinimum(){
        JTreeNode<T> current, last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.getLeftNode();
        }
        return last;
    }

    public JTreeNode<T> findMax(){
        JTreeNode<T> current, last = null;
        current = root;
        while (current!=null){
            last = current;
            current = current.getRightNode();
        }
        return last;
    }

}
