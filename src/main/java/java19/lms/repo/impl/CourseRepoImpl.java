package java19.lms.repo.impl;

import jakarta.persistence.EntityManager;
import java19.lms.models.Course;
import java19.lms.repo.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseRepoImpl implements CourseRepo {

    private final EntityManager entityManager;

    public CourseRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public List<Course> findAll() {
        return entityManager
                .createQuery("select c from Course c", Course.class)
                .getResultList();
    }

    @Override
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public Course update(Course course) {
        return entityManager.merge(course);
    }

    @Override
    public void deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        if (course != null) {
            entityManager.remove(course);
        }
    }
}
