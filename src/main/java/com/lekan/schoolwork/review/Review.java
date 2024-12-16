package com.lekan.schoolwork.review;

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
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "review")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;

    @Column
    public String lecturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course course;

    @Column
    public String review;

    @Column(name = "test_tips")
    public String testTips;

    @Column(name = "exam_tips")
    public String examTips;
}
