package com.wzxlq.score.controller;

import com.wzxlq.score.entity.CourseGrade;
import com.wzxlq.score.service.CourseGradeService;
import com.wzxlq.score.tools.SortWays;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("query")
public class CourseGradeController {
    @Resource
    private CourseGradeService courseGradeService;

    /**
     * 根据班级名称和学期查询不及格名单
     * @param className 班级名称
     * @param term 学期
     * @return
     */
    @GetMapping("term/flunk")
    public List<CourseGrade> selectFlunk(String className, String term){
        return this.courseGradeService.queryFlunkByClassAndTerm(className, term);
    }

    /**
     * 根据班级名称、学期、课程名称查询不及格名单
     * @param className
     * @param courseName
     * @return
     */
    @GetMapping("one/grade")
    public List<CourseGrade> selectOneGrade(String className, String courseName) {
        List<CourseGrade> courseGrades = this.courseGradeService.queryOneGradeByClassAndTermAndCourse(className, courseName);
        SortWays.sortCourseGradeByGrade(courseGrades);
        return courseGrades;
    }
}
