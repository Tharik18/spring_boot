package com.example.project_111.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project_111.Entity.Teacher;
import com.example.project_111.Repository.TeacherRepository;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public List<String> findAllCourses() {
        return teacherRepository.findAll().stream()
                .flatMap(teacher -> teacher.getCourses().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Teacher> findTeachersByCourse(String course) {
        return teacherRepository.findAll().stream()
                .filter(teacher -> teacher.getCourses().contains(course))
                .collect(Collectors.toList());
    }

    public List<String> getTeacherAvailability(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .map(Teacher::getAvailability)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
}
