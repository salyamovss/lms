package java19.lms.repo;

import java19.lms.models.Course;

import java.util.List;

public interface CourseRepo {
    Course save(Course course);
    List<Course> findAll();
    Course findById(Long id);
    Course update(Course course);
    void deleteById(Long id);
}
