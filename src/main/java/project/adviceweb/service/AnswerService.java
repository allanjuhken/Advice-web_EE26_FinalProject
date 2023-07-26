package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.dto.AnswerDto;
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

    public Answer findAnswerIdByUserId(Long userId)
            throws AnswerNotFoundException {
       Answer answer = answerRepository.findAnswerIdByUserId(userId);
       if (answer == null)
           throw new AnswerNotFoundException("Answer not found", 1);
       return answer;
    }

    public Answer findAnswerByQuestionId(Long questionId)
            throws AnswerNotFoundException {
        Answer answer = answerRepository.findAnswerByQuestionId(questionId);
        if (answer == null)
            throw new AnswerNotFoundException("Answer not found", 1);
        return answer;
    }

    public List<Answer> findAllAnswersByUserId(Long userId) {
        return answerRepository.findAllAnswersByUserId(userId);
    }
}
