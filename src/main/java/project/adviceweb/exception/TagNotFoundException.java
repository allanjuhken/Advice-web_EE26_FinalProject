package project.adviceweb.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagNotFoundException extends Exception{
    private String message;
    private int errorCode;

    public TagNotFoundException(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "TagNotFoundException{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }
}
