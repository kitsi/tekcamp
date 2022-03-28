package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.*;

public class OriginalStory extends Story{

    @Override
    public String getGerund(int num) {
        String gerundToFind = "";
        for(Gerund gerund : Gerund.values()) {
            if(num == gerund.id) gerundToFind = gerund.name;
        }
        return gerundToFind;
    }

    @Override
    public String getSingularNoun(int num) {
        String nounToFind = "";
        for(SingularNoun noun : SingularNoun.values()) {
            if(num == noun.id) nounToFind = noun.name;
        }
        return nounToFind;
    }

    @Override
    public String getAdverb(int num) {
        String adverbToFind = "";
        for(Adverb adverb : Adverb.values()) {
            if(num == adverb.id) adverbToFind = adverb.name;
        }
        return adverbToFind;
    }

    @Override
    public String getPastTenseVerb(int num) {
        String verbToFind = "";
        for(PastTenseVerb verb : PastTenseVerb.values()) {
            if(num == verb.id) verbToFind = verb.name;
        }
        return verbToFind;
    }
}

