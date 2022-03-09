package com.example.aem_engineering_test;

public class RomanNumeralResponseBody {
    private final String input;
    private final String output;

    public RomanNumeralResponseBody(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public String getInput() {
        return input;
    }

    public String getOutput() {
        return output;
    }
}
