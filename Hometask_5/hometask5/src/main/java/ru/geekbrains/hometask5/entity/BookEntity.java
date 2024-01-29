package ru.geekbrains.hometask5.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;

@Entity
@Table(name="books")
public class BookEntity {

    public static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    @Column(name = "name", nullable = false, length = 255)
    private final String name;

    public BookEntity() {
        this.id = sequence++;
        name = null;
    }

    public BookEntity(String name) {
        this.id = sequence++;
        this.name = name;
    }

    @JsonCreator
    public BookEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.id + ".   " + '"' + this.name + '"';
    }

}