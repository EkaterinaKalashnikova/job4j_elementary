package ru.job4j.queue;

import java.util.Objects;

public record Customer(String name, int amount) {
    @Override
    public String toString() {
        return "Customer{"
                + "name='" + name + '\''
                + '}';
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
