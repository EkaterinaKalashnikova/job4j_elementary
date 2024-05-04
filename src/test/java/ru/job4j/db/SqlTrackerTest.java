package ru.job4j.db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.job4j.db.Item;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void add() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Рихтовка", "0");
        Item item1 = tracker.add(item);
        List<Item> itemList = tracker.findAll();
        assertTrue(itemList.contains(item1));
    }

    @Test
    public void replace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("Замена масла", "0");
        boolean b = tracker.replace("6", item);
        List<Item> itemList = tracker.findAll();
        assertEquals(itemList.contains(b), itemList.contains(6));
    }

    @Test
    public void delete() {
        SqlTracker tracker = new SqlTracker(connection);
        boolean b = tracker.delete("7");
        List<Item> itemList = tracker.findAll();
        assertFalse(itemList.contains(b));
    }

    @Test
    public void findAll() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> all = tracker.findAll();
        all.forEach(System.out::println);
    }

    @Test
    public void findByName() {
        SqlTracker tracker = new SqlTracker(connection);
        List<Item> byName = tracker.findByName("Рихтовка");
        byName.forEach(System.out::println);
    }

    @Test
    public void findById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item byId = tracker.findById("7");
        System.out.println(byId);
    }
}
