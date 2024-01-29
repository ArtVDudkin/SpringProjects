package ru.geekbrains.hometask5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.geekbrains.hometask5.controller.IssueRequest;
import ru.geekbrains.hometask5.entity.IssueEntity;
import ru.geekbrains.hometask5.repository.IssueRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class IssueServiceImpl implements IssueService {

    private final BookService bookService;
    private final ReaderService readerService;
    private final IssueRepository issueRepository;
    // application.max-allowed-books default = 1
    @Value("${application.max-allowed-books:1}")
    private int maxAllowedBooks;

    @Autowired
    public IssueServiceImpl(BookService bookService, ReaderService readerService, IssueRepository issueRepository) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.issueRepository = issueRepository;
    }

    public IssueEntity addIssue(IssueRequest request) {
        if (bookService.getBookById(request.getBookId()) == null) {
            throw new NoSuchElementException("Не найдена книга с идентификатором \"" + request.getBookId() + "\"");
        }
        if (readerService.getReaderById(request.getReaderId()) == null) {
            throw new NoSuchElementException("Не найден читатель с идентификатором \"" + request.getReaderId() + "\"");
        }
        if (issueRepository.findAll().stream()
                .filter(it -> it.getBookId() == request.getBookId()
                        && it.getReturned_at() == null)
                .toList().size() != 0) {
            throw new NoSuchElementException("Книга с идентификатором \"" + request.getBookId() +
                    "\"находится на руках");
        }
        // Проверяеть, что у читателя нет книг на руках (или его лимит не превышает в Х книг)
        int booksInHand = issueRepository.countBookByReaderId(request.getReaderId());
        if (booksInHand < maxAllowedBooks) {
            IssueEntity issue = new IssueEntity(request.getBookId(), request.getReaderId());
            issueRepository.save(issue);
            return issue;
        } else {
            return null;
        }
    }

    public Optional<IssueEntity> getIssueById(long id) {
        return issueRepository.findById(id);
    }

    public Optional<IssueEntity> returnBook(long issueId) {

        issueRepository.findById(issueId) // returns Optional<Reader>
                .ifPresent(issue1 -> {
                    issue1.setReturned_at(LocalDateTime.now());
                    issueRepository.save(issue1);
                });
        return issueRepository.findById(issueId);
    }

    public List<IssueEntity> getIssuesByReader(long id) {
        return issueRepository.findByReaderId(id);
    }

    public List<IssueEntity> getAllIssues() {
        return issueRepository.findAll();
    }

}
