package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByQuestionAsked(String content);
    List<User> findUserByAnswerProvided(String answerProvided);
    List<User> findUserByCommentsAdded(String content);
}