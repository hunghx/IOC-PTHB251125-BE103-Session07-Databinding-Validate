package re.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import re.api.dto.request.StudentAdd;
import re.api.dto.response.StudentResponse;
import re.api.entity.Student;
import re.api.service.IStudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;
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
    // Để kích hoạt cơ chế validate chúng ta sử dụng @Valid
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentAdd request, BindingResult result) {
        if (result.hasErrors()){
            // nếu có lỗi thì làm gì
            Map<String, String> errors = new HashMap<>(); // danh sách lỗi
            result.getFieldErrors().forEach(err->{
                errors.put(err.getField(), err.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors); // 400
        }
        try {

            return new ResponseEntity<>(studentService.addStudent(request), HttpStatus.CREATED); // 201}
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT); // 409 : Conflict
        }
    }
    // Cập nhật
    // Xóa
}
