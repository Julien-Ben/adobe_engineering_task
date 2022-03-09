package com.example.aem_engineering_test;

public class RomanNumeralConverter {
    /** Convert an integer to its roman numeral representation (a String) and returns it.
     *
     * @param inputVal the value to convert to a roman numeral, must be an integer between 1 and 255.
     * @throws IllegalArgumentException if the input value is not in the range 1-255.
     * @return The string representation of the roman numeral corresponding to the input.
     */
    public static String romanNumeralConvert(int inputVal) {
        //The idea of my algorithm is to substract the biggest possible "intermediary value" multiple times
        //And build the number iteratively, until we reach 0

        if (inputVal < 1 || inputVal > 255) {
            throw new IllegalArgumentException("Input value must be between 1 and 255.");
        }

        int[] intermediaryValues = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanRepresentation = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int biggestValueIndex = 0;
        int reminder = inputVal;
        StringBuilder result = new StringBuilder();
        while (reminder > 0) {
            if (reminder >= intermediaryValues[biggestValueIndex]) {
                result.append(romanRepresentation[biggestValueIndex]);
                reminder -= intermediaryValues[biggestValueIndex];
            } else {
                biggestValueIndex++;
            }
        }
        return result.toString();
    }
}
