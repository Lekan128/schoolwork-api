package com.lekan.schoolwork.course;

import com.lekan.schoolwork.department.Department;
import com.lekan.schoolwork.faculty.Faculty;
import com.lekan.schoolwork.level.Level;
import com.lekan.schoolwork.review.Review;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column
    public String title;

    @Column
    public String code;

    @OneToMany(mappedBy = "course")
    public List<Review> reviews;

    @Column(name = "material_links")
    public List<String> materialLinks;

    @Enumerated(EnumType.STRING)
    public Semester semester;

    @ManyToOne
    @JoinColumn(name = "level", referencedColumnName = "name")
    public Level level;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Department department;

    public enum Semester{FIRST, SECOND}

}
