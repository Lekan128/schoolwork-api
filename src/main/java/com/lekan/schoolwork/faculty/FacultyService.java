package com.lekan.schoolwork.faculty;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public List<Faculty> createFaculties(List<String> facultyNames){
        Set<Faculty> faculties = facultyNames.stream().map(Faculty::newInstance).collect(Collectors.toSet());
        return facultyRepository.saveAll(faculties);
    }

    public List<Faculty> find(){
        return facultyRepository.findAll();
    }

    public Faculty getByName(String facultyName) {
        return facultyRepository.findByName(facultyName).orElseThrow(() -> new EntityNotFoundException("Faculty does not exist"));
    }
}
