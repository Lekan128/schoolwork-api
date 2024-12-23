package com.lekan.schoolwork.course.material;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lekan.schoolwork.course.Course;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "course_material")
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column
    public String name;

    @Column
    public String link;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course course;

    public static CourseMaterial newInstance(CourseMaterialDto dto, Course course){
        CourseMaterial courseMaterial = new CourseMaterial();
        courseMaterial.name = dto.name;
        courseMaterial.link = dto.link;
        courseMaterial.course = course;
        return courseMaterial;
    }
}
