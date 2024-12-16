package ru.job4j.newcoll.tree;

import lombok.Getter;

public class SimpleStack<T> {
    private final ForwardLinked<T> linked = new ForwardLinked<>();
    @Getter
    private int size;

    public int size() {
        return this.size;
    }

    public T pop() {
        T value;
        value = linked.deleteLast();
        size--;
        return value;
    }

    public void push(T value) {
        this.linked.add(value);
        size++;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }
}