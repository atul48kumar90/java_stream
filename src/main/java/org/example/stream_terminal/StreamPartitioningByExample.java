package org.example.stream_terminal;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;

public class StreamPartitioningByExample {

    public static void partitioningBy_1() {
        Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;
        Map<Boolean, List<Student>> partitioningMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate));

        System.out.println(partitioningMap);
    }

    public static void main(String[] args) {
         partitioningBy_1();
    }
}
