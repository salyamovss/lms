package java19.lms.service.impl;

import java19.lms.models.Course;
import java19.lms.repo.CourseRepo;
import java19.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Course save(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public Course update(Course course) {
        return courseRepo.update(course);
    }

    @Override
    public void deleteById(Long id) {
        courseRepo.deleteById(id);
    }
}
