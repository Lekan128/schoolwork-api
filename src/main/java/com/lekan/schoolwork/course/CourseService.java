package com.lekan.schoolwork.course;

import com.lekan.schoolwork.department.Department;
import com.lekan.schoolwork.department.DepartmentService;
import com.lekan.schoolwork.faculty.Faculty;
import com.lekan.schoolwork.faculty.FacultyService;
import com.lekan.schoolwork.level.Level;
import com.lekan.schoolwork.level.LevelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentService departmentService;
    private final LevelService levelService;

    public Course create(@RequestBody CourseDto dto){
        Department department = departmentService.get(dto.departmentId);
        Level level = levelService.getByName(dto.level);
        Course course = Course.builder()
                .department(department)
                .title(dto.title)
                .code(dto.code)
                .materialLinks(dto.materialLinks)
                .code(dto.code)
                .semester(dto.semester)
                .level(level).build();
        return courseRepository.save(course);
    }

    public List<Course> find(){
        return courseRepository.findAll();
    }

    public List<Course> findAllByDepartment(UUID dptId){
        return courseRepository.findAllByDepartmentId(dptId);
    }

    public Course get(UUID id){
        return courseRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("Department not found"));
    }
}
