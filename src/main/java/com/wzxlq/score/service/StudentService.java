package com.wzxlq.score.service;

import com.wzxlq.score.entity.Student;

import java.util.List;

/**
 * (Student)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 22:01:05
 */
public interface StudentService {

    /**
     * 根据班级名称和学期查询所有的学生信息及各科目成绩
     * @param className
     * @param term
     * @return
     */
    List<Student> queryAllByClassAndTerm(String className, String term);

    void insertAllStudent(List<Student> studentList);
}