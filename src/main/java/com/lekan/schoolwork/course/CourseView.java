package com.lekan.schoolwork.course;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.lekan.schoolwork.course.material.CourseMaterialView;
import com.lekan.schoolwork.department.DepartmentView;
import com.lekan.schoolwork.level.Level;

import java.util.List;
import java.util.UUID;

@EntityView(Course.class)
public interface CourseView {
    @IdMapping
    UUID getId();
    String getTitle();
    String getCode();
    Course.Semester getSemester();
    Level getLevel();
    DepartmentView getDepartment();
    List<CourseMaterialView> getCourseMaterials();
}
