package com.lekan.schoolwork.review;

import com.lekan.schoolwork.course.Course;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

public class ReviewDto {
    public String lecturer;
    public UUID courseId;
    public String review;
    public String testTips;
    public String examTips;
}
