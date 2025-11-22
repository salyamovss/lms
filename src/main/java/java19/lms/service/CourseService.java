package java19.lms.service;

import java19.lms.models.Course;

import java.util.List;

public interface CourseService {
    Course save(Course course);
    List<Course> findAll();
    Course findById(Long id);
    Course update(Course course);
    void deleteById(Long id);
}
