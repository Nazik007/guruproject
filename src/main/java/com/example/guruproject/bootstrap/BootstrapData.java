package com.example.guruproject.bootstrap;

import com.example.guruproject.domain.Author;
import com.example.guruproject.domain.Book;
import com.example.guruproject.domain.Publisher;
import com.example.guruproject.repositiories.AuthorRepository;
import com.example.guruproject.repositiories.BookRepository;
import com.example.guruproject.repositiories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "23211");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "354759");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setAddressLine1("Macro St. 1");
        publisher.setCity("St.Louis");
        publisher.setState("FL");
        publisher.setZip("564785");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());
        System.out.println("Number of books: " + bookRepository.count());
    }
}
