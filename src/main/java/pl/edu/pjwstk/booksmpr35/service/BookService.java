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
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void updateBook(Long id, Book book){
        Book bookToUpdate = bookRepository.getReferenceById(id);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setPublisher(book.getPublisher());
        bookRepository.save(bookToUpdate);
    }
    public Book getBookById(Long id){
        return bookRepository.getReferenceById(id);
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

}
