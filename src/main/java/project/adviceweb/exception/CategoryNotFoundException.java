package project.adviceweb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends Exception {
    private String message;
    private int errorCode;

    public CategoryNotFoundException(String message, int errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "CategoryNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
