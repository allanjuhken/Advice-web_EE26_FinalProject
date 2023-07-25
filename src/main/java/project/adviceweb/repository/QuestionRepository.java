package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.model.Question;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findAsker(Long userId);
    List<String> findQuestionsByTags();
}
