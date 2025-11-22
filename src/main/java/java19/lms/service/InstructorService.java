package java19.lms.service;

import java19.lms.models.Instructor;

import java.util.List;

public interface InstructorService {
    Instructor save(Instructor instructor);
    List<Instructor> findAll();
    Instructor findById(Long id);
    Instructor update(Instructor instructor);
    void deleteById(Long id);
}
