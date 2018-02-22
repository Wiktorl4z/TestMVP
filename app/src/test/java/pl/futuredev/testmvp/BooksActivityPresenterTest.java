package pl.futuredev.testmvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import pl.futuredev.testmvp.repositories.BooksRepository;

import static java.util.Collections.EMPTY_LIST;


@RunWith(MockitoJUnitRunner.class)
public class BooksActivityPresenterTest {


    @Mock
    BooksRepository repository;

    @Mock
    BooksActivityView view;
    BooksActivityPresenter presenter;
    private final List<Book> MANY_BOOKS = Arrays.asList(new Book(1), new Book(2), new Book(3));

    @Before
    public void setUp() {
        presenter = new BooksActivityPresenter(view, repository);
    }

    @Test
    public void shouldPassBooksToView() {

        Mockito.when(repository.getBooks()).thenReturn(MANY_BOOKS);

        presenter.loadBooks();

        Mockito.verify(view).displayBooks(MANY_BOOKS);
    }

    @Test
    public void shouldNoPassBooksToView() {

        Mockito.when(repository.getBooks()).thenReturn(Collections.EMPTY_LIST);

        presenter.loadBooks();

        Mockito.verify(view).displayNoBooks();
    }
}