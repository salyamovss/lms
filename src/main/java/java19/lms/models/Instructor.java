package java19.lms.models;

import jakarta.persistence.Entity;

@Entity
@Table(name = "instructors")
public class Instructor {
    @Id @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    @JoinTable(name = "course_instructors",
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();
    // getters/setters
}