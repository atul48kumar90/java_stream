package org.example.StreamPractice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list =Arrays.asList(10,15,20,25,30,35,40);
        List<Integer> numbers = Arrays.asList(5, 10, 15, 10, 20, 25, 5, 30);
        List<List<Integer>> listofLists = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5, 6),
            Arrays.asList(7, 8, 9)
        );

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

        System.out.println(" even number: " + evenNumbers.toString());
        System.out.println(" odd numbers: " + oddNumbers);
        System.out.println(" max: " + max);
        System.out.println(" min: " + min);
        System.out.println(" duplicates: " + duplicates);
        System.out.println(" secondHighest: " + secondHighest);
        System.out.println(" sum: " + stats.getSum() + " average: " + stats.getAverage() + " max: " + stats.getMax());
        System.out.println(" flattenList: " + flattenList);


        //deal with strings
        String input = "stream";
        List<String> names = Arrays.asList("John", "Emma", "Zara", "Alice");
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

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

        System.out.println(" fristNonRepeating: " + firstNonRepeating);
        System.out.println(" sorted name: " + sortedNames);
        System.out.println(" reverse sorted names: " + reverseSorted);
        System.out.println(" names in upper case: " + upperCase);
        System.out.println(" map: " + map);
    }
}
