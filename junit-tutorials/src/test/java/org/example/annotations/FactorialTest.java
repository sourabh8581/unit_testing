package org.example.annotations;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Factorial;
import org.junit.jupiter.api.Test;

public class FactorialTest {

  @Test
  protected void factorialTest(){
    Factorial factorial = new Factorial();
    int actualResult = factorial.factorial(5);

    assertEquals(120,actualResult);

  }
}