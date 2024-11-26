package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int indexA = 0;
        int indexB = k - 1;
        int[] numsResult = {k};
        int i = 0;
        while (i < nums.length - 1) {
            while (i < k) {
                if (nums[i] < nums[i + 1]) {
                    i++;
                } else {
                    i = indexB;
                    indexA = i;
                    break;
                }
            }
            if (indexA != indexB) {
                numsResult = new int[]{indexA, indexB};
                break;
            }
            indexB = indexA + (k - 1);
        }
        if (nums.length - 1 < indexB) {
            return null;
        }
        return numsResult;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
