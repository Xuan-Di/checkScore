package com.wzxlq.score.service.impl;

import com.wzxlq.score.entity.CourseGrade;
import com.wzxlq.score.dao.CourseGradeDao;
import com.wzxlq.score.service.CourseGradeService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CourseGrade)表服务实现类
 *
 * @author makejava
 * @since 2020-02-27 22:00:38
 */
@Service("courseGradeService")
@CacheConfig(cacheNames = "grades2")
public class CourseGradeServiceImpl implements CourseGradeService {
    @Resource
    private CourseGradeDao courseGradeDao;


    @Override
    @Cacheable
    public List<CourseGrade> queryFlunkByClassAndTerm(String className, String term) {
        return courseGradeDao.queryFlunkByClassAndTerm(className, term);
    }

    @Override
    public void insertAllGrades(List<CourseGrade> courseGradeList) {
        courseGradeDao.insertAllGrades(courseGradeList);
    }

    @Override
    @Cacheable
    public List<CourseGrade> queryOneGradeByClassAndTermAndCourse(String className, String courseName) {
        return courseGradeDao.queryOneGradeByClassAndTermAndCourse(className, courseName);
    }
}