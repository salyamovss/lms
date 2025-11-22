package java19.lms.controller;

import java19.lms.models.Course;
import java19.lms.models.Lesson;
import java19.lms.service.CourseService;
import java19.lms.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final CourseService courseService;

    public LessonController(LessonService lessonService, CourseService courseService) {
        this.lessonService = lessonService;
        this.courseService = courseService;
    }

    @GetMapping
    public String getAllLessons(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lesson/list";
    }

    @GetMapping("/new")
    public String createLessonForm(Model model) {
        model.addAttribute("lesson", new Lesson());
        model.addAttribute("courses", courseService.findAll());
        return "lesson/create";
    }

    @PostMapping
    public String saveLesson(@RequestParam String title,
                             @RequestParam String description,
                             @RequestParam Long courseId,
                             @RequestParam String publisherDate) {

        Lesson lesson = new Lesson();
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setPublisherDate(LocalDate.parse(publisherDate));

        Course course = courseService.findById(courseId);
        lesson.setCourse(course);

        lessonService.save(lesson);

        return "redirect:/lessons";
    }

    @GetMapping("/{id}/edit")
    public String editLessonForm(@PathVariable Long id, Model model) {
        Lesson lesson = lessonService.findById(id);
        model.addAttribute("lesson", lesson);
        model.addAttribute("courses", courseService.findAll());
        return "lesson/edit";
    }

    @PostMapping("/{id}")
    public String updateLesson(@PathVariable Long id,
                               @RequestParam String title,
                               @RequestParam String description,
                               @RequestParam Long courseId,
                               @RequestParam String publisherDate) {

        Lesson lesson = lessonService.findById(id);
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setPublisherDate(LocalDate.parse(publisherDate));

        Course course = courseService.findById(courseId);
        lesson.setCourse(course);

        lessonService.update(lesson);

        return "redirect:/lessons";
    }

    @GetMapping("/{id}/delete")
    public String deleteLesson(@PathVariable Long id) {
        lessonService.deleteById(id);
        return "redirect:/lessons";
    }
}
