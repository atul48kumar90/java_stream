package org.example.parallelstream;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class parallelStreamExample1 {

    public static List<String> sequentialPrintStudentActivities() {

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        long endtime = System.currentTimeMillis();
        System.out.println("duration to execute the pipeline in sequential " +(endtime - startTime));

        return studentActivities;

    }

    public static List<String> parallelPrintStudentActivities() {

        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        long endtime = System.currentTimeMillis();
        System.out.println("duration to execute the pipeline in parallel " +(endtime - startTime));

        return studentActivities;

    }
    public static void main(String[] args) {
        sequentialPrintStudentActivities();
        parallelPrintStudentActivities();
    }
}
