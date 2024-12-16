package com.lekan.schoolwork.department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    @Query("select d from Department d where d.faculty.name = :facultyName")
    List<Department> findAllByFacultyName(String facultyName);
}
