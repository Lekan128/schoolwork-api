package com.lekan.schoolwork.course;

import com.lekan.schoolwork.course.material.CourseMaterialDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public class CourseDto {
    @NotBlank
    public String title;
    @NotBlank
    public String code;
    @NotBlank
    public UUID departmentId;
    @NotNull
    public Course.Semester semester;
    @NotBlank
    public UUID levelId;
    public List<CourseMaterialDto> courseMaterials;
}
