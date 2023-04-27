package org.example.parallelstream;

import java.util.stream.IntStream;

public class parallelStreamExample {

    public static int sum_sequential_stream(){
        return IntStream.rangeClosed(1,100000)
                .sum();
    }

    public static int sum_parallel_stream(){
        return IntStream.rangeClosed(1,100000)
                .parallel()
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(sum_sequential_stream());

        System.out.println(sum_parallel_stream());

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
