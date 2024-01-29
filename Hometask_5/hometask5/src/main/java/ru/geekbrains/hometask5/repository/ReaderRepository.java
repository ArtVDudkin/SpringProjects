package ru.geekbrains.hometask5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask5.entity.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity,Long> {
}
