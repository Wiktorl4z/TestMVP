package pl.futuredev.testmvp.repositories;

import java.util.List;

import pl.futuredev.testmvp.Book;


public interface BooksRepository {

    List<Book> getBooks();
}
