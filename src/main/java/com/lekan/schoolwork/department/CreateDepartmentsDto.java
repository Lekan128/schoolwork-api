package com.lekan.schoolwork.department;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class CreateDepartmentsDto {
    @NotBlank
    public String facultyName;
    @NotEmpty
    public List<String> departmentNames;
}
