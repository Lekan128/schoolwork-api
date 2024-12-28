package com.lekan.schoolwork.course;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.lekan.schoolwork.course.material.CourseMaterialService;
import com.lekan.schoolwork.department.Department;
import com.lekan.schoolwork.department.DepartmentService;
import com.lekan.schoolwork.level.Level;
import com.lekan.schoolwork.level.LevelService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final DepartmentService departmentService;
    private final LevelService levelService;
    private final CourseMaterialService courseMaterialService;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final CriteriaBuilderFactory cbf;

    public Course create(CourseDto dto){
        Department department = departmentService.get(dto.departmentId);
        Level level = levelService.get(dto.levelId);
        Course course = Course.builder()
                .department(department)
                .title(dto.title)
                .code(dto.code)
                .semester(dto.semester)
                .level(level).build();

        course.courseMaterials = courseMaterialService.create(dto.courseMaterials, course);

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

    public List<Course> findAllByDepartment(UUID dptId){
        return courseRepository.findAllByDepartmentId(dptId);
    }

    public Course get(UUID id){
        return courseRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("Course not found"));
    }

    public CourseView getById(UUID id){
        Course course = get(id);
        return evm.find(em, CourseView.class, course.id);
    }

    public Course update(UUID courseId, CourseDto dto){
        Course course = get(courseId);
        //Add later if needed
//        Department department = departmentService.get(dto.departmentId);
//        Level level = levelService.getByName(dto.level);
//
//        course.department = department;
//        course.level = level;
        course.title = dto.title;
        course.code = dto.code;
        course.semester = dto.semester;

        courseMaterialService.deleteCourseMaterialsUsingEntityManager(course.id);

        if (dto.courseMaterials!=null && !dto.courseMaterials.isEmpty()){
            course.courseMaterials = courseMaterialService.create(dto.courseMaterials, course);
        }

        return courseRepository.save(course);
    }
}
