package org.thetatau;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import org.thetatau.algorithm.MatchingAlgorithm;
import org.thetatau.model.Person;
import org.thetatau.util.JsonUtil;
import org.thetatau.util.PersonUtil;

public class Main {


    public static void main(String[] args) {
        JSONObject jsonData = JsonUtil.readJsonFromFile("src/main/resources/matching_preferences.json");

        Map<String, Person> bigs = PersonUtil.createPeopleFromJson(jsonData.getJSONObject("bigs"));
        Map<String, Person> littles = PersonUtil.createPeopleFromJson(jsonData.getJSONObject("littles"));

        System.out.println("\nUnMatched");
        printPairings(bigs, littles);

        MatchingAlgorithm.runMyAlgorithm(bigs, littles);
        System.out.println("\nAfter littles' Preferences");
        printPairings(bigs, littles);
        HashMap<String, Person> unMatchedBigs = PersonUtil.findUnMatchedPeople(bigs);
        HashMap<String, Person> unMatchedLittles = PersonUtil.findUnMatchedPeople(littles);
        if(!unMatchedBigs.isEmpty() || !unMatchedLittles.isEmpty()) {
            MatchingAlgorithm.runMyAlgorithm(unMatchedLittles, unMatchedBigs);
            System.out.println("\nAfter bigs' Preferences");
            printPairings(bigs, littles);
        }
        unMatchedBigs = PersonUtil.findUnMatchedPeople(bigs);
        unMatchedLittles = PersonUtil.findUnMatchedPeople(littles);

        if(!unMatchedBigs.isEmpty() || !unMatchedLittles.isEmpty()) {
            MatchingAlgorithm.runRandomAlgorithm(unMatchedBigs, unMatchedLittles);
        }


        System.out.println("\nFinal Matching");
        for (String s: bigs.keySet()) {
            System.out.println(bigs.get(s));
        }
    }

    private static void printPairings(Map<String, Person> bigs, Map<String, Person> littles) {
        for (String s : bigs.keySet()) {
            System.out.println(bigs.get(s));
        }
        for (String s : littles.keySet()) {
            System.out.println(littles.get(s));
        }
    }
}