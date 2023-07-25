package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.Answer;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findAnswerByAnswerer(Long userId);
    Answer findAnswerByQuestion(Long questionId);
    List<Answer> findAllAnswerers(Long userId);
}