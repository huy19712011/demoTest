package com.example.demo.service;

import com.example.demo.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    private StudentService studentService;

    @BeforeEach
    void setUp() {

        studentService = new StudentService();
    }

    @Test
    void addStudentWithValidStudent() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        assertEquals(1, studentService.getAllStudents().size());
        System.out.println(student);
    }

    @Test
    void addStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(null));
        //assertThat(exception.getMessage()).isEqualTo("Student can not be null"); // way 1
        assertEquals("Student can not be null", exception.getMessage()); // way 2
    }

    @Test
    void addStudentWithInvalidName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(new Student(1, "Alice", 17, 9.0)));
        assertEquals("Age must be greater than 18", exception.getMessage());
    }

    @Test
    void addStudentWithInvalidMark() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.addStudent(new Student(1, "Alice", 20, 11.0)));
        assertEquals("Mark must be between 0 and 10", exception.getMessage());
    }


    @Test
    void getStudentByIdWithValidId() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        assertEquals(student, studentService.getStudentById(1));
    }

    @Test
    void getStudentByIdWithInvalidId() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        assertNull(studentService.getStudentById(2));
    }


    @Test
    void updateStudentWithValidStudent() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        student.setName("Bob");
        student.setAge(21);
        student.setMark(8.0);
        studentService.updateStudent(student);
        assertEquals("Bob", studentService.getStudentById(1).getName());
        assertEquals(21, studentService.getStudentById(1).getAge());
        assertEquals(8.0, studentService.getStudentById(1).getMark());
    }

    @Test
    void updateStudentWithNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> studentService.updateStudent(null));
        assertEquals("Student can not be null", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidName() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(new Student(1, "", 20, 9.0)));
        assertEquals("Name must not be null or empty", exception.getMessage());
    }

    @Test
    void updateStudentWithInvalidAge() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> studentService.updateStudent(new Student(1, "Alice", 17, 9.0)));
        assertEquals("Age must be greater than 18", exception.getMessage());
    }

    @Test
    void deleteStudentWithValidId() {

        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        studentService.deleteStudent(1);
        assertEquals(0, studentService.getAllStudents().size());
    }

    @Test
    void deleteStudentWithInvalidId() {
        Student student = new Student(1, "Alice", 20, 9.0);
        studentService.addStudent(student);
        assertFalse(studentService.deleteStudent(2));
    }

    @Test
    void getAllStudents() {

        Student student1 = new Student(1, "Alice", 20, 9.0);
        Student student2 = new Student(2, "Bob", 21, 8.0);
        studentService.addStudent(student1);
        studentService.addStudent(student2);
        assertEquals(2, studentService.getAllStudents().size());
    }
}