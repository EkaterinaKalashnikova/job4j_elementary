package ru.job4j.concurrent;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample4 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().parallel().forEach(System.out::println);
    }
}
