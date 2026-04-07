package re.api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import re.api.dto.Sex;

import java.time.LocalDate;
@Getter@Setter
public class StudentAdd {
    @NotNull
    // độ dài ID phải đủ 10 k tự, bắt buộc bắt đầu bằng SV và 8 kí tự số
    @Pattern(regexp ="^SV[0-9]{8}$")

    private String id;
    @NotBlank(message = "Không để trống")
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private LocalDate dateOfBirth;
    private String address;
    @NotNull
    // s điện thoại bắt đầu bằng số 0 và có 10 kí tự số
    @Pattern(regexp = "^0[0-9]{9}$")
    private String phone;
    @NotNull
    private Sex sex;
}
