package ru.geekbrains.hometask6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask6.entity.ReaderEntity;

public interface ReaderRepository extends JpaRepository<ReaderEntity,Long> {
}
