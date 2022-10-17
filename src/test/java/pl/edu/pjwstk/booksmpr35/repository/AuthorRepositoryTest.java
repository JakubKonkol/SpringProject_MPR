package pl.edu.pjwstk.booksmpr35.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pjwstk.booksmpr35.model.Author;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AuthorRepositoryTest {

    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorRepository = new AuthorRepository();
    }

    @Test
    void Should_CreateAuthorWithCorrectParameters() {
        //given
        Author author1 = new Author("Adam", "Janowicz", LocalDate.now());
        Author author2 = new Author();
        //when
        author1 = authorRepository.createAuthor(author1);
        author2 = authorRepository.createAuthor(author2);
        //then
        Assertions.assertNotNull(author1.getId());
        Assertions.assertNotNull(author2.getId());
    }

    @Test
    void Should_ReturnAllAuthorsWithCorrectInput() {
        //given
        List<Author> authors;
        //when
        authors = authorRepository.getAllAuthors();
        //then
        assertNotNull(authors);
    }

    @Test
    void Should_ReturnAuthorByIdWithCorrectInput() {
        //given
        Author a = authorRepository.createAuthor(new Author());
        //when
        Author b = authorRepository.getAuthorById(a.getId());
        //then
        assertNotNull(b);
        assertNotNull(b.getId());
    }

    @Test
    void Should_ThrowIllegalArgumentExceptionWhenGettingAuthorWithWrongId(){
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> authorRepository.getAuthorById(8L));



    }

    @Test
    void Should_DeleteAutorByIdWithCorrectInput() {
        //given
        Author a = authorRepository.createAuthor(new Author());
        //when
        authorRepository.deleteAuthorById(a.getId());
        //then
        assertEquals(0, authorRepository.getAllAuthors().size());
    }
    @Test
    void Should_ThrowIllegalArgumentExceptionWhenAuthorNotExistDuringDelete(){
        assertThrows(IllegalArgumentException.class, ()-> authorRepository.deleteAuthorById(999L));
    }

}