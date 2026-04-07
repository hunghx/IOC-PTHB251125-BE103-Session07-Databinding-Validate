package re.api.service;

import re.api.dto.request.StudentAdd;
import re.api.dto.response.StudentResponse;

import java.util.List;

public interface IStudentService {
    List<StudentResponse> getAllStudents();
    StudentResponse addStudent(StudentAdd request);
}
