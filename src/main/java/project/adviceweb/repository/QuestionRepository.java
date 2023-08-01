package project.adviceweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.adviceweb.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByUser_UserId(Long id);
    List<Question> findByTags_Name(String tagName);
    List<Question> findQuestionByCategory(String categoryName);
    Question findQuestionByQuestionId(Long questionId);
}