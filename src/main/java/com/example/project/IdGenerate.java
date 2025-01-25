package com.example.project;

public class IdGenerate {
    private static String currentId = "99";

    public static String getCurrentId() {
        return currentId;
    }

    public static void reset() {
        currentId = "99";
    }

    public static void generateID() {
        int IdInt = Integer.parseInt(currentId); 
        IdInt++;  
        currentId = Integer.toString(IdInt); 
    }
}
