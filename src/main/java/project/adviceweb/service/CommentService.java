package project.adviceweb.service;

import project.adviceweb.exception.CommentNotFoundException;
import project.adviceweb.model.Comment;
import org.springframework.stereotype.Service;
import project.adviceweb.repository.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment findCommentByUserId(Long userId) throws CommentNotFoundException {
        Comment comment = commentRepository.findCommentByUserId(userId);
        if (comment == null) {
            throw new CommentNotFoundException("Comment not found for userId: " + userId, 3);
        }
        return comment;
    }

    public Comment findCommentByAnswerId(Long answerId) throws CommentNotFoundException {
        Comment comment = commentRepository.findCommentByAnswerId(answerId);
        if (comment == null) {
            throw new CommentNotFoundException("Comment not found for answerId: " + answerId, 3);
        }
        return comment;
    }

    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}
