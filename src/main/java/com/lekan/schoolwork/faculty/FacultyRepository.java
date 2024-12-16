package com.lekan.schoolwork.faculty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
//    @Query("select f from Faculty f where f.name = :name")
    Optional<Faculty> findByName(String name);
}
