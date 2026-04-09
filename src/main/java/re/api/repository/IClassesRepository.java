package re.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import re.api.entity.Classes;
@Repository
public interface IClassesRepository extends JpaRepository<Classes, Long> {

}
