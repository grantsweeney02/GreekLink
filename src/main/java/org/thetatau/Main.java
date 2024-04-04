package org.thetatau;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // read in json
        // initalize bigs with name
        // add all littles' prefs
        // add all bigs' prefs
        // run algo
        // print

        Person Grant  = new Person("Grant");
        ArrayList<Person> prefs = new ArrayList<>();
        prefs.add(Grant);
        Person Sarah = new Person("Sarah", prefs);
        Sarah.matched = Grant;
        System.out.println(Sarah);
    }
}