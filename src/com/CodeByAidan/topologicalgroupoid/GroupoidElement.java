package com.CodeByAidan.topologicalgroupoid;

/**
 * Represents an element in a groupoid.
 * A groupoid is a mathematical structure where a binary operation is defined.
 * GroupoidElement encapsulates the value of the element.
 *
 * @author CodeByAidan
 * @version 1.0
 * @since 10/10/2023
 */
public class GroupoidElement {

    private int value;

    /**
     * Constructs a GroupoidElement with the specified value.
     *
     * @param value The integer value of the groupoid element.
     */
    public GroupoidElement(int value) {
        this.value = value;
    }

    /**
     * Gets the value of the groupoid element.
     *
     * @return The integer value of the groupoid element.
     */
    public int getValue() {
        return value;
    }
}
