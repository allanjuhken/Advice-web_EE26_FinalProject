package project.adviceweb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AnswerNotFoundException.class)
    public ResponseEntity<String> handleAnswerNotFoundException(AnswerNotFoundException answerNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message: " + answerNotFoundException.getMessage()
            + "Error Code: " + answerNotFoundException.getErrorCode());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message:" + categoryNotFoundException.getMessage()
            + "Error Code: " + categoryNotFoundException.getErrorCode());
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<String> handleCommentNotFoundException(CommentNotFoundException commentNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message: " + commentNotFoundException.getMessage()
        + "Error Code: " + commentNotFoundException.getErrorCode());
    }

    @ExceptionHandler(QuestionNotFoundException.class)
    public ResponseEntity<String> handleQuestionNotFoundException(QuestionNotFoundException questionNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message: " + questionNotFoundException.getMessage()
            + "Error Code: " + questionNotFoundException.getErrorCode());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Message: " + userNotFoundException.getMessage()
            + "Error Code: " + userNotFoundException.getErrorCode());
    }
}
