package java19.lms.controller;

import java19.lms.models.Course;
import java19.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Получить список всех курсов
    @GetMapping
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.findAll());
        return "course/list"; // форвард на /WEB-INF/views/course/list.html
    }

    // Форма создания нового курса
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "course/create";
    }

    // Сохранить новый курс
    @PostMapping
    public String saveCourse(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    // Форма редактирования существующего курса
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Course course = courseService.findById(id);
        model.addAttribute("course", course);
        return "course/edit";
    }

    // Обновить курс
    @PostMapping("/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
        course.setId(id);
        courseService.update(course);
        return "redirect:/courses";
    }

    // Удалить курс
    @GetMapping("/{id}/delete")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteById(id);
        return "redirect:/courses";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/courses";
    }
}
