package project.adviceweb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(strategy =
            GenerationType.AUTO)
    private Long userId;
    //@NotBlank(message = "username can't be empty")
    private String displayedName;
    //@Email(message = "email format is not correct")
    private String email;
    //@Size(min = 8, max = 15)
    private String password;
    private String answerProvided;
    private String commentsAdded;
    private String questionAsked;
    private String role;
}
