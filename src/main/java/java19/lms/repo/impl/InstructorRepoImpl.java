package java19.lms.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java19.lms.models.Instructor;
import java19.lms.repo.InstructorRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstructorRepoImpl implements InstructorRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Instructor save(Instructor instructor) {
        return em.merge(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return em.createQuery("select i from Instructor i", Instructor.class)
                .getResultList();
    }

    @Override
    public Instructor findById(Long id) {
        return em.find(Instructor.class, id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return em.merge(instructor);
    }

    @Override
    public void deleteById(Long id) {
        Instructor instructor = findById(id);
        if (instructor != null) {
            em.remove(instructor);
        }
    }
}
