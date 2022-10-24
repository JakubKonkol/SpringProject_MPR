package pl.edu.pjwstk.booksmpr35.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr35.model.Author;
import pl.edu.pjwstk.booksmpr35.service.AuthorService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/author/")
public class AuthorController {

    AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Author>> getAllAuthors(){
        authorService.createAuthor(new Author());

        return ResponseEntity.ok(authorService.getAllAuthors());
    }
    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.createAuthor(author));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathParam("id") Long id){
        return ResponseEntity.ok(authorService.getAuthorById(id));
    }

}
