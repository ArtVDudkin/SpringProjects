package ru.geekbrains.hometask7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.hometask7.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByLogin(String login);

}
