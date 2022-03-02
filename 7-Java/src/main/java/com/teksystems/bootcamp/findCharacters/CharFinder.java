package com.teksystems.bootcamp.findCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharFinder {

    public static HashMap<Character, List<Integer>> findMatchPositions(String charsToFind, String stringToSearch) {

        HashMap<Character, List<Integer>> charPositions = new HashMap<>();

        char[] arrOfChars = charsToFind.toLowerCase().toCharArray();
        for(char letter : arrOfChars) {
            List<Integer> indexes = new ArrayList<Integer>();
            int index = 0;

            while(index != -1) {
                index = stringToSearch.toLowerCase().indexOf(letter, index);
                if(index != -1) {
                    indexes.add(index);
                    index++;
                }
            }
            charPositions.put((Character) letter, indexes);
        }
        return charPositions;
    }
}
