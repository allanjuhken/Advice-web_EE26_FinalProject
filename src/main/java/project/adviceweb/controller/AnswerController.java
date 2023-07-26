package project.adviceweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import project.adviceweb.exception.AnswerNotFoundException;
import project.adviceweb.model.Answer;
import project.adviceweb.service.AnswerService;

import java.util.List;

@RestController
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping(path = "/answer/user/{userId}")
    public ResponseEntity<Answer> getAnswerIdByUserId(@PathVariable("userId") Long userId)
            throws AnswerNotFoundException {
        Answer answer = answerService.findAnswerIdByUserId(userId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping(path = "/answer/question/{questionId}")
    public ResponseEntity<Answer> getAnswerByQuestionId(@PathVariable("questionId") Long questionId)
            throws AnswerNotFoundException {
        Answer answer = answerService.findAnswerByQuestionId(questionId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping("/answers/user/{userId}")
    public ResponseEntity<List<Answer>> getAllAnswersByUser(@PathVariable("userId") Long userId) {
        List<Answer> answers = answerService.findAllAnswersByUserId(userId);
        return ResponseEntity.ok(answers);
    }
}