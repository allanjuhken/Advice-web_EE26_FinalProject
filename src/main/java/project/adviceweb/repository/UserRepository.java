package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByQuestionAsked(String content);
    List<User> findByAnswersProvided(String content);
    List<User> findByCommentsAdded(String content);
}