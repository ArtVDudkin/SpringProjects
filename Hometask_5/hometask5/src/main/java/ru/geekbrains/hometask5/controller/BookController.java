package ru.geekbrains.hometask5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hometask5.entity.BookEntity;
import ru.geekbrains.hometask5.service.BookService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {


    private final BookService bookService;
    @Autowired

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // GET /book - получить все книги
    @GetMapping
    public ResponseEntity<List<BookEntity>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    // GET /book/{id} - получить книгу по ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<BookEntity>> getBookById(@PathVariable long id) {
        final Optional<BookEntity> book;
        book = bookService.getBookById(id);
        if (book == null) {
            System.out.println("Книга: не найдена");
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Книга: " + bookService.getBookById(id));
            return ResponseEntity.status(HttpStatus.OK).body(book);
        }
    }

    // POST /book - добавить книгу (принимает JSON)
    @PostMapping
    public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // DELETE /book/{id} - удалить книгу
    @DeleteMapping("/{id}")
    public ResponseEntity<BookEntity> deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
