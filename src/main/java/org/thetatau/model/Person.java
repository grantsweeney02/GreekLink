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
        int i = 0;
        for(String s: preferences) {
            this.preferenceMap.put(s, i);
            i++;
        }
    }

    public boolean prefers(Person newLittle) {
        if (this.match == null) {
            return true;
        }
        String currentLittleName = match.name;
        String newLittleName = newLittle.name;
        Integer currentLittleIndex = preferenceMap.getOrDefault(currentLittleName, preferences.size()+1);
        currentLittleIndex = preferences.indexOf(currentLittleName);
        Integer newLittleIndex = preferenceMap.getOrDefault(newLittleName, preferences.size()+1);
        newLittleIndex = preferences.indexOf(newLittleName);
        if(currentLittleIndex == -1) {
            currentLittleIndex = preferences.size() +1;
        }
        if(newLittleIndex == -1) {
            newLittleIndex = preferences.size() +1;
        }
        System.out.println("Current Little Index: " + currentLittleName + " " + currentLittleIndex);
        System.out.println("New Little Index: " + newLittleName + " " + newLittleIndex);

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
