package ru.job4j.algo;

import java.util.Arrays;
import java.util.LinkedList;

public class IntervalMerge {
    public int[][] merge(int[][] intervals) {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        System.out.printf("Используемая память: %d байт\n", usedMemory);

        Arrays.sort(intervals, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (!list.isEmpty() && list.getLast()[1] >= interval[0]) {
                while (!list.isEmpty() && list.getLast()[1] >= interval[0]) {
                        interval[0] = Math.min(list.getLast()[0], interval[0]);
                        interval[1] = Math.max(list.getLast()[1], interval[1]);
                        list.removeLast();
                    }
                }

                list.addLast(interval);
            }

            int pos = 0;
            int[][] result = new int[list.size()][];
            for (int[] i : list) {
                result[pos++] = i;
            }
            return result;
        }
    }


