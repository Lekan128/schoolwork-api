package com.lekan.schoolwork.course;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.lekan.schoolwork.department.Department;
import com.lekan.schoolwork.level.Level;
import com.lekan.schoolwork.review.Review;

import java.util.List;
import java.util.UUID;

@EntityView(Course.class)
public interface CourseView extends CourseShortView {
    List<Review> getReviews();
    List<String> getMaterialLinks();
    Course.Semester getSemester();
    Level getLevel();
    Department getDepartment();
}
