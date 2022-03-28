package com.bootcamp.teksystems.ood_exercises.template;

import com.bootcamp.teksystems.ood_exercises.template.enums.PartOfSpeech;

public abstract class Story {



    public void tellStory() {
        System.out.println("\nDoris " + getPastTenseVerb(1) + " there, " + getSingularNoun(1) + " on " + getSingularNoun(2) + ", " + getGerund(1) + " to figure out what to say. She’d " + getAdverb(1) + " " + getPastTenseVerb(2) + " up most of her standby phrases; things like, “Don’t forget, employees must wash their hands,” and “A " + getSingularNoun(3) + " will go a long way.” What worked for all the other ladies had not " + getPastTenseVerb(3) + " for this newest employee.\n" +
                "\n" +
                "“Wash your hands” had led to the new hire " + getAdverb(2) + " " + getGerund(2) + " one " + getSingularNoun(1) + ", " + getGerund(3) + " it, " + getGerund(4) + " it somewhat " + getAdverb(3) +", then " + getGerund(5) + " to repeat the process with the other one. Encouraging her to smile had sent the entire first grade " + getGerund(6) + " and " + getGerund(7) + " away from the " + getSingularNoun(4) + ".\n" +
                "\n" +
                "Today, Doris had come to " + getSingularNoun(5) + " ready for whatever " + getPastTenseVerb(4) + " to " + getSingularNoun(6) + ". She’d " + getPastTenseVerb(5) + " to ask her fellow long-timers what they " + getPastTenseVerb(6) + ". Looking " + getAdverb(4) + " around the " + getSingularNoun(7) + ", however, she " + getPastTenseVerb(7) + " they would not have any suggestions for the new " + getSingularNoun(8) + ". Rather, she had " + getPastTenseVerb(8) + " off on them " + getAdverb(1) + ". They " + getPastTenseVerb(1) + " in a similar " + getSingularNoun(9) + " to hers, listlessly " + getGerund(8) + " their heads about and " + getGerund(9) + ". Doris " + getPastTenseVerb(9) + " her " + getSingularNoun(10) + " anyway. Alerted, they all began " + getGerund(10) + " closer.");
    }


    public abstract String getGerund(int num);
    public abstract String getSingularNoun(int num);
    public abstract String getAdverb(int num);
    public abstract String getPastTenseVerb(int num);
}
