package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;

public class MatchExampleAny {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Один", "Два", "Три", "Четыре", "Пять");
        boolean result = strings
                .stream()
                .anyMatch(element -> element.endsWith("ь"));
        System.out.println(result);
    }
}
