package ru.geekbrains.hometask5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.hometask5.service.BookService;
import ru.geekbrains.hometask5.service.IssueService;
import ru.geekbrains.hometask5.service.ReaderService;


@Controller
@RequestMapping("/ui")
public class UIController {


    private final BookService bookService;
    private final ReaderService readerService;
    private final IssueService issueService;

    @Autowired
    public UIController(BookService bookService, ReaderService readerService, IssueService issueService) {
        this.bookService = bookService;
        this.readerService = readerService;
        this.issueService = issueService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/reader")
    public String getAllReaders(Model model) {
        model.addAttribute("readers", readerService.getAllReaders());
        return "readers";
    }

    @GetMapping("/issues")
    public String getAllIssues(Model model) {
        model.addAttribute("issues", issueService.getAllIssues());
        model.addAttribute("readers", readerService.getAllReaders());
        model.addAttribute("books", bookService.getAllBooks());
        return "issues";
    }

    @GetMapping("/reader/{id}")
    public String readerBooks(@PathVariable long id, Model model) {
        model.addAttribute("reader", readerService.getReaderById(id));
        model.addAttribute("books", issueService.getIssuesByReader(id));
        return "booksOfReader";
    }

}
