package org.example.stream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.sql.SQLOutput;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFilterExample {

    public static List<Student> filterStudent(){
        return StudentDataBase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equals("female"))
                .collect(toList());
    }

    public static void main(String[] args) {
        System.out.println("filer student by gender");
        filterStudent().forEach(System.out::println);
    }
}
