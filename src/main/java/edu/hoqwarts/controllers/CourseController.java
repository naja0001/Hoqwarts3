package edu.hoqwarts.controllers;

import edu.hoqwarts.services.CourseServices;
import edu.hoqwarts.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseServices courseServices;

    @Autowired
    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseServices.getCourses();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return courseServices.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseServices.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseServices.deleteCourse(id);
    }
}
