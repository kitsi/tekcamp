package com.teksystems.bootcamp.factorByTwo;

public class NodeCreator {

    public static Node createNode(int number) {
        Node newNode;
        if((number == 2) || (number%2 != 0)) {
            newNode = new ValueNode(number);
        } else {
            int integer1 = 2;
            int integer2 = number/2;
            newNode = new PointerNode(createNode(integer1),createNode(integer2));
        }
        return newNode;
    }
}
