package com.teksystems.bootcamp.factorByTwo;

public class NodeCreator {

    public static Node createNode(int number) {
        if((number == 2) || (number%2 != 0) || (number == 0)) {
            return new ValueNode(number);
        } else {
            return new PointerNode(createNode(2),createNode(number/2));
        }
    }
}
