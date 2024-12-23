package com.lekan.schoolwork.faculty;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.util.UUID;

@EntityView(Faculty.class)
public interface FacultyView {
    @IdMapping
    UUID getId();
    String getName();
}
