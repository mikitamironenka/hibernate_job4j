package ru.job4j.configuration.models;



import java.util.Calendar;
import java.util.Objects;

public class User {

    private int id;
    private String name;
    private Calendar expired;

    public User() { }

    public User(String name, Calendar expired) {
        this.name = name;
        this.expired = expired;
    }

    public User(int id, String name, Calendar expired) {
        this.id = id;
        this.name = name;
        this.expired = expired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getExpired() {
        return expired;
    }

    public void setExpired(Calendar expired) {
        this.expired = expired;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(expired, user.expired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, expired);
    }
}
