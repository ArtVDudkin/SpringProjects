package ru.geekbrains.hometask5.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name="readers")

@Schema(name="Читатель")
public class ReaderEntity {

    public static long sequence = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(name="Id читателя")
    private final long id;
    @Column(name = "name", nullable = false, length = 255)
    @Schema(name="Имя и фамилия читателя", minimum ="3", maximum = "100")
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
