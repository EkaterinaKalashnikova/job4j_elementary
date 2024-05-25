package ru.job4j.array;

public class FindLoop {
    public static int indexInRange(int[] data, int element, int start, int finish) {
        for (int i = start; i <= finish; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }
}



