package project.adviceweb.dto;

import jakarta.persistence.ElementCollection;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class QuestionDto {
    private Long id;
    private Long userId;
    private String content;
    private LocalDate questionDate;
    @ElementCollection
    private List<String> tags;
}
