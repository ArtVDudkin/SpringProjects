package ru.geekbrains.hometask2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private final IStudentRepository studentRepository;

    public StudentController(IStudentRepository repository) {
        this.studentRepository = repository;
    }

    // GET /student/{id} - получить студента по ID
    @GetMapping(value = "/student/{id}")
    public Student getStudentById(@PathVariable long id) throws Exception {
        Student student = studentRepository.getById(id);
        if (student != null) {
            return student;
        } else {
            throw new RuntimeException("Student with id=" + id + " not found");
        }
    }

    // GET /student - получить всех студентов
    @GetMapping(value = "/student")
    public IStudentRepository getAllStudents() {
        return studentRepository;
    }

    // GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
    @GetMapping("/student/search")
    public List<Student> getStudentByName(@RequestParam String name) {
        System.out.println(name);
        return studentRepository.getByName(name);
    }

    // GET /group/{group}/student - получить всех студентов группы
    @GetMapping(value = "/group/{group}/student")
    public List<Student> getGroup(@PathVariable String group) {
        return studentRepository.getByGroupName(group);
    }

    // POST /student - создать студента (принимает JSON)
    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        studentRepository.add(student);
        return student;
    }

    // DELETE /student/{id} - удалить студента
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable long id) {
        Student student = studentRepository.getById(id);
        if (student != null) {
            studentRepository.deleteById(id);
            return "Student with id=" + id + " was deleted";
        }
        return "Error: Student with id=" + id + " not found";
    }

}
