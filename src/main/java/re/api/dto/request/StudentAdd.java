package re.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import re.api.dto.Sex;

import java.time.LocalDate;
@Getter@Setter
public class StudentAdd {
    private String id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private Sex sex;
}
