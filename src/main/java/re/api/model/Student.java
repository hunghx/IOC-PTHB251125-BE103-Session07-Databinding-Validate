package re.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Student {
    private String id;
    private String name;
    private LocalDate  dateOfBirth;
    private String email;
    private Sex sex;
}
