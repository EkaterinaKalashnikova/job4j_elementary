package ru.job4j.stream;

import java.util.List;
import java.util.Optional;

public class ReduceExampleOne {
    public static void main(String[] args) {
        List<String> nums = List.of("Один", "Два", "Три");
        Optional<String> sum = nums.stream()
                .reduce((left, right) -> left + ", " + right);
        System.out.println(sum.get());
    }
}
