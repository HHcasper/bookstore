package backend.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.bookstore.domain.Book;
import backend.bookstore.domain.BookRepository;
import backend.bookstore.domain.Category;
import backend.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(
            BookRepository bookRepository,
            CategoryRepository categoryRepository) {

        return (args) -> {

            // Save sample categories
            Category adventure = categoryRepository.save(
                    new Category("Adventure")
            );

            Category classic = categoryRepository.save(
                    new Category("Classic")
            );

            Category dystopian = categoryRepository.save(
                    new Category("Dystopian")
            );

            // Save sample books with categories
            bookRepository.save(new Book(
                    "A Farewell to Arms",
                    "Ernest Hemingway",
                    1929,
                    "1232323-21",
                    15.90,
                    classic
            ));

            bookRepository.save(new Book(
                    "Animal Farm",
                    "George Orwell",
                    1945,
                    "2212343-5",
                    12.90,
                    dystopian
            ));

            // Print categories
            System.out.println("Fetch all categories:");
            categoryRepository.findAll().forEach(category -> {
                System.out.println(category);
            });

            // Print books
            System.out.println("Fetch all books:");
            bookRepository.findAll().forEach(book -> {
                System.out.println(book);
            });
        };
    }
}