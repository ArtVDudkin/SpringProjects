package ru.geekbrains.hometask5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask5.entity.IssueEntity;

import java.util.List;

public interface IssueRepository extends JpaRepository<IssueEntity,Long> {
    List<IssueEntity> findByReaderId(long readerId);

    Integer countBookByReaderId(long id);

}
