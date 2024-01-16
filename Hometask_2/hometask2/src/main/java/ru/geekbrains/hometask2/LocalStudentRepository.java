package ru.geekbrains.hometask2;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Profile("local")
public class LocalStudentRepository implements IStudentRepository {

    private final List<Student> studentList;

    public LocalStudentRepository() {
        this.studentList = new ArrayList<>();
        studentList.add(new Student("Igor", "Java development"));
        studentList.add(new Student("Artem", "Java development"));
        studentList.add(new Student("Sergey","C# development"));
        studentList.add(new Student("Ivan", "C# development"));
        studentList.add(new Student("Andrey", "JavaScript development"));
        studentList.add(new Student("Sergey", "JavaScript development"));
        studentList.add(new Student("Anatoly", "DevOps"));
        studentList.add(new Student("Elena", "Project management"));
        studentList.add(new Student("Anna", "Product management"));
        studentList.add(new Student("Vladimir", "Product management"));
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
                .filter(it -> Objects.equals(it.getName(), name)).collect(Collectors.toList());
    }

    public List<Student> getByGroupName(String groupName) {
        return studentList.stream()
                .filter(it -> Objects.equals(it.getGroupName(), groupName)).collect(Collectors.toList());
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
