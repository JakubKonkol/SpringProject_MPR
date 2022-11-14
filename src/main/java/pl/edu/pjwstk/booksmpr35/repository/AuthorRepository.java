package pl.edu.pjwstk.booksmpr35.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.booksmpr35.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
