package com.lekan.schoolwork.level;

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
@RequestMapping("level")
@AllArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("hello")
    public String hello(){
        return "<h1>Hello<h1>";
    }
    @GetMapping
    public ResponseEntity<List<Level>> findAll(){;
        return ResponseEntity.ok(levelService.find());
    }

    @PostMapping
    public ResponseEntity<List<Level>> create(@RequestBody List<String> levelNames){;
        return new ResponseEntity<>(levelService.createFaculties(levelNames), HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Level> getByName(@PathVariable("name") String levelName){;
        return ResponseEntity.ok(levelService.getByName(levelName));
    }
}
