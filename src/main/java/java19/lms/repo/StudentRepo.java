package java19.lms.repo;

import java19.lms.models.Student;

import java.util.List;
public interface StudentRepo {
    void save(Student student);
    Student findById(Long id);
    List<Student> findAll();
    void update(Long id, Student newData);
    void deleteById(Long id);
}
