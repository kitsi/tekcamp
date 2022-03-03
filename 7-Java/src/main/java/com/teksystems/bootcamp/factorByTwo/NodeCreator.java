package com.teksystems.bootcamp.factorByTwo;

public class NodeCreator {

    public static Node createNode(int number) {
        Node newNode;
        if((number == 2) || (number%2 != 0)) {
            newNode = new ValueNode(number);
        } else {
            newNode = new PointerNode(createNode(2),createNode(number/2));
        }
        return newNode;
    }
}
