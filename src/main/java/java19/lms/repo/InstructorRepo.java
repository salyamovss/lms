package java19.lms.repo;

import java19.lms.models.Instructor;
import java.util.List;

public interface InstructorRepo {
    Instructor save(Instructor instructor);
    List<Instructor> findAll();
    Instructor findById(Long id);
    Instructor update(Instructor instructor);
    void deleteById(Long id);
}
