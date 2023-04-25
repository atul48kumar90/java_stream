package org.example.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamBoxingUnboxingExample {

    public static List<Integer> boxing(){
        return IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int unBoxing(List<Integer> integerList){
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {


        System.out.println("Boxing :" + boxing());

        List<Integer> integerList = boxing();

        System.out.println("Unboxing :" + unBoxing(integerList));
    }
}
