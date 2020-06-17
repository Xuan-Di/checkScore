package com.wzxlq.score.service;

import com.wzxlq.score.entity.CourseGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (CourseGrade)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 22:00:38
 */
public interface CourseGradeService {

    /**
     * 根据班级名称和学期查询不及格名单
     * @param className
     * @param term
     * @return
     */
    List<CourseGrade> queryFlunkByClassAndTerm(String className, String term);

    /**
     * 根据班级名称、学期、科目名称查询单科成绩
     * @param className
     * @param courseName
     * @return
     */
    List<CourseGrade> queryOneGradeByClassAndTermAndCourse(String className, String courseName);

    void insertAllGrades(List<CourseGrade> courseGradeList);
}