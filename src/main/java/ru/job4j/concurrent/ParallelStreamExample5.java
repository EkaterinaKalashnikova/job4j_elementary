package ru.job4j.concurrent;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample5 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 2, 4, 1, 3);
        list.stream().parallel().forEachOrdered(System.out::println);
    }
}
