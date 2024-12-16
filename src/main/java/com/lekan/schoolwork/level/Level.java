package com.lekan.schoolwork.level;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "level")
@NoArgsConstructor
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(unique = true, nullable = false)
    public String name;
    public static Level newInstance(String name) {
        Level level = new Level();
        level.name = name;
        return level;
    }
}
