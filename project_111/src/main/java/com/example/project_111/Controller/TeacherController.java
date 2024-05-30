package com.example.project_111.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_111.Entity.Student;
import com.example.project_111.Entity.Teacher;
import com.example.project_111.Service.StudentService;
import com.example.project_111.Service.TeacherService;

@RestController
@RequestMapping("/api/registration")
public class TeacherController {

    private final TeacherService teacherService;
    private final StudentService studentService;  // Declare StudentService

    @Autowired
    public TeacherController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;  // Inject StudentService
    }

    @GetMapping("/courses")
    public List<String> getCourses() {
        return teacherService.findAllCourses();
    }

    @GetMapping("/teachers/{course}")
    public List<Teacher> getTeachersByCourse(@PathVariable String course) {
        return teacherService.findTeachersByCourse(course);
    }

    @GetMapping("/availability/{teacherId}")
    public List<String> getTeacherAvailability(@PathVariable Long teacherId) {
        return teacherService.getTeacherAvailability(teacherId);
    }

    @PostMapping("/register/teacher")
    public Teacher registerTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }

    @PostMapping("/register/student")
    public String registerStudent(@RequestBody Student student) {
        studentService.saveStudent(student);  // Use StudentService to save student
        return "Student registered successfully";
    }
}
