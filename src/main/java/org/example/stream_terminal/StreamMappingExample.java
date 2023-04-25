package org.example.stream_terminal;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class StreamMappingExample {

    public static void main(String[] args) {

        List<String> nameList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toList()));

        System.out.println(nameList);
    }
}
