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

    public Comment findCommentByAnswerer(Long userId)
            throws CommentNotFoundException {
        Comment comment = commentRepository.findCommentByAnswerer(userId);
        if (userId == null)
            throw new CommentNotFoundException("Comment not found", 3);
        return comment;
    }

    public Comment findCommentByAnswer(Long answerId)
            throws CommentNotFoundException {
        Comment comment = commentRepository.findCommentByAnswer(answerId);
        if (answerId == null)
            throw new CommentNotFoundException("Comment not found", 3);
        return comment;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }
}
