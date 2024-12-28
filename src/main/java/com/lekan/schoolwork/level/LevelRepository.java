package com.lekan.schoolwork.level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LevelRepository extends JpaRepository<Level, UUID> {
//    @Query("select f from level f where f.name = :name")
    Optional<Level> findByName(String name);
}
