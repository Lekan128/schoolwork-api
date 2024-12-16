package com.lekan.schoolwork.review;

import com.lekan.schoolwork.course.Course;
import com.lekan.schoolwork.course.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final CourseService courseService;

    public Review create(ReviewDto dto){
        Course course = courseService.get(dto.courseId);

        Review review = Review.builder()
                .review(dto.review)
                .lecturer(dto.lecturer)
                .course(course)
                .testTips(dto.testTips)
                .examTips(dto.examTips)
                .build();
        return reviewRepository.save(review);
    }

    public List<Review> findByCourse(UUID courseId){
        return reviewRepository.findByCourse_Id(courseId);
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }
}
