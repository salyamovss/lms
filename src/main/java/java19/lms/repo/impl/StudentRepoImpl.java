package java19.lms.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java19.lms.models.Student;
import java19.lms.repo.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

@Transactional
public class StudentRepoImpl implements StudentRepo {
    private final EntityManager entityManager;

    public StudentRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void update(Long id, Student newData) {
        entityManager.merge(newData);
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("select s from Student s", Student.class)
                .getResultList();
    }


    public void deleteById(Long id) {
        Student s = entityManager.find(Student.class, id);
        entityManager.remove(s);
    }
}

