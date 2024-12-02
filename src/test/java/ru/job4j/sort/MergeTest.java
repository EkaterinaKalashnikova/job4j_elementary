package ru.job4j.sort;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {
    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenOddSorted() {
        int[] array = {10, 4, 6, 4, 8, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedManySameNumbers() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3, 6, 6, 2, 1, -13};
        assertThat(Merge.mergesort(array)).containsExactly(-13, -13, 1, 2, 2, 3, 4, 4, 6, 6, 6, 8, 10);
    }

    @Test
    void whenSortedOnlyZero() {
        int[] array = {0};
        assertThat(Merge.mergesort(array)).containsExactly(0);
    }

    @Test
    void whenSortedThisAndThat() {
        int[] array = {-1, 2, 6, 4, 8, -3, 2};
        assertThat(Merge.mergesort(array)).containsExactly(-3, -1, 2, 2, 4, 6, 8);
    }

    @Test
    void whenSortedIdentical() {
        int[] array = {5, 5, 5, 1, 5, 5, 5};
        assertThat(Merge.mergesort(array)).containsExactly(1, 5, 5, 5, 5, 5, 5);
    }
}
    
