package com.depasquale;

public class Node<T> {
    private Node<T> rightChild;
    private Node<T> leftChild;
    private T data;

    Node(T data) {
        this.data = data;
    }

    Node<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    Node<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
