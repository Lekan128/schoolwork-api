package com.lekan.schoolwork.department;

import com.lekan.schoolwork.faculty.Faculty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "department")
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column
    public String name;

    @ManyToOne
    @JoinColumn(name = "faculty", referencedColumnName = "name")
    public Faculty faculty;
    public static Department newInstance(String name, Faculty faculty) {
        Department department = new Department();
        department.name = name;
        department.faculty = faculty;
        return department;
    }
}
