package com.lekan.schoolwork.course;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("course")
@AllArgsConstructor
public class CourseController {

    private final CourseService service;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody CourseDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CourseShortView>> findAll(
            @RequestParam(required = false) UUID departmentId,
            @RequestParam(required = false) String facultyName,
            @RequestParam(required = false) UUID levelId,
            @RequestParam(required = false) Course.Semester semester,
            @RequestParam(required = false) String search //course title and code
            ){
        List<CourseShortView> courseShortViews = service.filter(departmentId, facultyName, levelId, semester, search);
        return ResponseEntity.ok(courseShortViews);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<List<Course>> findByDepartment(@PathVariable UUID departmentId){
        return ResponseEntity.ok(service.findAllByDepartment(departmentId));
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseView> get(@PathVariable UUID id){
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<Course> update(@PathVariable UUID id, @RequestBody CourseDto dto){
        return ResponseEntity.ok(service.update(id, dto));
    }
}
