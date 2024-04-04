package org.thetatau;
import java.util.List;

public class Person {
    public String name;
    public List<Person> preferences;

    Person matched;

    public Person(String name) {
        this.name = name;
    }
    public Person(String name, List<Person> preferences) {
        this.name = name;
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return name + " - " + matched.name;
    }
}
