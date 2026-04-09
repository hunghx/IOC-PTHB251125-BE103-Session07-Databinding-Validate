package re.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import re.api.dto.Sex;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    private String id;
    private String name;
    private String email;
    private LocalDate dateOfBirth;
    private String address;
    private String phone;
    private Sex sex;
    private boolean isActive; // trạng thái tài khoản
    @ManyToOne
    @JoinColumn(name="class_id")
    private Classes classes;
}
