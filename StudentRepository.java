package com.biet_sm.StudentManagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends
        JpaRepository<Student, Long> {
}
