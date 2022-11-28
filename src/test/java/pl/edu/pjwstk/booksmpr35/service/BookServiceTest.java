package pl.edu.pjwstk.booksmpr35.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;
import pl.edu.pjwstk.booksmpr35.repository.BookRepository;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    BookService bookService;

    @Mock
    BookRepository bookRepository;
    @BeforeEach
    void setUp() {
        bookService = new BookService(bookRepository);
    }

    @Test
    void Should_CreateBookWithCorrectInput() {
        //given
        Book book = new Book();
        //when
        when(bookRepository.save(any())).thenReturn(new Book("Tytuł", LocalDate.now(), BookType.CRIME, new Author()));
        //then

    }

    @Test
    void Should_GetAllBooks() {
        //given

        //when
        when(bookRepository.findAll()).thenReturn(null);

        //then
        assertNull(bookService.getAllBooks());
    }

    @Test
    void Should_UpdateBook() {

    }

    @Test
    void Should_GetBookById() {

    }

    @Test
    void Should_DeleteBook() {

    }

    @Test
    void Should_findBooksByBookType() {

    }
}