package ru.job4j.stack;

import java.util.*;

public class Brackets {
    public boolean isValid(String s) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Используемая память: %d байт\n", usedMemory);

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (!stack.isEmpty() && ((c == ')') && stack.peek() == '('
                    || ((c == '}') && stack.peek() == '{'
                    || ((c == ']') && stack.peek() == '[')))) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

