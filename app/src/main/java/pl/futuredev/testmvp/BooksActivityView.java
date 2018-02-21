package pl.futuredev.testmvp;

import java.util.List;

public interface BooksActivityView {

    void displayBooks(List<Book> books);

    void displayNoBooks();
}
