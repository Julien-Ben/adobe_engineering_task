package com.example.aem_engineering_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanNumeralConverterSpec {

    @Test
    @DisplayName("RomanNumeralConvert should throw an exception when input value is out of range")
    void romanNumeralConvertThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.romanNumeralConvert(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeralConverter.romanNumeralConvert(256));
    }

    @Test
    @DisplayName("RomanNumeralConvert should work for a list of known values")
    void romanNumeralConvertIsCorrect() {
        int[] inputList = {1, 3, 5, 18, 24, 78, 82, 97, 165, 255};
        String[] expectedOutputList = {"I", "III", "V", "XVIII", "XXIV", "LXXVIII", "LXXXII", "XCVII", "CLXV", "CCLV"};
        for (int i = 0; i < inputList.length; i++) {
            assertEquals(expectedOutputList[i], RomanNumeralConverter.romanNumeralConvert(inputList[i]));
        }
    }
}
