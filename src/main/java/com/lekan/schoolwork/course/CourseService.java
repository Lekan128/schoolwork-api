package com.lekan.schoolwork.course;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.lekan.schoolwork.department.Department;
import com.lekan.schoolwork.department.DepartmentService;
import com.lekan.schoolwork.level.Level;
import com.lekan.schoolwork.level.LevelService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentService departmentService;
    private final LevelService levelService;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final CriteriaBuilderFactory cbf;

    public Course create(@RequestBody CourseDto dto){
        Department department = departmentService.get(dto.departmentId);
        Level level = levelService.getByName(dto.level);
        Course course = Course.builder()
                .department(department)
                .title(dto.title)
                .code(dto.code)
                .materialLinks(dto.materialLinks)
                .code(dto.code)
                .semester(dto.semester)
                .level(level).build();
        return courseRepository.save(course);
    }

    public List<Course> find(){
        return courseRepository.findAll();
    }
    public List<CourseShortView> filter(UUID departmentId, String facultyName, UUID levelId, Course.Semester semester, String search) {
        CriteriaBuilder<Course> courseCriteriaBuilder = cbf.create(em, Course.class);

        if (departmentId!=null){
            courseCriteriaBuilder.where("department.id").eq(departmentId);
        }
        if (facultyName!=null){
            courseCriteriaBuilder.where("department.faculty.name").eq(facultyName);
        }
        if (levelId!=null){
            courseCriteriaBuilder.where("level.id").eq(levelId);
        }
        if (semester!=null){
            courseCriteriaBuilder.where("semester").eq(semester);
        }
        if (search!=null){
            String likeValue = "%" + search.toLowerCase() + "%";
            courseCriteriaBuilder.whereOr()
                    .where("LOWER(title)").like().value(likeValue).noEscape()
                    .where("LOWER(code)").like().value(likeValue).noEscape()
                    .endOr();
        }
        CriteriaBuilder<CourseShortView> courseViewCb = evm.applySetting(EntityViewSetting.create(CourseShortView.class), courseCriteriaBuilder);


        return courseViewCb.getResultList();
    }
/*
    public List<CourseShortView> filter(UUID departmentId, String facultyName, UUID levelId, Course.Semester semester, String search) {
        CriteriaBuilder<Course> cb = cbf.create(em, Course.class);
        CriteriaBuilder<CourseShortView> courseCriteriaBuilder = evm.applySetting(EntityViewSetting.create(CourseShortView.class), cb);

        if (departmentId!=null){
            courseCriteriaBuilder.where("department.id").eq(departmentId);
        }
        if (facultyName!=null){
            courseCriteriaBuilder.where("department.faculty.name").eq(facultyName);
        }
        if (levelId!=null){
            courseCriteriaBuilder.where("level.id").eq(levelId);
        }
        if (semester!=null){
            courseCriteriaBuilder.where("semester").eq(semester);
        }
        if (search!=null){
            String likeValue = "%" + search.toLowerCase() + "%";
            courseCriteriaBuilder.whereOr()
                    .where("LOWER(title)").like().value(likeValue).noEscape()
                    .where("LOWER(code)").like().value(likeValue).noEscape()
                    .endOr();
        }


        return courseCriteriaBuilder.getResultList();
    }
*/

    public List<Course> findAllByDepartment(UUID dptId){
        return courseRepository.findAllByDepartmentId(dptId);
    }

    public Course get(UUID id){
        return courseRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("Department not found"));
    }
}
