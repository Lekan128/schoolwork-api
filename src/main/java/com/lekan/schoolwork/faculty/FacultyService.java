package com.lekan.schoolwork.faculty;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final CriteriaBuilderFactory cbf;

    public List<Faculty> createFaculties(List<String> facultyNames){
        Set<Faculty> faculties = facultyNames.stream().map(Faculty::newInstance).collect(Collectors.toSet());
        return facultyRepository.saveAll(faculties);
    }

    public List<FacultyView> find(){
        CriteriaBuilder<Faculty> cb = cbf.create(em, Faculty.class);
        CriteriaBuilder<FacultyView> facultyCriteriaBuilder = evm.applySetting(EntityViewSetting.create(FacultyView.class), cb);
        List<FacultyView> faculties = facultyCriteriaBuilder.getResultList();
        return faculties;

    }

    public Faculty getByName(String facultyName) {
        return facultyRepository.findByName(facultyName).orElseThrow(() -> new EntityNotFoundException("Faculty does not exist"));
    }
}
