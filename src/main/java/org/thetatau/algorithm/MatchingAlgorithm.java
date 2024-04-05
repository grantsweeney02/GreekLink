package org.thetatau.algorithm;

import org.thetatau.model.Person;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MatchingAlgorithm {
    public static void runAlgorithm(Map<String, Person> bigs, Map<String, Person> littles) {
        Queue<Person> unmatchedLittles = new LinkedList<>(littles.values());
        while (!unmatchedLittles.isEmpty()) {
            Person little = unmatchedLittles.poll();
            for (String bigName : little.preferences) {
                if(bigs.containsKey(bigName)) {
                    Person big = bigs.get(bigName);
                    if (!big.isMatched()) {
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
}
