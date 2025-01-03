package ru.job4j.gc.leak.models;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Comment {
    private String text;

    private User user;

    public Comment(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comment comment = (Comment) o;
        return Objects.equals(text, comment.text) && Objects.equals(user, comment.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, user);
    }

    @Override
    public String toString() {
        return "Comment{"
                + "text='" + text + '\''
                + ", user=" + user
                + '}';
    }
}
