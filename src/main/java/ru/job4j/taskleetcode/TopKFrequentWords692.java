package ru.job4j.taskleetcode;

import java.util.*;

public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        /** Map to store the frequency count of each word*/
        Map<String, Integer> wordCount = new HashMap<>();
        /** Calculate the frequency of each word*/
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        /** Priority Queue to store words based on their frequency and lexicographical order*/
        PriorityQueue<String> heap = new PriorityQueue<>((word1, word2) -> {
            int frequencyDifference = wordCount.get(word1) - wordCount.get(word2);
            /** If frequencies are the same, compare words in reverse lexicographical order*?*/
            if (frequencyDifference == 0) {
                return word2.compareTo(word1);
            }
            /** Otherwise, order by frequency*/
            return frequencyDifference;
        });

        /** Iterate over the distinct words and add them to the Priority Queue*/
        /** The heap will maintain the top k frequent elements on top*/
        for (String word : wordCount.keySet()) {
            heap.offer(word);
            /** If heap size exceeds k, remove the least frequent/current smallest element*/
            if (heap.size() > k) {
                heap.poll();
            }
        }

        /** LinkedList to store the result in correct order*/
        LinkedList<String> topKWords = new LinkedList<>();
        /** Populating the result list in reverse order since we want the highest frequency on top*/
        while (!heap.isEmpty()) {
            topKWords.addFirst(heap.poll());
        }

        /** Return the list of top k frequent words*/
        return topKWords;
    }
}
/**
public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        // Map для хранения частоты слов
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // PriorityQueue для хранения слов по частоте и алфавиту
        PriorityQueue<String> heap = new PriorityQueue<>(
                Comparator.comparingInt(wordCount::get)
                        .thenComparing(Comparator.reverseOrder())
        );

        // Добавляем слова в кучу
        for (String word : wordCount.keySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll(); // Удаляем наименее частое слово
            }
        }

        // Составляем список результатов
        List<String> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
        Collections.reverse(result);
        return result;
    }
}
*/
