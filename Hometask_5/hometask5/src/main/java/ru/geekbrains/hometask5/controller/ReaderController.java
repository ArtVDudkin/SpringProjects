package ru.geekbrains.hometask5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.hometask5.entity.IssueEntity;
import ru.geekbrains.hometask5.entity.ReaderEntity;
import ru.geekbrains.hometask5.service.IssueService;
import ru.geekbrains.hometask5.service.ReaderService;

import java.util.List;
import java.util.Optional;

// @Slf4j - модуль lombok для логирования (см. в коде)
@RestController
@RequestMapping("/reader")
public class ReaderController {



    private final ReaderService readerService;
    private final IssueService issueService;
    @Autowired

    public ReaderController(ReaderService readerService, IssueService issueService) {
        this.readerService = readerService;
        this.issueService = issueService;
    }

    // GET /reader/{id} - получить читателя по ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ReaderEntity>> getBookName(@PathVariable long id) {
        //log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
        final Optional<ReaderEntity> reader;
        reader = readerService.getReaderById(id);
        if (reader == null) {
            System.out.println("Читатель: не найден");
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Читатель: " + readerService.getReaderById(id));
            return ResponseEntity.status(HttpStatus.OK).body(reader);
        }
    }

    // GET /reader - получить всех читателей
    @GetMapping
    public ResponseEntity<List<ReaderEntity>> getAllReaders() {
        return ResponseEntity.status(HttpStatus.OK).body(readerService.getAllReaders());
    }

    // POST /reader - добавить читателя (принимает JSON)
    @PostMapping
    public ResponseEntity<ReaderEntity> addReader(@RequestBody ReaderEntity reader) {
        readerService.addReader(reader);
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }

    // PUT /reader/{id} - обновить данные читателя (принимает JSON)
    @PutMapping("/{id}")
    public ResponseEntity<ReaderEntity> updateReaderById(@PathVariable long id, @RequestBody ReaderEntity reader) {
        readerService.updateReader(id, reader);
        return ResponseEntity.status(HttpStatus.CREATED).body(reader);
    }

    // DELETE /reader/{id} - удалить читателя
    @DeleteMapping("/{id}")
    public ResponseEntity<ReaderEntity> deleteReader(@PathVariable long id) {
        readerService.deleteReader(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // GET /reader/{id}/issue - вернуть список всех выдачей для данного читателя
    @GetMapping("/{id}/issue")
    public ResponseEntity<List<IssueEntity>> getBooksByReader(@PathVariable long id) {
        final List<IssueEntity> readerIssues;
        readerIssues = issueService.getIssuesByReader(id);
        if (readerIssues.size() < 1) {
            System.out.println("Выдачи по читателю не найдены");
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Читатель: " + readerService.getReaderById(id));
            return ResponseEntity.status(HttpStatus.OK).body(readerIssues);
        }
    }

}
