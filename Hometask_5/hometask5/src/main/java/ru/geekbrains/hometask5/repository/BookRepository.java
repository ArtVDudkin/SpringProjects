package ru.geekbrains.hometask5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask5.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
