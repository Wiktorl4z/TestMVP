package pl.futuredev.testmvp;

import java.util.List;

import pl.futuredev.testmvp.repositories.BooksRepository;

public class BooksActivityPresenter {

    private BooksActivityView view;
    private BooksRepository repository;

    public BooksActivityPresenter(BooksActivityView view, BooksRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadBooks() {
        List<Book> books = repository.getBooks();

        if (books.isEmpty()) {
            view.displayNoBooks();
        } else {
            view.displayBooks(books);
        }
    }
}
