package ru.geekbrains.hometask5.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="entities")
@Schema(name = "Выдача")
public class IssueEntity {

    public static long sequence = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long id;
    @Column(name = "bookId", nullable = false)
    private final Long bookId;
    @Column(name = "readerId", nullable = false)
    private final Long readerId;

    // Дата выдачи
    @Column(name = "issued_at")
    private final LocalDateTime issued_at;
    // Дата возврата
    @Column(name = "returned_at")
    private LocalDateTime returned_at;

    public IssueEntity(long bookId, long readerId) {
        this.id = sequence++;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issued_at = LocalDateTime.now();
        this.returned_at = null;
    }

    public IssueEntity() {
        this.id = sequence++;
        this.bookId = null;
        this.readerId = null;
        this.issued_at = LocalDateTime.now();
    }

    @JsonCreator
    public IssueEntity(long id, long bookId, long readerId) {
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.issued_at = LocalDateTime.now();
        this.returned_at = null;
    }

    public long getId() {
        return id;
    }

    public long getBookId() {
        return bookId;
    }

    public long getReaderId() {
        return readerId;
    }

    public LocalDateTime getIssued_at() {
        return issued_at;
    }

    public LocalDateTime getReturned_at() {
        return returned_at;
    }

    public void setReturned_at(LocalDateTime returned_at) {
        this.returned_at = returned_at;
    }

}
