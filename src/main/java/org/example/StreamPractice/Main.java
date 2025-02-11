package org.example.StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - $" + salary;
    }
}


public class Main {
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(10,15,20,25,30,35,40);
        List<Integer> numbers = Arrays.asList(5, 10, 15, 10, 20, 25, 5, 30);
        List<List<Integer>> listofLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        //deal with numbers
        List<Integer> evenNumbers = list.stream().filter(n -> n%2 ==0).collect(Collectors.toList());
        List<Integer> oddNumbers = list.stream().filter(n -> n%2 != 0).collect(Collectors.toList());
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        Set<Integer> duplicates = numbers.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()))
                                    .entrySet().stream()
                                    .filter(entry -> entry.getValue() > 1)
                                    .map(entry -> entry.getKey())
                                    .collect(Collectors.toSet());

        Optional<Integer> secondHighest = numbers.stream().distinct().sorted((a,b) -> b - a).skip(1).findFirst();
        IntSummaryStatistics stats = numbers.stream().mapToInt(n -> n).summaryStatistics();
        List<Integer> flattenList = listofLists.stream().flatMap(List::stream).collect(Collectors.toList());
        Optional<Integer> secondLargest = list.stream().distinct().sorted((a, b) -> b-a).skip(1).findFirst();

        int sumOfEvenNumber = numbers.stream().filter(x -> x%2 == 0).map(n -> n*n).reduce(0, Integer::sum);

        List<Integer> commonElement = list1.stream().filter(list2::contains).collect(Collectors.toList());

        boolean hasUniqueElement = numbers.size() == numbers.stream().collect(Collectors.toSet()).size();
        OptionalDouble average = numbers.stream().mapToDouble(Integer::doubleValue).average();
        Map<Boolean, List<Integer>> partitioned = numbers.stream().collect(Collectors.partitioningBy(n -> n%2 == 0));
        List<Integer> evenNo = partitioned.get(true);
        List<Integer> oddNo = partitioned.get(false);
        Set<Integer> set = listofLists.stream().map(HashSet::new).reduce((s1, s2) -> {
            s1.retainAll(s2);
            return s1;
        }).orElseGet((Supplier<? extends HashSet<Integer>>) Set.of());

        // System.out.println(" even number: " + evenNumbers.toString());
        // System.out.println(" odd numbers: " + oddNumbers);
        // System.out.println(" max: " + max);
        // System.out.println(" min: " + min);
        // System.out.println(" duplicates: " + duplicates);
        // System.out.println(" secondHighest: " + secondHighest);
        // System.out.println(" sum: " + stats.getSum() + " average: " + stats.getAverage() + " max: " + stats.getMax());
        // System.out.println(" flattenList: " + flattenList);
        //System.out.println(" second largest: " + secondLargest);
        //System.out.println(" sumOfEvenNumber: " + sumOfEvenNumber);
        //System.out.println("common element list: " + commonElement.toString());
        //System.out.println(" hasUniqueElement in list: " + hasUniqueElement);
        //System.out.println(" average: " + average);
        //System.out.println(" even number: " + evenNo.toString() + " odd number: " + oddNo.toString());
        System.out.println(" common set: " + set);


        //deal with strings
        String input = "stream";
        List<String> names = Arrays.asList("John", "Emma", "Zara", "Alice");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        List<String> palindromicWords = Arrays.asList("madam", "racecar", "hello", "level", "world");

        Character firstNonRepeating = input.chars().mapToObj(c -> (char)(c)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                                        .entrySet().stream()
                                        .filter(entry -> entry.getValue() == 1)
                                        .map(Map.Entry::getKey)
                                        .findFirst()
                                        .orElse(null);
        List<String> sortedNames = names.stream().sorted((s1, s2) -> s2.compareTo(s1)).collect(Collectors.toList());
        List<String> reverseSorted = names.stream().sorted((s1, s2) -> s1.compareTo(s2)).collect(Collectors.toList()); 
        List<String> upperCase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
        Map<String, Long> map = words.stream().collect(Collectors.groupingBy( word -> word, Collectors.counting()));
        Map<Character, Long> charOccurance = input.chars().mapToObj(c -> (char)(c)).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, List<String>> groupStringByLength = names.stream().collect(Collectors.groupingBy(String::length));
        String wordWithComma = words.stream().map(String::toUpperCase).collect(Collectors.joining(","));
        Optional<String> longestWord = words.stream().sorted((a,b) -> b.length() - a.length()).findFirst();
        Optional<String> maxOccurence = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                                            .stream().max(Map.Entry.comparingByValue())
                                            .map(Map.Entry::getKey);
        List<String> palindrome = palindromicWords.stream().filter( word -> word.equals(new StringBuilder(word).reverse().toString())).collect(Collectors.toList());


        // System.out.println(" fristNonRepeating: " + firstNonRepeating);
        // System.out.println(" sorted name: " + sortedNames);
        // System.out.println(" reverse sorted names: " + reverseSorted);
        // System.out.println(" names in upper case: " + upperCase);
        // System.out.println(" map: " + map);
        // System.out.println(" char occurance: " + charOccurance);
        //System.out.println(" groupStringByLength: " + groupStringByLength);
        // System.out.println(" word with comma: " + wordWithComma);
        //System.out.println(" longest word: " + longestWord);
        //System.out.println(" max occurance: " + maxOccurence);
        //palindrome.forEach(System.out::println);

        //number range
        int sum = IntStream.rangeClosed(0,50).sum();
        OptionalInt max_in_range = IntStream.rangeClosed(0,50).max();
        IntStream evenNumber = IntStream.rangeClosed(0,50).filter(x -> x%2 == 0);
        int even_sum = IntStream.rangeClosed(0,50).filter(x -> x%2 == 0).sum();
        OptionalInt max_even = IntStream.rangeClosed(0,49).filter(x -> x%2==0).max();

        //evenNumber.forEach(System.out::println);
        // System.out.println(" sum: " + sum);
        // System.out.println(" max_in_range: " + max_in_range);
        // System.out.println(" even_sum: " + even_sum);
        // System.out.println(" max_even: " + max_even);

        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 75000),
            new Employee("Charlie", 60000),
            new Employee("David", 90000)
        );

        List<Employee> sortedEmpList = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());

        //sortedEmpList.forEach(System.out::println);
    }
}
