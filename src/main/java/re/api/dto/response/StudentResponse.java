package re.api.dto.response;

import lombok.Getter;
import lombok.Setter;
import re.api.dto.Sex;

import java.time.LocalDate;
@Getter
@Setter
public class StudentResponse {
    private String id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private Sex sex;
}
