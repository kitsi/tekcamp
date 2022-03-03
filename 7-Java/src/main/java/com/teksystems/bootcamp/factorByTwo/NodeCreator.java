package com.teksystems.bootcamp.factorByTwo;

public class NodeCreator {

    public static Node createNode(int number) {
        Node newNode;
        if((number == 2) || (number%2 != 0)) {
            newNode = new ValueNode(number);
        } else {
            int integer1 = 2;
            int integer2 = number/2;
//            if((integer2 == 2) || (integer2%2 != 0)){
                Node node1 = new ValueNode(integer1);
                Node node2 = new ValueNode(integer2);
                newNode = new PointerNode( node1, node2);
//            } else {
//                newNode = new ValueNode(number);

//                int integer3 = integer1/2;
//                int integer4 = 2;
//                Node node3 = new ValueNode(integer3);
//                Node node4 = new ValueNode(integer4);
//                newNode = new PointerNode( node3, node4);
//            }
        }
        return newNode;
    }
}
