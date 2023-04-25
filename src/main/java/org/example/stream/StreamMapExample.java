package org.example.stream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {

    public static Set<String> namesSet(){
       Set<String> studentList =  StudentDataBase.getAllStudents()
               .stream()
               .map(Student::getName)
               .map(String::toUpperCase)
               .collect(Collectors.toSet());
       return studentList;
    }
    public static void main(String[] args) {
        System.out.println(namesSet());
    }
}
