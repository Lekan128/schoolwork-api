package com.lekan.schoolwork.course;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.util.UUID;

@EntityView(Course.class)
public interface CourseShortView {
    @IdMapping
    UUID getId();
    String getTitle();
    String getCode();
}
