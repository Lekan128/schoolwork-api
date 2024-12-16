package com.lekan.schoolwork.course;

import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CourseDto {
    @NotBlank
    public String title;
    @NotBlank
    public String code;
    public List<String> materialLinks;
    @NotBlank
    public UUID departmentId;
    @NotNull
    public Course.Semester semester;
    @NotBlank
    public String level;
}
