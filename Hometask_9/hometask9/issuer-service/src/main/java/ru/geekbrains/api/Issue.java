package ru.geekbrains.api;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Issue {

    private UUID id;
    private LocalDate issuedAt;
    private Book book;
    private Reader reader;

}