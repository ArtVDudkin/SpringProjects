package ru.geekbrains.hometask2;

import java.util.List;

public interface IStudentRepository {
    void add(Student student);
    Student getById(long id);
    List<Student> getAll();
    List<Student> getByName(String name);
    List<Student> getByGroupName(String groupName);
    void deleteById(long id);

}
