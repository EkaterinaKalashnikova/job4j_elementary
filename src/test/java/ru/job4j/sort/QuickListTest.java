package ru.job4j.sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class QuickListTest {
    @Test
    void whenSortThenOk() {
        User user1 = new User(1, "11");
        User user2 = new User(1, "22");
        User user3 = new User(3, "33");
        User user4 = new User(-4, "44");
        User user5 = new User(4, "55");
        User user6 = new User(6, "66");
        Comparator<User> comparator = Comparator.comparingInt(User::getId);
        List<User> listUser = new ArrayList<>();
        listUser.add(user3);
        listUser.add(user5);
        listUser.add(user1);
        listUser.add(user4);
        listUser.add(user6);
        listUser.add(user2);
        QuickList.quickSort(listUser, comparator);
        List<Integer> result = listUser.stream().map(User::getId).toList();
        System.out.println(result);
        assertThat(result).containsExactly(-4, 1, 1, 3, 4, 6);
    }

    @Test
    void whenReverseOrderThenOk() {
        Comparator<Integer> comparator = (a, b) -> b - a;
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(-8);
        list.add(1);
        list.add(0);
        list.add(10);
        list.add(1);
        list.add(8);
        QuickList.quickSort(list, comparator);
        System.out.println(list);
        assertThat(list).containsExactly(10, 8, 1, 1, 0, -2, -8);
    }

    @Test
    void whenListIntegerThenOk() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(1);
        list.add(5);
        Comparator<Integer> comparator = Integer::compareTo;
        QuickList.quickSort(list, comparator);
        System.out.println(list);
    }

    @Test
    void whenListStringThenOk() {
        List<String> strings = new ArrayList<>();
        strings.add("яблоко");
        strings.add("груша");
        strings.add("слива");
        strings.add("ананас");
        strings.add("вишня");
        Comparator<String> comparator = Comparator.comparingInt(String::length);
        QuickList.quickSort(strings, comparator);
        System.out.println(strings);
    }

    private static class User {
        private final Integer id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }
}
    