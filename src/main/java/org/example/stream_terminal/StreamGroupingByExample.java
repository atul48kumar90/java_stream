package org.example.stream_terminal;

import org.example.data.Student;
import org.example.data.StudentDataBase;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class StreamGroupingByExample {

    public static void groupStudentByGender(){
        Map<String, List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));

        System.out.println(studentMap);
    }

    public static void customizedGroupingBy(){
        Map<String,List<Student>> studentMap = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa()>=3.8 ? "outstanding" : "Average"));

        System.out.println(studentMap);
    }

    public static void twoLevelGrouping_1(){
       Map<Integer,Map<String,List<Student>>> studentMap =  StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        groupingBy(student -> student.getGpa()>=3.8 ? "outstanding" : "Average")));

        System.out.println(studentMap);
    }

    public static void main(String[] args) {
        //groupStudentByGender();
        //customizedGroupingBy();
        twoLevelGrouping_1();
    }
}
