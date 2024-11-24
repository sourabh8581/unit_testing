package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  public void addTest(){
    Calculator calculator = new Calculator();
    int actualResult = calculator.add(10, 20);

    assertEquals(30,actualResult);
  }

}