package pl.edu.pjwstk.booksmpr35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr35.model.Book;

import java.util.HashMap;
import java.util.List;
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}