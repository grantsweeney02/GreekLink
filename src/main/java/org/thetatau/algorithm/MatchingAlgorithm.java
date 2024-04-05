package org.thetatau.algorithm;

import org.thetatau.model.Person;

import java.util.*;

public class MatchingAlgorithm {
    public static void runMyAlgorithm(Map<String, Person> bigs, Map<String, Person> littles) {
        Queue<Person> unmatchedLittles = new LinkedList<>(littles.values());
        while (!unmatchedLittles.isEmpty()) {
            Person little = unmatchedLittles.poll();
            for (String bigName : little.preferences) {
                if(bigs.containsKey(bigName)) {
                    Person big = bigs.get(bigName);
                    if (big.isMatched()) {
                        big.setMatch(little);
                        little.setMatch(big);
                        break;
                    } else {
                        if (big.prefers(little)) {
                            Person currentMatchLittle = big.getMatch();
                           little.setMatch(big);
                            currentMatchLittle.removeMatch();
                            unmatchedLittles.add(currentMatchLittle);

                            big.setMatch(little);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void runRandomAlgorithm(Map<String, Person> bigs, Map<String, Person> littles) {
        List<Person> unmatchedBigs = new ArrayList<>(bigs.values());
        List<Person> unmatchedLittles = new ArrayList<>(littles.values());
        Collections.shuffle(unmatchedLittles);
        System.out.println("\nAssigning the rest randomly:");
        while (!unmatchedBigs.isEmpty() && !unmatchedLittles.isEmpty()) {
            Person big = unmatchedBigs.remove(0);
            Person little = unmatchedLittles.remove(0);
            big.setMatch(little);
            little.setMatch(big);
            System.out.println(big.name + " is randomly assigned to " + little.name);
        }
        if (!unmatchedBigs.isEmpty() || !unmatchedLittles.isEmpty()) {
            System.out.println("\nDue to a different number of bigs and littles, here are the rest to assign: ");
            unmatchedBigs.forEach(big -> System.out.println("Unmatched Big: " + big.name));
            unmatchedLittles.forEach(little -> System.out.println("Unmatched Little: " + little.name));
        }
    }
}
