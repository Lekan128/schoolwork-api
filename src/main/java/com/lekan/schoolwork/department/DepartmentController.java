package com.lekan.schoolwork.department;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("department")
@AllArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> findAll(){
        return ResponseEntity.ok(departmentService.find());
    }

    @GetMapping("{facultyName}")
    public ResponseEntity<List<Department>> findAllByFaculty(@PathVariable String facultyName){
        return ResponseEntity.ok(departmentService.findByFacultyName(facultyName));
    }

    @PostMapping
    public ResponseEntity<List<Department>> create(@RequestBody CreateDepartmentsDto dto){
        return new ResponseEntity<>(departmentService.createDepartments(dto), HttpStatus.CREATED);

    }
}
