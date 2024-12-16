package com.lekan.schoolwork.faculty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "faculty")
@NoArgsConstructor
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column(unique = true, nullable = false)
    public String name;
    public static Faculty newInstance(String name) {
        Faculty faculty = new Faculty();
        faculty.name = name;
        return faculty;
    }
}
