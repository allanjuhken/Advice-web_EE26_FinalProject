package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.exception.AnswerNotFoundException;
import project.adviceweb.model.Answer;
import project.adviceweb.repository.AnswerRepository;

import java.util.List;


@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer findAnswerByAnswerer(Long userId)
            throws AnswerNotFoundException {
       Answer answer = answerRepository.findAnswerByAnswerer(userId);
       if (answer == null)
           throw new AnswerNotFoundException("Answer not found", 1);
       return answer;
    }

    public Answer findAnswerByQuestion(Long questionId)
            throws AnswerNotFoundException {
        Answer answer = answerRepository.findAnswerByQuestion(questionId);
        if (answer == null)
            throw new AnswerNotFoundException("Answer not found", 1);
        return answer;
    }

    public List<Answer> findAllAnswerers(Long userId) {
        return answerRepository.findAllAnswerers(userId);
    }

}
