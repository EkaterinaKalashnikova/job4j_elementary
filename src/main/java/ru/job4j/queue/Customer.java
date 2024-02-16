package ru.job4j.queue;

public class Customer {

    private String name;
    private int amount;

    public Customer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + '}';
    }
}
