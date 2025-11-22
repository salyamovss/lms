package java19.lms.repo;

import java19.lms.models.Lesson;

import java.util.List;

public interface LessonRepo {
    Lesson save(Lesson lesson);
    List<Lesson> findAll();
    Lesson findById(Long id);
    Lesson update(Lesson lesson);
    void deleteById(Long id);
}
