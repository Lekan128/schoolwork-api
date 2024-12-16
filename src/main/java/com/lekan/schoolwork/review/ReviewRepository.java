package com.lekan.schoolwork.review;

import com.lekan.schoolwork.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {
    @Query("select r from Review r where r.course.id = :courseId")
    List<Review> findByCourse_Id(UUID courseId);
}
