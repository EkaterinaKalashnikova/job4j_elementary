package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

class TopKFrequentWords692Test {

    @Test
    void testExampleCase() {
        TopKFrequentWords692 solution = new TopKFrequentWords692();
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> expected = List.of("i", "love");
        assertEquals(expected, solution.topKFrequent(words, k));
    }

    @Test
    void testSameFrequencyLexicographicalOrder() {
        TopKFrequentWords692 solution = new TopKFrequentWords692();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k = 4;
        List<String> expected = List.of("the", "is", "sunny", "day");
        assertEquals(expected, solution.topKFrequent(words, k));
    }

    @Test
    void testSingleWordRepeated() {
        TopKFrequentWords692 solution = new TopKFrequentWords692();
        String[] words = {"hello", "hello", "hello", "hello"};
        int k = 1;
        List<String> expected = List.of("hello");
        assertEquals(expected, solution.topKFrequent(words, k));
    }

    @Test
    void testAllWordsSameFrequency() {
        TopKFrequentWords692 solution = new TopKFrequentWords692();
        String[] words = {"a", "b", "c", "d", "e"};
        int k = 3;
        List<String> expected = List.of("a", "b", "c"); // Лексикографический порядок
        assertEquals(expected, solution.topKFrequent(words, k));
    }

    @Test
    void testKEqualsNumberOfWords() {
        TopKFrequentWords692 solution = new TopKFrequentWords692();
        String[] words = {"apple", "banana", "apple", "orange", "banana", "grape", "apple"};
        int k = 4;
        List<String> expected = List.of("apple", "banana", "grape", "orange");
        assertEquals(expected, solution.topKFrequent(words, k));
    }
}

    
