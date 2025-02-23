package org.example.StreamPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);

        List<Integer> ans = numbers.stream().filter(x -> x%2==0).collect(Collectors.toList());

        
        System.out.println("result: " + ans);

    }
}
