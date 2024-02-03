package ru.geekbrains.hometask6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask6.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
