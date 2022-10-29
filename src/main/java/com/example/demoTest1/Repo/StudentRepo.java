package com.example.demoTest1.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoTest1.Entity.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

}
