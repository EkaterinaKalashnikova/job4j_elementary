package ru.job4j.taskleetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TopKFrequentElements347Test {
    @Test
    void whenSingleElementThenReturnIt() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{1}, 1);
        assertThat(result).containsExactly(1);
    }

    @Test
    void whenTwoElementsSameFrequencyThenReturnBoth() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{1, 2}, 2);
        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void whenThreeElementsDifferentFrequencyThenReturnTopTwo() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{1, 1, 2, 2, 2, 3}, 2);
        assertThat(result).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void whenAllElementsDifferentThenReturnTopK() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{1, 2, 3, 4, 5}, 3);
        assertThat(result.length).isEqualTo(3);
    }

    @Test
    void whenKIsOneThenReturnMostFrequentElement() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{4, 4, 4, 2, 2, 3}, 1);
        assertThat(result).containsExactly(4);
    }

    @Test
    void whenAllElementsSameThenReturnThatElement() {
        TopKFrequentElements347 solver = new TopKFrequentElements347();
        int[] result = solver.topKFrequent(new int[]{7, 7, 7, 7}, 1);
        assertThat(result).containsExactly(7);
    }
}
    
