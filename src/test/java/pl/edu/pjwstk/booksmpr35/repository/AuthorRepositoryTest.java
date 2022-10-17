package pl.edu.pjwstk.booksmpr35.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.pjwstk.booksmpr35.model.Author;

import java.time.LocalDate;

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
    void getAllAuthors() {
    }

    @Test
    void getAuthorById() {
    }

    @Test
    void updateAuthor() {
    }

    @Test
    void deleteAuthorById() {
    }

}