package ru.job4j.taskleetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BinarySearch704Test {
    @Test
    void whenTargetExistsThenReturnIndex() {
        BinarySearch704 searcher = new BinarySearch704();
        int[] nums = {-5, -3, 0, 2, 4, 7, 9, 12};
        assertThat(searcher.search(nums, 4)).isEqualTo(4);
        assertThat(searcher.search(nums, -3)).isEqualTo(1);
        assertThat(searcher.search(nums, 9)).isEqualTo(6);
    }

    @Test
    void whenTargetDoesNotExistThenReturnMinusOne() {
        BinarySearch704 searcher = new BinarySearch704();
        int[] nums = {-5, -3, 0, 2, 4, 7, 9, 12};
        assertThat(searcher.search(nums, 5)).isEqualTo(-1);
        assertThat(searcher.search(nums, -4)).isEqualTo(-1);
        assertThat(searcher.search(nums, 15)).isEqualTo(-1);
    }

    @Test
    void whenSingleElementAndTargetFoundThenReturnZero() {
        BinarySearch704 searcher = new BinarySearch704();
        int[] nums = {7};
        assertThat(searcher.search(nums, 7)).isEqualTo(0);
    }

    @Test
    void whenSingleElementAndTargetNotFoundThenReturnMinusOne() {
        BinarySearch704 searcher = new BinarySearch704();
        int[] nums = {7};
        assertThat(searcher.search(nums, 5)).isEqualTo(-1);
    }

    /**  @Test
    void whenEmptyArrayThenReturnMinusOne() {
        BinarySearch704 searcher = new BinarySearch704();
        int[] nums = {};
        assertThat(searcher.search(nums, 10)).isEqualTo(-1);
    }*/
}
    
