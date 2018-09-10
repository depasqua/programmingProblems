package com.depasquale;

public class BinaryTree<T> {
    private Node<T> root;

    BinaryTree(T data) {
        setRoot(new Node<T>(data));
    }

    private void setRoot(Node<T> root) {
        this.root = root;
    }

    Node<T> getRoot() {
        return root;
    }

    public void addLeftChild(T data, Node<T> child) {
        if (child.getLeftChild() == null) {
            child.setLeftChild(new Node<T>(data));
        }
    }

    public void addRightChild(T data, Node<T> child) {
        if (child.getRightChild() == null) {
            child.setRightChild(new Node<T>(data));
        }
    }

    void inOrderTraverse(Node<T> node)
    {
        if (node != null) {
            System.out.print(node.getData().toString() + ", ");
            inOrderTraverse(node.getLeftChild());
            inOrderTraverse(node.getRightChild());
        }
    }
}
