package pl.edu.pjwstk.booksmpr35.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.service.BookService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>> getAllBooks(){
        bookService.createBook(new Book());
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @DeleteMapping
    public ResponseEntity<String> deleteBook(@RequestParam(name = "id") Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("ok");
    }
    @PutMapping
    public ResponseEntity<String> updateBook(@RequestBody Book book, @PathVariable("id") Long id){
        bookService.updateBook(id, book);
        return ResponseEntity.ok("ok");
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }


}
