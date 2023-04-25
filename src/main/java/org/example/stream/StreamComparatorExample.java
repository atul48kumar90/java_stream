package org.example.stream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamComparatorExample {

    public static List<Student> sortStudentByName(){
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(toList());
    }

    public static List<Student> sortStudentbyGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(toList());
    }

    public static void main(String[] args) {
            System.out.println("students sorted by name");
            sortStudentByName().forEach(System.out::println);
            System.out.println("students sorted by gpa");
            sortStudentbyGpa().forEach(System.out::println);
    }
}
