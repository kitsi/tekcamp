package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.*;

import java.util.Random;

public class RandomStory extends Story{
    Random random = new Random();

    @Override
    public String getGerund(int num) {
        random.setSeed(num);
        String gerundToFind = "***";
        for(Gerund gerund : Gerund.values()) {
            if((random.nextInt(Gerund.values().length)+1 == gerund.id)) gerundToFind = gerund.name;
        }
        return gerundToFind;
    }

    @Override
    public String getWord(PartOfSpeech partOfSpeech, int num) {
        random.setSeed(num);
        String gerundToFind = "***";
        for(Gerund gerund : Gerund.values()) {
            if((random.nextInt(Gerund.values().length)+1) == gerund.id) gerundToFind = gerund.name;
        }
        return gerundToFind;
    }

    @Override
    public String getSingularNoun(int num) {
        random.setSeed(num);
        String nounToFind = "***";
        for(SingularNoun noun : SingularNoun.values()) {
            if((random.nextInt(SingularNoun.values().length)+1) == noun.id) nounToFind = noun.name;
        }
        return nounToFind;
    }

    @Override
    public String getAdverb(int num) {
        random.setSeed(num);
        String adverbToFind = "***";
        for(Adverb adverb : Adverb.values()) {
//            System.out.println("adverb values length: " + Adverb.values().length);
//            System.out.println("adverb random ids: " + (random.nextInt(Adverb.values().length)+1));
            if((random.nextInt(Adverb.values().length)+1) == adverb.id) adverbToFind = adverb.name;
        }
        return adverbToFind;
    }

    @Override
    public String getPastTenseVerb(int num) {
        random.setSeed(num);
        String verbToFind = "***";
        for(PastTenseVerb verb : PastTenseVerb.values()) {
            if((random.nextInt(PastTenseVerb.values().length)+1) == verb.id) verbToFind = verb.name;
        }
        return verbToFind;
    }
}
