package re.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.api.entity.Student;
@Repository
public interface IStudentRepository extends JpaRepository<Student, String> {
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    boolean existsByClasses_Id(Long id);
}
