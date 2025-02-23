package org.example.StreamPractice;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (Salary: " + salary + ")";
    }
}

public class HighestSalary {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 5000),
                new Employee("Bob", 7000),
                new Employee("Charlie", 7000),
                new Employee("David", 6000)
        );

        List<Employee> highestPaidEmployees = findHighestSalaryEmployees(employees);

        System.out.println("Employees with the highest salary: " + highestPaidEmployees);
    }

    public static List<Employee> findHighestSalaryEmployees(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(emp -> emp.salary)) // Group by salary
                .entrySet().stream()
                .max(Map.Entry.comparingByKey()) // Find highest salary entry
                .map(Map.Entry::getValue) // Get employees with max salary
                .orElse(Collections.emptyList()); // Return empty list if no employees
    }
}
