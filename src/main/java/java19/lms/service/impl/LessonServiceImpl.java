package java19.lms.service.impl;

import java19.lms.models.Lesson;
import java19.lms.repo.LessonRepo;
import java19.lms.service.LessonService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepo lessonRepo;

    public LessonServiceImpl(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    @Override
    public Lesson save(Lesson lesson) {
        return lessonRepo.save(lesson);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepo.findById(id);
    }

    @Override
    public Lesson update(Lesson lesson) {
        return lessonRepo.update(lesson);
    }

    @Override
    public void deleteById(Long id) {
        lessonRepo.deleteById(id);
    }
}
