package project.adviceweb.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.adviceweb.model.Comment;
import project.adviceweb.service.CommentService;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @SneakyThrows
    @GetMapping("/comments/by-answerer/{userId}")
    public ResponseEntity<Comment> getCommentByAnswerer(@PathVariable Long userId) {
        Comment comment1 = commentService.findCommentByAnswerer(userId);
        if (comment1 != null) {
            return ResponseEntity.ok(comment1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @SneakyThrows
    @GetMapping("/comments/by-answer/{answerId}")
    public ResponseEntity<Comment> getCommentByAnswer(@PathVariable Long answerId) {
        Comment comment2 = commentService.findCommentByAnswer(answerId);
        if (comment2 != null) {
            return ResponseEntity.ok(comment2);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(savedComment);
    }
}


