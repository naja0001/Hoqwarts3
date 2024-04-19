package edu.hoqwarts.models;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import lombok.*;


@Getter
@Setter
@Entity

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private int schoolYear;
    private boolean current;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    // Constructors

    public Course() {
    }

    public Course(String subject,
                  int schoolYear,
                  boolean current,
                  Teacher teacher,
                  List<Student> students) {
        this.subject = subject;
        this.schoolYear = schoolYear;
        this.current = current;
        this.teacher = teacher;
        this.students = students;
    }


}