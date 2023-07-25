package project.adviceweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private Long answerId;
    private Long userId;
    private String content;
    private LocalDate commentDate;
}
