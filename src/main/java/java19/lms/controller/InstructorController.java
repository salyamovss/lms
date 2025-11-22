package java19.lms.controller;

import java19.lms.models.Instructor;
import java19.lms.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("instructors", instructorService.findAll());
        return "instructors/list";  // /WEB-INF/views/instructors/list.jsp
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructors/create";  // create.jsp
    }

    @PostMapping
    public String save(@ModelAttribute Instructor instructor) {
        instructorService.save(instructor);
        return "redirect:/instructors";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("instructor", instructorService.findById(id));
        return "instructors/edit";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Instructor instructor) {
        instructor.setId(id);
        instructorService.update(instructor);
        return "redirect:/instructors";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        instructorService.deleteById(id);
        return "redirect:/instructors";
    }
}
