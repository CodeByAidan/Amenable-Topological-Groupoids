import com.CodeByAidan.topologicalgroupoid.GroupoidElement;
import com.CodeByAidan.topologicalgroupoid.TopologicalGroupoid;

import java.util.HashSet;
import java.util.Set;

/**
 * Main class to demonstrate the usage of TopologicalGroupoid and GroupoidElement classes.
 * This class creates a TopologicalGroupoid, adds elements to it, defines composition,
 * checks for the Følner condition, and tests associativity.
 *
 * @author CodeByAidan
 * @version 1.0
 * @since 10/10/2023
 */
public class Main {

    /**
     * The main entry point of the program. Creates a TopologicalGroupoid, adds elements,
     * defines composition, and tests conditions.
     *
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Create a TopologicalGroupoid instance
        TopologicalGroupoid groupoid = new TopologicalGroupoid();

        // Create GroupoidElement instances
        GroupoidElement a = new GroupoidElement(1);
        GroupoidElement b = new GroupoidElement(2);
        GroupoidElement c = new GroupoidElement(3);

        // Add elements to the groupoid
        groupoid.addElement(a);
        groupoid.addElement(b);
        groupoid.addElement(c);

        // Define composition between elements
        groupoid.defineComposition(a, b, c);

        // Create a finite subset of elements
        Set<GroupoidElement> finiteSubset = new HashSet<>();
        finiteSubset.add(a);
        finiteSubset.add(b);

        // Check if the finite subset satisfies the Følner condition
        boolean satisfiesFolner = groupoid.satisfiesFolnerCondition(finiteSubset);

        // Print results
        System.out.println("Does the finite subset satisfy the Følner condition? " + satisfiesFolner);
        System.out.println("Is the groupoid associative? " + groupoid.isAssociative());
    }
}