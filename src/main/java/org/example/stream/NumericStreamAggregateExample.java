package org.example.stream;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {


        int sum = IntStream.rangeClosed(1,50).sum();
        OptionalInt optionalInt = IntStream.rangeClosed(1,50).max();

        System.out.println(sum);
        System.out.println(optionalInt);
    }
}
