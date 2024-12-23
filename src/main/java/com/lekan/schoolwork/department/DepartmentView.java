package com.lekan.schoolwork.department;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.lekan.schoolwork.faculty.FacultyView;

import java.util.UUID;

@EntityView(Department.class)
public interface DepartmentView {
    @IdMapping
    UUID getId();
    String getName();
    FacultyView getFaculty();
}
