package com.lekan.schoolwork.course.material;

import jakarta.validation.constraints.Size;

public class CourseMaterialDto {
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 64, message = "{validation.name.size.too_long}")
    public String name;
    @Size(min = 2, message = "{validation.name.size.too_short}")
    @Size(max = 225, message = "{validation.name.size.too_long}")
    public String link;
}
