package re.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import re.api.dto.request.StudentAdd;
import re.api.dto.response.StudentResponse;
import re.api.entity.Student;
import re.api.service.IStudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private IStudentService studentService;
    // Data binding : liên kết dữ liệu
    // Xử lí được xác thực dữ liệu

//    @PostMapping("/students")
//    public Student addStudent(@RequestBody Student student){
//        // nhận đc thông tin gửi lên nhưng phải ánh xạ về 1 đối tượng
//        // @ModelAttribute : form-data  : html form (có thể gửi tệp tin)
//        // @RequestBody : json : ko gửi đc file
//        return student;
//    }

    // lấy danh sách
    @GetMapping
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents()); // 200
    }
    // Thêm mới
    @PostMapping
    public ResponseEntity<StudentResponse> addStudent(@RequestBody StudentAdd request) {
        return new  ResponseEntity<>(studentService.addStudent(request), HttpStatus.CREATED); // 201
    }
    // Cập nhật
    // Xóa
}
