package com.example.project_111.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project_111.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
