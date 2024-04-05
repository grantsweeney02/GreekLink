package org.thetatau.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.thetatau.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;


public class PersonUtil {
    public static Map<String, Person> createPeopleFromJson(JSONObject jsonObject) {
        Map<String, Person> people = new HashMap<>();
        jsonObject.keySet().forEach(name -> {
            List<String> preferences = jsonObject.getJSONArray(name).toList().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            Person person = new Person(name);
            person.setPreferences(preferences);
            people.put(name, person);
        });
        return people;
    }

    public static HashMap<String, Person> findUnMatchedPeople(Map<String, Person> people) {
        HashMap<String, Person> unMatchedPeople = new HashMap<String, Person>();
        for (String s: people.keySet()) {
            Person person = people.get(s);
            if(!person.isMatched()) {
                unMatchedPeople.put(s, person);
            }
        }
        return unMatchedPeople;
    }
}
