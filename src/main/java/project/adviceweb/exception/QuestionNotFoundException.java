package project.adviceweb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionNotFoundException extends Exception {
    private String message;
    private int errorCode;

    public QuestionNotFoundException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "QuestionNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
