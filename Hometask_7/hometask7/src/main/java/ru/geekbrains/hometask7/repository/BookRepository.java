package ru.geekbrains.hometask7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask7.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
