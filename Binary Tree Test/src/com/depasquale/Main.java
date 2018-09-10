package com.depasquale;

public class Main {

    public static void main(String[] args) {
        BinaryTree<String> bTree = new BinaryTree<>("rootNode");

        Node<String> alpha = new Node<>("alpha");   // should build:    "rootNode"
        Node<String> beta = new Node<>("beta");     //                      /\
        Node<String> gamma = new Node<>("gamma");   //                     /  \
                                                          //               "alpha" "beta"
                                                          //                  / \
                                                          //                  "gamma"

        bTree.getRoot().setLeftChild(alpha);
        bTree.getRoot().setRightChild(beta);
        bTree.getRoot().getLeftChild().setRightChild(gamma);


        bTree.inOrderTraverse(bTree.getRoot());
        System.out.println();
    }
}

