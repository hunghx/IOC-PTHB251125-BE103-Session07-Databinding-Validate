package re.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import re.api.dto.request.StudentAdd;
import re.api.dto.response.StudentResponse;
import re.api.entity.Student;
import re.api.mapper.StudentMapper;
import re.api.repository.IStudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService{
    private final IStudentRepository studentRepository;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        // chuyển đổi thành DTO
        return studentList.stream().map(StudentMapper::mapToResponse).toList();
    }

    @Override
    public StudentResponse addStudent(StudentAdd request) {
        // Biến từ dto request -> entity
        Student entity = StudentMapper.mapToEntity(request);
        // luuw
        entity = studentRepository.save(entity);
        // BIến đổi từ entity -> response
        return StudentMapper.mapToResponse(entity);
    }
}
