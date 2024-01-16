package ru.geekbrains.hometask2;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private static long idCounter = 1L;
    private final long id;
    private String name;
    private String groupName;

    public Student() {
        this.id = idCounter++;
    }
    @JsonCreator
    public Student(long id, String name, String groupName) {
        this.id = id;
        this.name = name;
        this.groupName = groupName;
    }

    public Student(String name, String groupName) {
        this.id = idCounter++;
        this.name = name;
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", groupName=" + groupName +
                '}';
    }

}
