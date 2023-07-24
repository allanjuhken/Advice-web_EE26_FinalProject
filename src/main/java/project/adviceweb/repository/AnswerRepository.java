package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.Answer;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
