package pl.futuredev.testmvp;

import junit.framework.Assert;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BooksActivityPresenterTest {

    @Test
    public void shouldWork() {
        assertEquals(1, 1);
    }


    @Test
    public void shouldPassBooksToView() {

        // given
        BooksActivityView view = new MockView();
        BooksRepository repository = new MockBooksRepository(true);

        // when
        BooksActivityPresenter presenter = new BooksActivityPresenter(view, repository);
        presenter.loadBooks();

        // then
        Assert.assertEquals(true, ((MockView) view).passed);

    }

    @Test
    public void shouldNoPassBooksToView() {

        // given
        BooksActivityView view = new MockView();
        BooksRepository repository = new MockBooksRepository(false);

        // when
        BooksActivityPresenter presenter = new BooksActivityPresenter(view, repository);
        presenter.loadBooks();

        // then
        Assert.assertEquals(true, ((MockView) view).notPassed);

    }

    private class MockView implements BooksActivityView {

        boolean passed;
        boolean notPassed;

        @Override
        public void displayBooks(List<Book> books) {
            passed = true;
        }

        @Override
        public void displayNoBooks() {
            notPassed = true;
        }
    }

    private class MockBooksRepository implements BooksRepository {

        private boolean passed;

        public MockBooksRepository(boolean passed) {
            this.passed = passed;
        }

        @Override
        public List<Book> getBooks() {

            if (passed) {
                return Arrays.asList(new Book(), new Book(), new Book());
            } else {
                return Collections.emptyList();
            }
        }
    }
}