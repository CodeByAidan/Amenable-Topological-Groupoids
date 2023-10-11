package com.CodeByAidan.topologicalgroupoid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents a topological groupoid, a mathematical structure where a binary operation is defined.
 * The class provides methods to add elements, define composition, and check associativity
 * and the Følner condition.
 *
 * @author CodeByAidan
 * @version 1.0
 * @since 10/10/2023
 */
public class TopologicalGroupoid {

    private Map<GroupoidElement, Map<GroupoidElement, GroupoidElement>> compositionTable;

    /**
     * Constructs a new TopologicalGroupoid instance.
     */
    public TopologicalGroupoid() {
        this.compositionTable = new HashMap<>();
    }

    /**
     * Adds a new element to the topological groupoid.
     *
     * @param element The groupoid element to be added.
     */
    public void addElement(GroupoidElement element) {
        compositionTable.put(element, new HashMap<>());
    }

    /**
     * Defines the composition of two groupoid elements.
     *
     * @param source The source groupoid element.
     * @param target The target groupoid element.
     * @param result The result of the composition operation.
     */
    public void defineComposition(GroupoidElement source, GroupoidElement target, GroupoidElement result) {
        // Here, we define how the composition of elements is stored in the composition table.
        // source * target = result
        System.out.println(
            "Defining composition: " +
            source.getValue() +
            " * " +
            target.getValue() +
            " = " +
            result.getValue()
        );
        Map<GroupoidElement, GroupoidElement> innerMap = compositionTable.computeIfAbsent(
            source, k -> new HashMap<>()
        );
        innerMap.put(target, result);
    }

    /**
     * Composes two groupoid elements.
     *
     * @param a The first groupoid element.
     * @param b The second groupoid element.
     * @return The composition result or null if composition is not defined.
     */
    public GroupoidElement compose(GroupoidElement a, GroupoidElement b) {
        // Here, we look up the composition of elements from the composition table.
        Map<GroupoidElement, GroupoidElement> innerMap = compositionTable.get(a);
        if (innerMap != null) {
            GroupoidElement result = innerMap.get(b);
            if (result != null) {
                System.out.println(
                    "Composing: " +
                    a.getValue() +
                    " * " +
                    b.getValue() +
                    " = " +
                    result.getValue()
                );
                return result;
            }
        }
        System.out.println(
            "Composition not defined: " + a.getValue() + " * " + b.getValue()
        );
        return null;
    }

    /**
     * Checks if the topological groupoid satisfies the associativity property.
     *
     * @return True if the groupoid is associative, false otherwise.
     */
    public boolean isAssociative() {
        // Here, we iterate through the composition table and check associativity.
        // Associativity means (a * b) * c = a * (b * c) for all a, b, and c in the groupoid.
        // If the property holds for all combinations, return true. Otherwise, return false.
        for (GroupoidElement a : compositionTable.keySet()) {
            for (GroupoidElement b : compositionTable.get(a).keySet()) {
                for (GroupoidElement c : compositionTable.get(b).keySet()) {
                    GroupoidElement leftSide = compose(compose(a, b), c);
                    GroupoidElement rightSide = compose(a, compose(b, c));

                    if (
                        leftSide == null || rightSide == null || !leftSide.equals(rightSide)
                    ) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Checks if the topological groupoid satisfies the Følner condition for a given finite subset.
     *
     * @param finiteSubset The finite subset of groupoid elements to be checked.
     * @return True if the Følner condition is satisfied, false otherwise.
     */
    public boolean satisfiesFolnerCondition(Set<GroupoidElement> finiteSubset) {
        // Here, we check if the Følner condition is satisfied for the given finite subset.
        // The Følner condition checks if the set of elements and their compositions with
        // all other elements in the groupoid remains finite.
        // If the condition holds, return true. Otherwise, return false.
        Set<GroupoidElement> SFComposition = new HashSet<>();
        for (GroupoidElement s : finiteSubset) {
            for (GroupoidElement f : compositionTable.keySet()) {
                SFComposition.add(compose(s, f));
            }
        }

        Set<GroupoidElement> symmetricDifference = new HashSet<>(finiteSubset);
        symmetricDifference.addAll(SFComposition);
        symmetricDifference.removeAll(finiteSubset);

        double epsilon = (double) symmetricDifference.size() / finiteSubset.size();
        double epsilonThreshold = 0.01;

        return epsilon < epsilonThreshold;
    }
}
