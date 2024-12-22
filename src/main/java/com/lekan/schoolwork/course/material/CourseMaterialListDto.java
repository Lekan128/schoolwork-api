package com.lekan.schoolwork.course.material;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class CourseMaterialListDto {
    @NotEmpty
    List<CourseMaterialDto> courseMaterials;

    @NotNull
    public UUID courseId;
}
