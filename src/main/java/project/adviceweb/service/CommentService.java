package project.adviceweb.service;

import org.springframework.stereotype.Service;
import project.adviceweb.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
