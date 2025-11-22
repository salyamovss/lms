package java19.lms.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Builder
@Table(name = "cources")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lessons_seq")
    @SequenceGenerator(name = "lessons_seq", sequenceName = "lessons_sequence", allocationSize = 1, initialValue = 10)
    Long id;
    String title;
    LocalDate publisherDate;
    String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublisherDate() {
        return publisherDate;
    }

    public void setPublisherDate(LocalDate publisherDate) {
        this.publisherDate = publisherDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Lesson(Long id, String title, LocalDate publisherDate, String description, Course course) {
        this.id = id;
        this.title = title;
        this.publisherDate = publisherDate;
        this.description = description;
        this.course = course;
    }

    public Lesson() {
    }
}