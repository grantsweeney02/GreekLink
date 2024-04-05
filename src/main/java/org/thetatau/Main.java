package org.thetatau;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.thetatau.algorithm.MatchingAlgorithm;
import org.thetatau.model.Person;
import org.thetatau.util.JsonUtil;
import org.thetatau.util.PersonUtil;

public class Main {


    public static void main(String[] args) {
        // Retrieve JSON as a String
        JSONObject jsonData = JsonUtil.readJsonFromFile("src/main/resources/tester.json");

        Map<String, Person> bigs = PersonUtil.createPeopleFromJson(jsonData.getJSONObject("bigs"));
        Map<String, Person> littles = PersonUtil.createPeopleFromJson(jsonData.getJSONObject("littles"));

        System.out.println("\nUnMatched");
        for (String s: bigs.keySet()) {
            System.out.println(bigs.get(s));
        }
        for (String s: littles.keySet()) {
            System.out.println(littles.get(s));
        }

        MatchingAlgorithm.runAlgorithm(bigs, littles);
        System.out.println("\nAfter little's' Preferences");
        for (String s: bigs.keySet()) {
            System.out.println(bigs.get(s));
        }
        for (String s: littles.keySet()) {
            System.out.println(littles.get(s));
        }
        HashMap<String, Person> unMatchedBigs = PersonUtil.findUnMatchedPeople(bigs);
        HashMap<String, Person> unMatchedLittles = PersonUtil.findUnMatchedPeople(littles);
        MatchingAlgorithm.runAlgorithm(unMatchedLittles, unMatchedBigs);

        System.out.println("\nFinal Matching");
        for (String s: bigs.keySet()) {
            System.out.println(bigs.get(s));
        }
        for (String s: littles.keySet()) {
            System.out.println(littles.get(s));
        }
        // Create bigs and littles


        // initalize bigs with name
        // add all littles' prefs
        // add all bigs' prefs
        // run algo
        // print
    }

    private static void createPeople(JSONObject obj) {

    }
}