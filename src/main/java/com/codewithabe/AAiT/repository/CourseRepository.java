package com.codewithabe.AAiT.repository;

import com.codewithabe.AAiT.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer > {
}
