package ru.job4j.db;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

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
        Item item = tracker.add(new Item("name"));
        Item rsl = tracker.findById(item.getId());
        assertThat(rsl.getId()).isEqualTo(item.getId());
        assertThat(rsl.getName()).isEqualTo(item.getName());
        assertThat(tracker.findByName("name").size()).isEqualTo(1);
    }

    @Test
    public void replace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("name"));
        Item replacement = new Item("new name", item.getId());
        tracker.replace(item.getId(), replacement);
        Item result = tracker.findById(item.getId());
        assertThat(replacement.getName()).isEqualTo(result.getName());
        assertThat(replacement.getId()).isEqualTo(result.getId());
    }

    @Test
    public void delete() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("name"));
        Item result = tracker.findById(item.getId());
        assertThat(item.getName()).isEqualTo(result.getName());
        assertThat(item.getId()).isEqualTo(result.getId());
    }

    @Test
    public void findAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item[] items = new Item[2];
        items[0] = tracker.add(new Item("name", "1"));
        items[1] = tracker.add(new Item("name1", "2"));
        Item[] rsl = tracker.findAll().toArray(new Item[0]);
        for (int i = 0; i < items.length; i++) {
            System.out.println(Arrays.toString(rsl));
            System.out.println();
        }
    }

    @Test
    public void findByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("name", "1"));
        Item[] rsl = tracker.findByName("name").toArray(new Item[0]);
        assertThat(rsl[0].getId()).isEqualTo(item.getId());
        assertThat(rsl[0].getName()).isEqualTo(item.getName());
    }

    @Test
    public void findById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("name", "1"));
        Item byId = tracker.findById(item.getId());
        System.out.println(byId);
        assertThat(byId).isEqualTo(item);
    }
}
