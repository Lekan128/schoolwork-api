package com.lekan.schoolwork.review;

import com.lekan.schoolwork.course.Course;
import com.lekan.schoolwork.course.CourseDto;
import com.lekan.schoolwork.course.CourseService;
import jakarta.websocket.server.PathParam;
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
import java.util.UUID;

@RestController
@RequestMapping("review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService service;

    @PostMapping
    public ResponseEntity<Review> create(@RequestBody ReviewDto dto){
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Review>> find(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<Review>> findByCourseId(@PathVariable UUID courseId){
        return ResponseEntity.ok(service.findByCourse(courseId));
    }
}
