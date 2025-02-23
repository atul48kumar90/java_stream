package org.example.StreamPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamPractice2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30, 10, 15, 20, 30, 40, 50, 50);

        //filter even number
        List<Integer> ans = numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());
        //System.out.println("result: " + ans);

        //print duplicate number
        Set<Integer> res2 = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                            .entrySet().stream()
                            .filter(entry -> entry.getValue()>1)
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toSet());
        //System.out.println(" res2: " + res2);

        //Sort a List of Strings by Length
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");
        List<String> ans3 = words.stream().sorted(Comparator.comparingInt(String::length).reversed()
                            .thenComparing(Comparator.naturalOrder()))
                            .collect(Collectors.toList());
        //System.out.println(" res3: " + ans3);

        //Find the Second-Highest Number
        Optional<Integer> secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(" second highest number: " + secondHighest);
    }
}
