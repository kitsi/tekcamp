package com.bootcamp.teksystems.ood_exercises.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class santasApp {
    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        Map<ChildCategory, List<String>> santaMap = Northpole.createSantaMap();
        printTableHeader();
        for(Map.Entry entry : santaMap.entrySet()) {
            Type type = null;
            if(entry.getKey().equals(ChildCategory.NAUGHTY)) {
                type = Type.COAL;
            } else if(entry.getKey().equals(ChildCategory.NICE)) {
                type = Type.TOY;
            }
            Type gift = makeGift(type);
            ArrayList<String> childList = (ArrayList<String>) entry.getValue();
            printChildToy(childList, gift);
        }
        printFooter();
    }

    private static Type makeGift(Type type) {
        ElfAbstractFactory elfAbstractFactory = ElfProducer.createElf(type);
        IElf elf = elfAbstractFactory.createElf();
        return elf.deliver();
    }

    private static void printTableHeader() {
        System.out.println("\n===========================");
        System.out.println("   SANTA GIFT LIST 2022");
        System.out.println("===========================");
        System.out.printf("%-16s|%-10s\n", " Child", " Gift");
        System.out.printf("%-16s|%-10s\n", "================", "==========");
    }

    private static void printChildToy(ArrayList<String> childList, Type gift) {
        for(Object childName : childList) {
            String giftString = gift.toString().charAt(0) + gift.toString().substring(1).toLowerCase();
            System.out.printf(" %-15s| %-10s\n", childName, giftString);
        }
    }

    private static void printFooter() {
        System.out.println("===========================");
    }
}
