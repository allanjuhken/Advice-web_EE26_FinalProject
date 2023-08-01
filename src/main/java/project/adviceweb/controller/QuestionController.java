package project.adviceweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.adviceweb.exception.QuestionNotFoundException;
import project.adviceweb.exception.UserNotFoundException;
import project.adviceweb.model.Question;
import project.adviceweb.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/asker-by-userId/{userId}")
    public ResponseEntity<List<Question>> findByUserId(@PathVariable Long userId) throws QuestionNotFoundException {
        try {
            List<Question> questions = questionService.findByUserId(userId);
            return ResponseEntity.ok(questions);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/by-tags/{tagName}")
    public ResponseEntity<List<Question>> findQuestionsByTags(@PathVariable String tagName) {
        List<Question> questions = questionService.findQuestionsByTags(tagName);
        return ResponseEntity.ok(questions);
    }
}

