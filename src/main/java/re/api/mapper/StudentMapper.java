package re.api.mapper;

import re.api.dto.request.StudentAdd;
import re.api.dto.response.StudentResponse;
import re.api.entity.Student;

public class StudentMapper {
    public static StudentResponse mapToResponse(Student entity){
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setId(entity.getId());
        studentResponse.setName(entity.getName());
        studentResponse.setEmail(entity.getEmail());
        studentResponse.setSex(entity.getSex());
        studentResponse.setDateOfBirth(entity.getDateOfBirth());
        return studentResponse;

    }
    public static Student mapToEntity(StudentAdd request){
        Student student = new Student();
        student.setId(request.getId());
        student.setName(request.getName());
        student.setEmail(request.getEmail());
        student.setSex(request.getSex());
        student.setPhone(request.getPhone());
        student.setAddress(request.getAddress());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setActive(false);
        return student;
    }
}
