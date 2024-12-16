package com.lekan.schoolwork.department;

import com.lekan.schoolwork.faculty.Faculty;
import com.lekan.schoolwork.faculty.FacultyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final FacultyService facultyService;

    public List<Department> createDepartments(CreateDepartmentsDto dto){
        Faculty faculty = facultyService.getByName(dto.facultyName);
        Set<Department> departments = dto.departmentNames.stream().map(name -> Department.newInstance(name, faculty)).collect(Collectors.toSet());
        return departmentRepository.saveAll(departments);
    }

    public List<Department> find(){
        return departmentRepository.findAll();
    }

    public List<Department> findByFacultyName(String  facultyName){
        Faculty faculty = facultyService.getByName(facultyName);
        return departmentRepository.findAllByFacultyName(facultyName);
    }

    public Department get(UUID id){
        return departmentRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("Department not found"));
    }
}
