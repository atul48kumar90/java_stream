package org.example.stream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.Optional;

public class StreamFindAnyFirstExample {

    public static Optional<Student> findAnyStudent(){
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.9)
                .findAny();
    }
    public static void main(String[] args) {
        Optional<Student> studentOptional = findAnyStudent();
        if(studentOptional.isPresent())
        {
            System.out.println(studentOptional.get());
        }else{
            System.out.println("Student not found");
        }
    }
}
