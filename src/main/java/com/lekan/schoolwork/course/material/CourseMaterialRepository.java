package com.lekan.schoolwork.course.material;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, UUID> {
}
