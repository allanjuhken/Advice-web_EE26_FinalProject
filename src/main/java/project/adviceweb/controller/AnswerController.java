package project.adviceweb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import project.adviceweb.exception.AnswerNotFoundException;
import project.adviceweb.model.Answer;
import project.adviceweb.service.AnswerService;

import java.util.List;

@Controller
public class AnswerController {
    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping(path = "/answer/{userId}")
    public ResponseEntity<Answer> getAnswerByUser(@PathVariable("userId") Long userId)
            throws AnswerNotFoundException {
        Answer answer = answerService.findAnswerByAnswerer(userId);
        return ResponseEntity.ok(answer);
    }

    @GetMapping(path = "/answer/{questionId}")
    public ResponseEntity<Answer> getAnswerByQuestion(@PathVariable("questionId") Long questionId)
            throws AnswerNotFoundException {
        Answer answer = answerService.findAnswerByQuestion(questionId);
        return ResponseEntity.ok(answer);
    }




}
