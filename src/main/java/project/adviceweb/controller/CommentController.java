package project.adviceweb.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.adviceweb.model.Comment;
import project.adviceweb.service.CommentService;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @SneakyThrows
    @GetMapping("/comments/by-answerer/{userId}")
    public ResponseEntity<Comment> getCommentByUserId(@PathVariable Long userId) {
        Comment comment1 = commentService.findCommentByUserId(userId);
        if (comment1 != null) {
            return ResponseEntity.ok(comment1);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @SneakyThrows
    @GetMapping("/comments/by-answer/{answerId}")
    public ResponseEntity<Comment> getCommentByAnswerId(@PathVariable Long answerId) {
        Comment comment2 = commentService.findCommentByAnswerId(answerId);
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


