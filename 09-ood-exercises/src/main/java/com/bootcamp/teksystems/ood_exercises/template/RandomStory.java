package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.*;

import java.util.Random;

public class RandomStory extends Story{
    Random random = new Random();
    int seed;

    public RandomStory(int seed) {
        this.seed = seed;
        random.setSeed(seed);
    }

    @Override
    public String getAdverb() {
        String adverbToFind = "**[Adverb]**";
        int idx = random.nextInt(Adverb.values().length)+1;
        for(Adverb adverb : Adverb.values()) {
            if(idx == adverb.id) adverbToFind = adverb.name;
        }
        return adverbToFind;
    }

    @Override
    public String getPastTenseVerb() {
        String verbToFind = "**[PastTenseVerb]**";
        int idx = random.nextInt(PastTenseVerb.values().length)+1;
        for(PastTenseVerb verb : PastTenseVerb.values()) {
            if(idx == verb.id) verbToFind = verb.name;
        }
        return verbToFind;
    }

    @Override
    public String getGerund() {
        String gerundToFind = "**[Gerund]**";
        int idx = random.nextInt(Gerund.values().length)+1;
        for(Gerund gerund : Gerund.values()) {
            if(idx == gerund.id) gerundToFind = gerund.name;
        }
        return gerundToFind;
    }

    @Override
    public String getSingularNoun() {
        String nounToFind = "**[SingularNoun]**";
        int idx = random.nextInt(SingularNoun.values().length)+1;
        for(SingularNoun noun : SingularNoun.values()) {
            if(idx == noun.id) nounToFind = noun.name;
        }
        return nounToFind;
    }
}
