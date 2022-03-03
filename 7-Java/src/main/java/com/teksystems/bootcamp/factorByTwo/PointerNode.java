package com.teksystems.bootcamp.factorByTwo;

public class PointerNode extends Node{
    private Node node1;
    private Node node2;

    public PointerNode(Node node1, Node node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public int getCountOfTwos() {
        return node1.getCountOfTwos() + node2.getCountOfTwos();
    }
}
