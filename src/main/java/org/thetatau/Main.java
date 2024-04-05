package org.thetatau;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import java.nio.charset.StandardCharsets;

import org.thetatau.model.Person;

public class Main {


    public static void main(String[] args) {



        JSONObject obj;


        try {
            ClassLoader classLoader = Main.class.getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("tester.json");
            if (inputStream == null) {
                throw new IllegalArgumentException("file not found!");
            } else {
                String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
                obj = new JSONObject(content);

                createPeople(obj);
            }
        } catch (IOException | JSONException e) {
            throw new RuntimeException(e);
        }


        // initalize bigs with name
        // add all littles' prefs
        // add all bigs' prefs
        // run algo
        // print
    }

    private static void createPeople(JSONObject obj) {

    }
}