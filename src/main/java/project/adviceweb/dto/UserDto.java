package project.adviceweb.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @Id
    @GeneratedValue(strategy =
            GenerationType.IDENTITY)
    private Long id;
    private String displayedName;
    private String email;
    private String password;
}
