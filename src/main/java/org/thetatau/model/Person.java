package org.thetatau.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
    public String name;
    public List<String> preferences;
    private Map<String, Integer> preferenceMap;
    Person match = null;

    public Person(String name) {
        this.name = name;
    }
    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
        this.preferenceMap = new HashMap<>();

        for(int i = 0; i < preferences.size(); i++) {
            String little = preferences.get(i);
            System.out.println( i + ") Adding " + little  + " to " + name);
            this.preferenceMap.put(little, i);
        }
    }

    public boolean prefers(Person newLittle) {
        if (this.match == null) {
            return true;
        }
        String currentLittleName = match.name;
        String newLittleName = newLittle.name;
        Integer currentLittleIndex = preferenceMap.getOrDefault(currentLittleName, preferences.size()+1);
        Integer newLittleIndex = preferenceMap.getOrDefault(newLittleName, preferences.size()+1);
        return newLittleIndex < currentLittleIndex;
    }

    public boolean isNotMatched() {
        return this.match == null;
    }

    public void removeMatch() {
        this.match = null;
    }

    public void setMatch(Person match) {
        this.match = match;
    }

    public Person getMatch() {
        return this.match;
    }

    @Override
    public String toString() {
        if(match != null) {
            return name + " - " + match.name;
        }
        if(preferences != null) {
            return name + " - " + preferences;
        }
        return name;
    }
}
