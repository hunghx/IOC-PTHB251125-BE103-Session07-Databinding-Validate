package re.api.dto.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import re.api.dto.Sex;
import re.api.validation.CheckLength;

import java.time.LocalDate;
@Getter@Setter
public class StudentAdd {
    @NotNull
    // độ dài ID phải đủ 10 k tự, bắt buộc bắt đầu bằng SV và 8 kí tự số
    @Pattern(regexp ="^SV[0-9]{8}$")
//    @NegativeOrZero
//    private int age;
    private String id;
//    @NotBlank(message = "Không để trống")
    @CheckLength
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
//    @Past
    private LocalDate dateOfBirth;
    private String address;
    @NotNull
    // s điện thoại bắt đầu bằng số 0 và có 10 kí tự số
    @Pattern(regexp = "^0[0-9]{9}$")
    private String phone;
    @NotNull
    private Sex sex;
}
