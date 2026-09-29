package backend.bookstore.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;

@RestController
public class BookRestController {

    private final BookRepository repository;

    public BookRestController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    @ResponseBody
    public Iterable<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/book/{id}")
    @ResponseBody
    public Book getBook(@PathVariable("id") Long bookId) {
        return repository.findById(bookId).orElse(null);
    }
}