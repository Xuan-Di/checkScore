package com.wzxlq.score.service;

import com.wzxlq.score.entity.Teacher;
import java.util.List;

/**
 * (Teacher)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 22:01:16
 */
public interface TeacherService {

    /**
     * 根据workNum查询该老师所有的班级信息
     * @param workNum 工号
     * @return
     */
    List<Teacher> queryAllByWorkNum(String workNum);

    void insertAllTeachers(List<Teacher> teacherList);
}