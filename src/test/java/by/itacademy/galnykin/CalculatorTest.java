package by.itacademy.galnykin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void createCalculator() {
        calculator = new Calculator();
    }

    // Sum tests
    @Test
    @Order(1)
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
    @Order(2)
    @DisplayName("Subtraction of two positive numbers should return correct result")
    void testSubtractTwoPositiveNumbersReturnsCorrectDifference() {
        // Arrange
        int a = 5;
        int b = 3;
        int expected = 2;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        Assertions.assertEquals(expected, result);
    }

    // Multiply tests
    @Test
    @Order(4)
    @DisplayName("Multiplication of two positive numbers should return positive result")
    void multiply_TwoPositiveNumbers_ReturnsPositiveResult() {
        // Arrange
        int a = 3;
        int b = 2;
        int expected = 6;

        // Act
        int result = calculator.multiply(a, b);

        // Assert
        Assertions.assertEquals(expected, result);
    }


    // Divide tests
    @Test
    @Order(3)
    @DisplayName("Division of two positive numbers should return correct result")
    void divide_TwoPositiveNumbers_ReturnsCorrectQuotient() {
        // Arrange
        int a = 6;
        int b = 2;
        double expected = 3.0;
        double delta = 0.0001;

        // Act
        double result = calculator.divide(a, b);

        // Assert
        Assertions.assertEquals(expected, result, delta);
    }
}
