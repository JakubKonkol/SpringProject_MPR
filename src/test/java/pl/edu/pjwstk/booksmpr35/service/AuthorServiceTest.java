package pl.edu.pjwstk.booksmpr35.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.repository.AuthorRepository;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {
    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService(authorRepository);
    }

    @Test
    void Should_CreateAuthorWithCorrectInput() {
        //given
        Author author = new Author();
        //when
        when(authorRepository.save(any())).thenReturn(new Author(99L, "Adam", "Adamowicz"));
        author = authorService.createAuthor(author);
        //then
        assertNotNull(author.getFirstName());
        assertNotNull(author.getLastName());
    }
    @Test
    void Should_ThrowIllegalArgumentExceptionWhenNotFound(){
        //given

        //when
        when(authorRepository.findAuthorByFirstNameAndLastName(any(), any())).thenReturn(Optional.empty());
        //then
        assertThrows(IllegalArgumentException.class, () -> authorService.findByNameAndLastName(anyString(), anyString()));
    }

    @Test
    void Should_GetAllAuthors() {
        //given

        //when
        when(authorRepository.findAll()).thenReturn(null);

        //then
        assertNull(authorService.getAllAuthors());

    }

    @Test
    void Should_getAuthorById() {
        //given

        //when
        when(authorRepository.getReferenceById(any())).thenReturn(new Author(99L, "Adam", "Adamowicz"));

        //then
        assertNotNull(authorService.getAuthorById(anyLong()));
    }

    @Test
    void deleteAuthorById() {
        //given

        //when
        doNothing().when(authorRepository).deleteById(anyLong());

        //then
        assertDoesNotThrow(() -> authorService.deleteAuthorById(anyLong()));
    }
}