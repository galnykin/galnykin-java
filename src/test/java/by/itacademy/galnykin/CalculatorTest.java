package by.itacademy.galnykin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void createCalculator() {
        calculator = new Calculator();
    }

    // Sum tests
    @Test
    @DisplayName("Sum of two positive numbers should return correct result")
    void sum_TwoPositiveNumbers_ReturnsCorrectSum() {
        // Arrange
        int a = 2;
        int b = 3;
        int expected = 5;

        // Act
        int result = calculator.sum(a, b);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    // Subtract tests
    @Test
    @DisplayName("Subtraction of two positive numbers should return correct result")
    void subtract_TwoPositiveNumbers_ReturnsCorrectDifference() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 2;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expected, result);
    }
}
