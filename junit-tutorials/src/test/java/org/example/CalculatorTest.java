package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Calculator Tests")
//@Disabled
class CalculatorTest {

  @DisplayName("Addition Test")
  @Test
  public void addTest(){
    Calculator calculator = new Calculator();
    int actualResult = calculator.add(10, 20);

    assertEquals(30,actualResult);
  }
  @DisplayName("Subtract Test")
  @Test
  @Disabled("Disabled untill feature is completely developed")
  public void subtractTest(){
    Calculator calculator = new Calculator();
    int actualResult = calculator.subtract(20, 10);

    assertEquals(10,actualResult);
  }

}