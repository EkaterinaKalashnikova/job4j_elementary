package ru.job4j.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartUI {
    boolean run = true;

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        SqlTracker tracker = new SqlTracker();
        List<Item> actions = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(100);
            Item item = new Item("Ekaterina" + i, i + "");
            System.out.println(item);
            System.out.println(i);
        }
    }

    void init(Input validate, Store tracker, UserAction[] actions) {
    }
}