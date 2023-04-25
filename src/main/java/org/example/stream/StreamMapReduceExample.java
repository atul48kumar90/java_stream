package org.example.stream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

public class StreamMapReduceExample {

    private static int noOfNotebooks(){
        int noOfNotebooks = StudentDataBase.getAllStudents().stream()
                .filter((student -> student.getGradeLevel()>=3))
                .map(Student::getNoteBooks)
                .reduce(0,(a,b) -> a+b);

        return noOfNotebooks;
    }
    public static void main(String[] args) {
        System.out.println(noOfNotebooks());
    }
}
