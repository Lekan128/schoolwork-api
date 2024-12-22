package com.lekan.schoolwork.course.material;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.lekan.schoolwork.course.Course;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseMaterialService {
    private final CourseMaterialRepository courseMaterialRepository;
    private final EntityManager em;
    private final CriteriaBuilderFactory cbf;

//    public List<CourseMaterial> create(List<CourseMaterialDto> courseMaterialDtos, Course course){
//        List<CourseMaterial> courseMaterials = courseMaterialDtos.stream().map(dto -> CourseMaterial.newInstance(dto, course)).toList();
//        return courseMaterialRepository.saveAll(courseMaterials);
//    }
    public List<CourseMaterial> create(List<CourseMaterialDto> courseMaterialDtos, Course course){
        return courseMaterialDtos
                .stream()
                .map(dto -> CourseMaterial.newInstance(dto, course))
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteCourseMaterialsUsingEntityManager(UUID courseId) {
//        I think there is an issue deleting with the repository
        CriteriaBuilder<CourseMaterial> criteriaBuilder = cbf.create(em, CourseMaterial.class);
        criteriaBuilder.where("course.id").eq(courseId);
        List<CourseMaterial> resultList = criteriaBuilder.getResultList();
        resultList.forEach(em::remove);
    }
}
