package java19.lms.service.impl;

import java19.lms.models.Student;
import java19.lms.repo.StudentRepo;
import java19.lms.service.StudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    public StudentServiceImpl(StudentRepo repository) {
        this.repository = repository;
    }

    private final StudentRepo repository;

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(Long id, Student newData) {
        Student old = repository.findById(id);
        if (old != null) {
            old.setFirstName(newData.getFirstName());
            old.setEmail(newData.getEmail());
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
