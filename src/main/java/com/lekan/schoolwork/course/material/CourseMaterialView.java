package com.lekan.schoolwork.course.material;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import java.util.UUID;

@EntityView(CourseMaterial.class)
public interface CourseMaterialView {
    @IdMapping
    UUID getId();
    String getName();
    String getLink();

}
