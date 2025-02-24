package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        students.add(student);
    }

    public Student getStudentById(long id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public void updateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException("Student can not be null");
        }

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                return;
            }
        }
    }

    public boolean deleteStudent(long id) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                return true;
            }
        }

        return false;
    }

    public List<Student> getAllStudents() {
        return students;
    }
}
