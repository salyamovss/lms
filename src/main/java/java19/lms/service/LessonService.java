package java19.lms.service;

import java19.lms.models.Lesson;

import java.util.List;

public interface LessonService {
    Lesson save(Lesson lesson);
    List<Lesson> findAll();
    Lesson findById(Long id);
    Lesson update(Lesson lesson);
    void deleteById(Long id);
}
