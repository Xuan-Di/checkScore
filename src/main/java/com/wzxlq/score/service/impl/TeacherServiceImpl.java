package com.wzxlq.score.service.impl;

import com.wzxlq.score.entity.Teacher;
import com.wzxlq.score.dao.TeacherDao;
import com.wzxlq.score.service.TeacherService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Teacher)表服务实现类
 *
 * @author makejava
 * @since 2020-02-27 22:01:16
 */
@Service("teacherService")

@CacheConfig(cacheNames = "grades4")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    private TeacherDao teacherDao;


    @Override
    public List<Teacher> queryAllByWorkNum(String workNum) {
        return teacherDao.queryAllByWorkNum(workNum);
    }

    @Override
    public void insertAllTeachers(List<Teacher> teacherList) {
        teacherDao.insertAllTeachers(teacherList);
    }
}