package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

