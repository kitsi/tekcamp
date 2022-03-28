package com.bootcamp.teksystems.ood_exercises.template.enums;

public enum PartOfSpeech{
    ADVERB { @Override public void getPartOfSpeech() {}},
    GERUND { @Override public void getPartOfSpeech() {}},
    SINGULAR_NOUN {@Override public void getPartOfSpeech() {}},
    PAST_TENSE_VERB {@Override public void getPartOfSpeech() {}};
//    ADVERB { @Override public void getPartOfSpeech() {}},
//    GERUND { @Override public void getPartOfSpeech() {}},
//    SINGULAR_NOUN {@Override public void getPartOfSpeech() {}},
//    PAST_TENSE_VERB {@Override public void getPartOfSpeech() {}};

    public abstract void getPartOfSpeech();

//    public abstract void getPartofSpeech();

//    private Adverb adverb;
//    private Gerund gerund;
//    private SingularNoun noun;
//    private PastTenseVerb verb;

//    PartOfSpeech(Adverb adverb, Gerund gerund, SingularNoun noun, PastTenseVerb verb) {
//        this.adverb = adverb;
//        this.gerund = gerund;
//        this.noun = noun;
//        this.verb = verb;
//    }

//    ADVERB {@Override public Enum setEnum() {return Adverb;}},
//    GERUND {@Override public Enum setEnum() {return Gerund;}},
//    SINGULAR_NOUN {@Override public Enum setEnum() {return SingularNoun;}},
//    PAST_TENSE_VERB {@Override public Enum setEnum() {return PastTenseVerb;}};

//    public abstract Enum setEnum();
}

//public enum PartOfSpeech {
//    ADVERB {@Override public Enum setEnum() {return Adverb;}},
//    GERUND {@Override public Enum setEnum() {return Gerund;},
//    SINGULAR_NOUN {@Override public Enum setEnum() {return SingularNoun;},
//    PAST_TENSE_VERB {@Override public Enum setEnum() {return PastTenseVerb;};
//
//    public abstract Enum setEnum();
//}
