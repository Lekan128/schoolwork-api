package com.lekan.schoolwork.level;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LevelService {
    private final LevelRepository levelRepository;

    public List<Level> createFaculties(List<String> levelNames){
        Set<Level> faculties = levelNames.stream().map(Level::newInstance).collect(Collectors.toSet());
        return levelRepository.saveAll(faculties);
    }

    public List<Level> find(){
        return levelRepository.findAll();
    }

    public Level getByName(String levelName) {
        return levelRepository.findByName(levelName).orElseThrow(() -> new EntityNotFoundException("level does not exist"));
    }

    public Level get(UUID levelId){
        return levelRepository.findById(levelId).orElseThrow(()-> new EntityNotFoundException("level does not exist"));
    }
}
