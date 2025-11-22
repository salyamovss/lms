package java19.lms.service.impl;

import java19.lms.models.Instructor;
import java19.lms.repo.InstructorRepo;
import java19.lms.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepo instructorRepo;

    public InstructorServiceImpl(InstructorRepo instructorRepo) {
        this.instructorRepo = instructorRepo;
    }

    @Override
    public Instructor save(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor findById(Long id) {
        return instructorRepo.findById(id);
    }

    @Override
    public Instructor update(Instructor instructor) {
        return instructorRepo.update(instructor);
    }

    @Override
    public void deleteById(Long id) {
        instructorRepo.deleteById(id);
    }
}
