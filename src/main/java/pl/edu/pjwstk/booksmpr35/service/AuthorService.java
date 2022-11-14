package pl.edu.pjwstk.booksmpr35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.repository.AuthorRepository;
import pl.edu.pjwstk.booksmpr35.repository.BookRepository;

import java.util.List;

@Service
public class AuthorService {

    AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
    public Author getAuthorById(Long id){
        return authorRepository.getReferenceById(id);
    }
    public void deleteAuthorById(Long id){
        authorRepository.deleteById(id);
    }

}
