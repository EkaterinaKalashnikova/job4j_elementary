package ru.job4j.algo.hash;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Используемая память: %d байт\n", usedMemory);

        Map<Character, Integer> maps = new HashMap<>();
        String result = "";
        for (int in = 0, out = 0; out < str.length(); out++) {
            char ch = str.charAt(out);
            if (maps.containsKey(ch)) {
                in = Math.max(maps.get(ch) + 1, in);
            }
            if (result.length() < out - in + 1) {
                result = str.substring(in, out + 1);
            }
            maps.put(ch, out);
        }
        return result;
    }
}



