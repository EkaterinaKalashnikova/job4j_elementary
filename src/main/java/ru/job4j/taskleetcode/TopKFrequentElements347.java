package ru.job4j.taskleetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
        /** Create a Map to store the frequency of each number*/
        Map<Integer, Long> frequencyMap = Arrays.stream(nums)
                .boxed() /** box the ints to Integers*/
                .collect(Collectors.groupingBy(Function.identity(), // group by the number itself
                        Collectors.counting())); // count the frequency

        /** Initialize a min-heap based on the frequency values*/
        Queue<Map.Entry<Integer, Long>> minHeap = new PriorityQueue<>(Comparator.comparingLong(Map.Entry::getValue));

        /** Iterate over the frequency map*/
        for (Map.Entry<Integer, Long> entry : frequencyMap.entrySet()) {
            /** Insert the current entry into the min-heap*/
            minHeap.offer(entry);

            /** If the heap size exceeds 'k', remove the smallest frequency element*/
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        /** Extract the top 'k' frequent numbers from the min-heap into an array*/
        return minHeap.stream()
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}

