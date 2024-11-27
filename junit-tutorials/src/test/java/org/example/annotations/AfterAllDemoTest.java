package org.example.annotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.example.Calculator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sun.util.resources.cldr.aa.CalendarData_aa_DJ;

public class AfterAllDemoTest {

  private static Calculator calculator;
  
  @BeforeAll
  static void setUp(){
    calculator=new Calculator();
    System.out.println("setUp method calling");
  }

  @AfterAll
  static void tearDownAfterClass(){
    calculator=null;
    System.out.println("tearDownAfterClass method calling");
  }

  @DisplayName("Addition Test")
  @Test
  public void addTest(){

    int actualResult = calculator.add(10, 20);

    assertEquals(30,actualResult);
    System.out.println("addTest() method calling");
  }

  @DisplayName("Subtract Test")
  @Test
  public void subtractTest(){

    int actualResult = calculator.subtract(20, 10);

    assertEquals(10,actualResult);
    System.out.println("subtractTest() method calling");
  }

}
