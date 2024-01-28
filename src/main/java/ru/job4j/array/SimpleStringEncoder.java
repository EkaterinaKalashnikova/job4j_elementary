package ru.job4j.array;

public class SimpleStringEncoder {
    public static String encode(String input) {
        String result = "";
        char symbol = input.charAt(0);
        int counter = 0;
        char[] symbols = input.toCharArray();

        for (char ch : symbols) {
            if (ch != symbol) {
                result = getResult(result, symbol, counter);
                symbol = ch;
                counter = 1;
            } else {
                counter++;
            }
        }
        result = getResult(result, symbol, counter);
        return result;
    }

    private static String getResult(String result, char symbol, int counter) {
        result += String.valueOf(symbol);
        if (counter > 1) {
            result += counter;
        }
        return result;
    }
}

