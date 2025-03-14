package com.example.task02;

import java.util.stream.IntStream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(2)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {
        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("n must be between 1 and 16");
        }

        int max = 1 << n; // 2^n

        return IntStream.iterate(0, x -> (x + 1) % max) // Генерируем числа от 0 до 2^n - 1, циклично
                .map(x -> x ^ (x >> 1)); // Преобразуем число в код Грея
    }

}
