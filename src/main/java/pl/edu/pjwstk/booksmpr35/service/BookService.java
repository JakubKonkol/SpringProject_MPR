package pl.edu.pjwstk.booksmpr35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;


    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    public Book createBook(Book book){
        return bookRepository.createBook(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    public void updateBook(Long id, Book book){
        bookRepository.updateBook(id, book);
    }
    public Book getBookById(Long id){
        return bookRepository.getBookById(id);
    }
    public void deleteBook(Long id){
        bookRepository.deleteBook(id);
    }

}
