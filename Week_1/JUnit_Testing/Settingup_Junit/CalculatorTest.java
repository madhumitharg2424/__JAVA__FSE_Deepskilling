package com.cts.junit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
Calculator calculator = new Calculator();

@Test
void testAddition() {
    assertEquals(10, calculator.add(5, 5));
}

@Test
void testSubtraction() {
    assertEquals(4, calculator.subtract(10, 6));
}

@Test
void testMultiplication() {
    assertEquals(20, calculator.multiply(4, 5));
}
}