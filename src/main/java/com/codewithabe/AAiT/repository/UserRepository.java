package com.codewithabe.AAiT.repository;

import com.codewithabe.AAiT.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Student,Long> {
    Student findByUgr(String ugr);
}
