package com.wzxlq.score.service.impl;

import com.wzxlq.score.entity.Student;
import com.wzxlq.score.dao.StudentDao;
import com.wzxlq.score.service.StudentService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2020-02-27 22:01:05
 */
@Service("studentService")
@CacheConfig(cacheNames = "grades1")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;


    @Override
    @Cacheable
    public List<Student> queryAllByClassAndTerm(String className, String term) {
        System.out.println("进来说明没有进行缓存(第一次进入)");
        List<Student> students = studentDao.queryAllByClassAndTerm(className, term);
        System.out.println(students);
        return students;
    }

    @Override
    public void insertAllStudent(List<Student> studentList) {
        studentDao.insertAllStudent(studentList);
    }
}