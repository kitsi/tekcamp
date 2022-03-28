package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.*;

import java.util.Arrays;
import java.util.List;

public class OriginalStory extends Story{

    private final List<Integer> adverbIds = Arrays.asList(1,2,3,4,1);
    private final List<Integer> pastTenseVerbIds = Arrays.asList(1,2,3,4,5,6,7,8,1,9);
    private final List<Integer> gerundIds = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    private final List<Integer> singularNounIds = Arrays.asList(1,2,3,1,4,5,6,7,8,9,10);
    private int adverbIdsIndex;
    private int gerundIdsIndex;
    private int pastVerbIdsIndex;
    private int singularNounIdsIndex;

    public OriginalStory() {
        this.adverbIdsIndex = 0;
        this.gerundIdsIndex = 0;
        this.pastVerbIdsIndex = 0;
        this.singularNounIdsIndex = 0;
    }

    @Override
    protected String getAdverb() {
        String adverbToFind = "**[Adverb]**";
        for(Adverb adverb : Adverb.values()) {
            if(adverb.id == adverbIds.get((adverbIdsIndex))) adverbToFind = adverb.name;
        }
        adverbIdsIndex++;
        return adverbToFind;
    }

    @Override
    protected String getPastTenseVerb() {
        String verbToFind = "**[PastTenseVerb]**";
        for(PastTenseVerb verb : PastTenseVerb.values()) {
            if(verb.id == pastTenseVerbIds.get((pastVerbIdsIndex))) verbToFind = verb.name;
        }
        pastVerbIdsIndex++;
        return verbToFind;
    }

    @Override
    protected String getGerund() {
        String gerundToFind = "**[Gerund]**";
        for(Gerund gerund : Gerund.values()) {
            if(gerund.id == gerundIds.get((gerundIdsIndex))) gerundToFind = gerund.name;
        }
        gerundIdsIndex++;
        return gerundToFind;
    }

    @Override
    protected String getSingularNoun() {
        String nounToFind = "**[SingularNoun]**";
        for(SingularNoun noun : SingularNoun.values()) {
            if(noun.id == singularNounIds.get((singularNounIdsIndex))) nounToFind = noun.name;
        }
        singularNounIdsIndex++;
        return nounToFind;
    }
}

