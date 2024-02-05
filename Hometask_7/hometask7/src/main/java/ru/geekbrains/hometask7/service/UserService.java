package ru.geekbrains.hometask7.service;

import ru.geekbrains.hometask7.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> getUserByLogin(String login);

    List<UserEntity> getAllUsers();

}
