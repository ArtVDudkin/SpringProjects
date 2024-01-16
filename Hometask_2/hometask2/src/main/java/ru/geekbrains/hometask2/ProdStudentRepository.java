package ru.geekbrains.hometask2;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Primary
@Profile("prod")
public class ProdStudentRepository implements IStudentRepository {

    private final List<Student> studentList;

    public ProdStudentRepository() {
        this.studentList = new ArrayList<>();
    }

    public void add(Student student) {
        if(student != null) {
            studentList.add(student);
        } else {
            throw new RuntimeException("Error: incorrect argument");
        }
    }

    public Student getById(long id) {
        return studentList.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> getAll() {
        return List.copyOf(studentList);
    }

    public List<Student> getByName(String name) {
        return studentList.stream()
                .filter(it -> Objects.equals(it.getName(), name)).toList();
    }

    public List<Student> getByGroupName(String groupName) {
        return studentList.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName)).toList();
    }

    public void deleteById(long id) {
        Student studToDelete = studentList.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .orElse(null);
        if(studToDelete != null) {
            studentList.remove(studToDelete);
        } else {
            throw new RuntimeException("Error: Student with id=" + id + " not found");
        }
    }

}
