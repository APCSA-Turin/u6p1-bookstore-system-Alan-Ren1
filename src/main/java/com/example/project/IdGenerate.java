package com.example.project;

public class IdGenerate {
    private static String currentId = "99"; // Static variable to store the current ID. Initially set to "99"

    // Getter method to retrieve the current ID
    public static String getCurrentId() {
        return currentId;
    }

    // Reset the current ID to its initial value, which is "99"
    public static void reset() {
        currentId = "99"; // Resets the current ID to the initial value "99"
    }

    // Generate the next ID by incrementing the current ID
    public static void generateID() {
        int IdInt = Integer.parseInt(currentId); // Convert the current ID (string) to an integer
        IdInt++;  // Increment the ID by 1
        currentId = Integer.toString(IdInt); // Convert the integer back to a string and update currentId
    }
}
