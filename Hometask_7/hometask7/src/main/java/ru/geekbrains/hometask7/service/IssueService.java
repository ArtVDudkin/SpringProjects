package ru.geekbrains.hometask7.service;

import ru.geekbrains.hometask7.controller.IssueRequest;
import ru.geekbrains.hometask7.entity.IssueEntity;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    IssueEntity addIssue(IssueRequest request);

    Optional<IssueEntity> getIssueById(long id);

    List<IssueEntity> getIssuesByReader(long id);

    List<IssueEntity> getAllIssues();

    Optional<IssueEntity> returnBook(long id);
}