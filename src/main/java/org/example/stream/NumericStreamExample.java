package org.example.stream;

import java.util.stream.IntStream;

public class NumericStreamExample {

    public static int sumOfNumbersIntStream(){
        return IntStream.rangeClosed(1,6).sum();
    }
    public static void main(String[] args) {
        System.out.println(sumOfNumbersIntStream());
    }
}
