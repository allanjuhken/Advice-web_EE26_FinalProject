package project.adviceweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    private Long id;
    private Long userId;
    private Long questionId;
    private String content;
    private Long evaluation;
}
