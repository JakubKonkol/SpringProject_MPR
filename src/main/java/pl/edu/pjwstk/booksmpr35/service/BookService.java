package pl.edu.pjwstk.booksmpr35.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.booksmpr35.model.Book;
import pl.edu.pjwstk.booksmpr35.model.enums.BookType;
import pl.edu.pjwstk.booksmpr35.repository.BookRepository;

import java.util.List;
import java.util.Optional;

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
    public Book updateBook(Long id, Book updatedBook) {
        Book bookToUpdate = getBookById(id);

        if(updatedBook.getPublisher() != null ){
            bookToUpdate.setPublisher(updatedBook.getPublisher());
        }

        if(updatedBook.getTitle() != null){
            bookToUpdate.setTitle(updatedBook.getTitle());
        }

        if(updatedBook.getAuthor() != null){
            bookToUpdate.setAuthor(updatedBook.getAuthor());
        }

        return bookRepository.save(bookToUpdate);

    }
    public Book getBookById(Long id){
        Optional<Book> b = bookRepository.findById(id);
        if (b.isPresent()) {
            return b.get();
        }
        throw new IllegalArgumentException();
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
    public List<Book> findBooksByBookType(BookType bookType){
        return bookRepository.findBooksByBookType(bookType);
    }

}
