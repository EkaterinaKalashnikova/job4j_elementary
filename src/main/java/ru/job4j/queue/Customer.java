package ru.job4j.queue;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return getAmount() == customer.getAmount()
                && getName().equals(customer.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAmount());
    }
}
