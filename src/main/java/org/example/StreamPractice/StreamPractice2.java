package org.example.StreamPractice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape", "ankle");
        List<String> ans3 = words.stream().sorted(Comparator.comparingInt(String::length).reversed()
                            .thenComparing(Comparator.naturalOrder()))
                            .collect(Collectors.toList());
        //System.out.println(" res3: " + ans3);

        //Find the Second-Highest Number
        Optional<Integer> secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        //System.out.println(" second highest number: " + secondHighest);

        //count word start with given alphabet
        long count = words.stream().filter(x -> x.startsWith("a")).count();
        //System.out.println(" word start with a :" + count);

        //find sum pf square of odd number
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfOddSquare = nums.stream().filter(x -> x%2==1).map(x -> x*x).reduce(0, Integer::sum);
        //System.out.println(" sum of odd square: " + sumOfOddSquare);

        //merge two list into a single list
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream()).distinct().sorted().collect(Collectors.toList());
        List<Integer> mergedList2 = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
        //System.out.println(" merged list 1: " + mergedList);
        //System.out.println(" merged list 2: " + mergedList2);

        //Find the Most Frequent Element in a List
        List<String> words2 = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        String mostFrequent = words2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).toString();
        //System.out.println(" most frequent element: " + mostFrequent);

        //Find the Kth Largest Element
        List<Integer> numbers4 = Arrays.asList(3, 2, 1, 5, 6, 4);
        int k = 2;
        Optional<Integer> kLargestNumber = numbers4.stream().sorted(Comparator.reverseOrder()).skip(k-1).findFirst();
        System.out.println(" kth largest number: " + kLargestNumber);


    }
}
