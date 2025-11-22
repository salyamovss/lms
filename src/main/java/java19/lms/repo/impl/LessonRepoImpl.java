package java19.lms.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java19.lms.models.Lesson;
import java19.lms.repo.LessonRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LessonRepoImpl implements LessonRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Lesson save(Lesson lesson) {
        return entityManager.merge(lesson); // сохраняет или обновляет
    }

    @Override
    public List<Lesson> findAll() {
        return entityManager.createQuery("SELECT l FROM Lesson l", Lesson.class)
                .getResultList();
    }

    @Override
    public Lesson findById(Long id) {
        return entityManager.find(Lesson.class, id);
    }

    @Override
    public Lesson update(Lesson lesson) {
        return entityManager.merge(lesson);
    }

    @Override
    public void deleteById(Long id) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        if (lesson != null) {
            entityManager.remove(lesson);
        }
    }
}
