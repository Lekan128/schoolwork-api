package com.lekan.schoolwork.faculty;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("faculty")
@AllArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("hello")
    public String hello(){
        return "<h1>Hello version - 2<h1>";
    }
    @GetMapping
    public ResponseEntity<List<FacultyView>> findAll(){;
        return ResponseEntity.ok(facultyService.find());
    }

    @PostMapping
    public ResponseEntity<List<Faculty>> create(@RequestBody List<String> facultyNames){;
        return new ResponseEntity<>(facultyService.createFaculties(facultyNames), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Faculty> getByName(@PathVariable("name") String facultyName){;
        return ResponseEntity.ok(facultyService.getByName(facultyName));
    }
}
