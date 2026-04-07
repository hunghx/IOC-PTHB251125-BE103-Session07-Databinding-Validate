package re.api.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import re.api.model.Student;

@RestController
public class StudentController {
    // Data binding : liên kết dữ liệu
    // Xử lí được xác thực dữ liệu

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        // nhận đc thông tin gửi lên nhưng phải ánh xạ về 1 đối tượng
        // @ModelAttribute : form-data  : html form (có thể gửi tệp tin)
        // @RequestBody : json : ko gửi đc file
        return student;
    }
}
