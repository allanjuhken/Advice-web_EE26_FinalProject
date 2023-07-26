package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllQuestionAsked(String content);
    List<User> findAllAnswersProvided(String content);
    List<User> findAllCommentsAdded(String content);
}