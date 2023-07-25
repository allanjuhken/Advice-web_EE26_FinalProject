package project.adviceweb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentNotFoundException extends Exception {
    private String message;
    private int errorCode;

    public CommentNotFoundException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "CommentNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
