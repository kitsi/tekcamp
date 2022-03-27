package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.*;

import java.util.*;
import java.util.function.Supplier;

public class OriginalStory extends Story{

    public String getWord(PartOfSpeech partOfSpeech, int num) {
        Map<PartOfSpeech, Supplier<Enum[]>> operations = new EnumMap<>(PartOfSpeech.class) {{
            put(PartOfSpeech.ADVERB, Adverb::values);
            put(PartOfSpeech.GERUND, Gerund::values);
            put(PartOfSpeech.PAST_TENSE_VERB, PastTenseVerb::values);
            put(PartOfSpeech.SINGULAR_NOUN, SingularNoun::values);
        }};

        String wordToFind = "";

        for(Enum value : operations.get(partOfSpeech).get()) {
            if(value.getClass().equals(Gerund.class) && (((Gerund) value).id == num)) {
                wordToFind = ((Gerund) value).name;
            } else if(value.getClass().equals(Adverb.class) && (((Adverb) value).id == num)) {
                wordToFind = ((Adverb) value).name;
            } else if(value.getClass().equals(SingularNoun.class) && (((SingularNoun) value).id == num)) {
                wordToFind = ((SingularNoun) value).name;
            } else if(value.getClass().equals(PastTenseVerb.class) && (((PastTenseVerb) value).id == num)) {
                wordToFind = ((PastTenseVerb) value).name;
            }
        }
        return wordToFind;
    }

    // getGerund() method is not being called in the story
    // replaced by above getWord() method only for gerund so far
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

