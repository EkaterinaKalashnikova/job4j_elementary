package ru.job4j.calculator;

public class TwoNumberSum {
    public static int[] getIndex(int[] array, int target) {
        /**int i = 0;
         int j = 0;
         while (j < array.length) {
         if (array[i] + array[j] == target) {
         break;
         }
         if (array[i] + array[j] != target) {
         i++;
         j++;
         }
         }
         return new int[0];
         }*/
        if (array == null) {
            throw new IllegalArgumentException("Массив не должен быть null");
        }
        if (array.length < 2) {
            throw new IllegalArgumentException("Массив должен содержать как минимум два элемента");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
