package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    int inputN, inputA, inputD, expectedL, expectedSum;
    @BeforeEach
    void setUpInput() throws ParseException {

        inputN = 10;
        inputA = -5;
        inputD = 5;

        expectedL = 40;
        expectedSum = 175;
    }

    @AfterEach
    void tearDown() {
        System.out.println("Running: tearDown");
    }

    @Test
    void testinputN(){

        assertTrue(inputN >= 0, "The input number of terms for arithmetic progression must be greater than 0");

    }

    @Test
    void testCalculatedL(){

        int calculatedL = inputA + inputD * (inputN - 1);
        assertEquals(expectedL, calculatedL);

        System.out.println("Expected the l term in the sequence: " + expectedL);
        System.out.println("Calculated l term in the sequence: " + calculatedL);

    }

    @Test
    void testCalculatedSum(){

        int calculatedL = inputA + inputD * (inputN - 1);
        int calculatedSum = ((inputA + calculatedL) * inputN) / 2;
        assertEquals(expectedSum, calculatedSum);

        System.out.println("Expected sum of a term of A.P.: " + expectedSum);
        System.out.println("Calculated sum of a term of A.P.: " + calculatedSum);

    }

    @Test
    void testInvalidInputShouldThrowInputMismatchException() {

        assertThrows(NumberFormatException.class, () -> {
                int invalidN = parseInteger("invalid-input");
            });
    }
    private int parseInteger(String input) {
        // Attempt to parse the string into an integer
        return Integer.parseInt(input);
    }

    @Test
    void testIncorrectInputFormatShouldThrowNumberFormatException() {
        // Use assertThrows to check if NumberFormatException is thrown
        assertThrows(NumberFormatException.class, () -> {
            calculateCalculatedL("non-integer-value", "another-non-integer-value", "yet-another-non-integer-value");
        });
    }

    private int calculateCalculatedL(String inputN, String inputA, String inputD) {
        try {
            int parsedN = Integer.parseInt(inputN);
            int parsedA = Integer.parseInt(inputA);
            int parsedD = Integer.parseInt(inputD);

            // Perform some calculation using parsedN, parsedA, and parsedD
            return parsedA + parsedD * (parsedN - 1);
        } catch (NumberFormatException e) {
            // If parsing fails, rethrow the exception
            throw e;
        }
    }
}
