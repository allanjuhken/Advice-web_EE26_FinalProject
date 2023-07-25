package project.adviceweb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerNotFoundException extends Exception {
    private String message;
    private int errorCode;

    public AnswerNotFoundException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "AnswerNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
