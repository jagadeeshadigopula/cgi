package com.stackroute.strings;

public class MaxCharacter {

    //write logic to find number format of given number , returns result
    public char findMaxCharacterCount(String input) {
        int asciiSize = 256;
        // Create array to keep the count of individual
        // characters and initialize the array as 0
        int count[] = new int[asciiSize];

        // Construct character count array from the input
        // string.
        int len = input.length();
        for (int i=0; i<len; i++)
            count[input.charAt(i)]++;

        int max = -1;  // Initialize max count
        char result = ' ';   // Initialize result

        // Traversing through the string and maintaining
        // the count of each character
        for (int i = 0; i < len; i++) {
            if (max < count[input.charAt(i)]) {
                max = count[input.charAt(i)];
                result = input.charAt(i);
            }
        }
        return result;
    }
}
