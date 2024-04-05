package org.thetatau.model;
import java.util.List;

public class Person {
    public String name;
    public List<String> preferences;

    Person matched;

    public Person(String name) {
        this.name = name;
    }
    public void setPreferences(List<String> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return name + " - " + matched.name;
    }
}
