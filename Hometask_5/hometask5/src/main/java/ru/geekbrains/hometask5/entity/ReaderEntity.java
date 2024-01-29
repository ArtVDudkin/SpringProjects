package ru.geekbrains.hometask5.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;

@Entity
@Table(name="readers")
public class ReaderEntity {

    public static long sequence = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final long id;
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    public ReaderEntity() {
        this.id = sequence++;
    }

    public ReaderEntity(String name) {
        this.id = sequence++;
        this.name = name;
    }

    @JsonCreator
    public ReaderEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + ".   " + '"' + this.name + '"';
    }

}
