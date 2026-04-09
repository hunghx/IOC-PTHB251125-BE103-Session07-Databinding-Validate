package re.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.api.exception.ForeignKeyException;
import re.api.repository.IClassesRepository;
import re.api.repository.IStudentRepository;

@RestController
@RequestMapping("/api/v1/classes")
@RequiredArgsConstructor
public class ClassesController {
    private final IClassesRepository classesRepository;
    private final IStudentRepository sudentRepository;;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ForeignKeyException {
        // kiểm tra tồn tại sinh viên
        if (sudentRepository.existsByClasses_Id(id)){
            throw new ForeignKeyException("Class with id " + id + " has student");
        }
        classesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
