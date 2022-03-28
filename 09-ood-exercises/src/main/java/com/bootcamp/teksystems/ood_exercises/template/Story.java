package com.bootcamp.teksystems.ood_exercises.template;

public abstract class Story {



    public void tellStory() {
        System.out.println("\nDoris " + getPastTenseVerb() + " there, " + getSingularNoun() + " on " + getSingularNoun() + ", " + getGerund() + " to figure out what to say. She’d " + getAdverb() + " " + getPastTenseVerb() + " up most of her standby phrases; things like, “Don’t forget, employees must wash their hands,” and “A " + getSingularNoun() + " will go a long way.” What worked for all the other ladies had not " + getPastTenseVerb() + " for this newest employee.\n" +
                "\n" +
                "“Wash your hands” had led to the new hire " + getAdverb() + " " + getGerund() + " one " + getSingularNoun() + ", " + getGerund() + " it, " + getGerund() + " it somewhat " + getAdverb() +", then " + getGerund() + " to repeat the process with the other one. Encouraging her to smile had sent the entire first grade " + getGerund() + " and " + getGerund() + " away from the " + getSingularNoun() + ".\n" +
                "\n" +
                "Today, Doris had come to " + getSingularNoun() + " ready for whatever " + getPastTenseVerb() + " to " + getSingularNoun() + ". She’d " + getPastTenseVerb() + " to ask her fellow long-timers what they " + getPastTenseVerb() + ". Looking " + getAdverb() + " around the " + getSingularNoun() + ", however, she " + getPastTenseVerb() + " they would not have any suggestions for the new " + getSingularNoun() + ". Rather, she had " + getPastTenseVerb() + " off on them " + getAdverb() + ". They " + getPastTenseVerb() + " in a similar " + getSingularNoun() + " to hers, listlessly " + getGerund() + " their heads about and " + getGerund() + ". Doris " + getPastTenseVerb() + " her " + getSingularNoun() + " anyway. Alerted, they all began " + getGerund() + " closer.");
    }


    public abstract String getAdverb();
    public abstract String getPastTenseVerb();
    public abstract String getGerund();
    public abstract String getSingularNoun();
}
