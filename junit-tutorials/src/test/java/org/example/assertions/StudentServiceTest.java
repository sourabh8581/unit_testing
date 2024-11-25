package org.example.assertions;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.example.Student;
import org.example.StudentNotFoundException;
import org.example.StudentService;
import org.junit.jupiter.api.Test;

class StudentServiceTest {
  @Test
  public void getStudentsTest(){
    StudentService studentService = new StudentService();
    Student student = new Student(1,"Sourabh","Science");

    List<Student> students = studentService.getStudents();
    students.add(student);

    boolean actualResult = students.isEmpty();
//    assertTrue(actualResult);

//      assertTrue(()->actualResult);

//    assertTrue(actualResult,"Student list is empty");

//    assertTrue(actualResult,()->"List is empty");

    assertTrue(()->actualResult,()->"List of students is empty");
  }

  @Test
  public void getStudentsTestUsingAsserFalse(){
    StudentService studentService = new StudentService();
    List<Student> students = studentService.getStudents();
    Student student = new Student(1,"Snehal","Science");
//    students.add(student);
    boolean actualResult = students.isEmpty();

//    assertFalse(actualResult);
//    assertFalse(actualResult, "Student list is empty");
    assertFalse(actualResult,()->"Student list is empty");
  }

  @Test
  public void getStudentByIdTestUsingAssertNull(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"Sourabh","Science");
    studentService.addStudent(student);

    Student actualResult = studentService.getStudentById(1);

//    assertNull(actualResult);
//    assertNull(actualResult,"Student object is not null");
    assertNull(actualResult,()->"Student object is not null");
  }

  @Test
  public void getStudentByIdTestUsingAssertNotNull(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"Sourabh","Science");
    studentService.addStudent(student);

    Student actualResult = studentService.getStudentById(2);

//    assertNotNull(actualResult);
//    assertNotNull(actualResult,"The student object is null");
    assertNotNull(actualResult,()->"Student object is null");
  }

  @Test
  public void getStudentByIdTestUsingAssertEquals(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"Sourabh","Science");
    studentService.addStudent(student);

    Student actualResult = studentService.getStudentById(1);

//    assertEquals(1,actualResult.id);
//    assertEquals("Sourabh",actualResult.getName());
//    assertEquals(actualResult,student);
//    assertEquals(2,actualResult.getId(),"Student id is not equal");
    assertEquals(2,actualResult.getId(),()->"Student id is not equal");
  }

  @Test
  public void getStudentByIdTestUsingAssertNotEquals(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"Sourabh","Science");
    studentService.addStudent(student);

    Student actualResult = studentService.getStudentById(1);

//    assertNotEquals(2,actualResult.id);
//    assertEquals("Sourabh",actualResult.getName());
//    assertNotEquals(actualResult,student);
//    assertNotEquals(2,actualResult.getId(),"Student id is not equal");
    assertNotEquals(1,actualResult.getId(),()->"Student id is equal");
  }

  @Test
  public void getStudentNameByDepartmentTestUsingAssertArrayEquals(){
    StudentService studentService = new StudentService();

    Student student1 = new Student(1,"Sourabh","Science");
    Student student2 = new Student(2,"Snehal","Science");
    Student student3 = new Student(3,"Tanu","Science");

    String[] actual = studentService.getStudentNamesByDepartment("Science");
    String[] expected = {"Sourabh","Snehal","Tanu"};

    assertArrayEquals(expected,actual);
  }
  @Test
  public void getStudentNameByDepartmentTestUsingAssertIterableEquals(){
    StudentService studentService = new StudentService();

    Student student1 = new Student(1,"Sourabh","Science");
    Student student2 = new Student(2,"Snehal","Science");
    Student student3 = new Student(3,"Tanu","Science");
    studentService.addStudent(student1);
    studentService.addStudent(student2);
    studentService.addStudent(student3);

    List<String> actual = studentService.getStudentNamesListByDepartment("Science");
    List<String> expected = Arrays.asList("Sourabh","Snehal");

//    assertIterableEquals(expected,actual);
//    assertIterableEquals(expected,actual,"Student names list is not equal");
    assertIterableEquals(expected,actual,()->"Student names list is not equal");
  }

  @Test
  public void getStudentByIdUsingAssertThrows(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"sourabh","Science");
    studentService.addStudent(student);

//    assertThrows(StudentNotFoundException.class, ()->
//        studentService.getStudentByName("Snehal"));

//    assertThrows(StudentNotFoundException.class,()->
//        studentService.getStudentByName("sourabh"),
//        "Student not found exception to be thrown");

    assertThrows(RuntimeException.class,
        ()->studentService.getStudentByName("sourabh"),
        "StudentNotFound exception to be thrown");
  }

  @Test
  public void getStudentByIdUsingAssertThrowsExactly(){
    StudentService studentService = new StudentService();

    Student student = new Student(1,"sourabh","Science");
    studentService.addStudent(student);

//    assertThrowsExactly(StudentNotFoundException.class,
//        ()->studentService.getStudentByName("ramesh"));

    assertThrowsExactly(RuntimeException.class,
        ()->studentService.getStudentByName("ramesh"),
        "StudentNotFoundException to be thrown but it wasnt");
  }


}