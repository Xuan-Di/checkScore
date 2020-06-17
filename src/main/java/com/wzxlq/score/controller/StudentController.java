package com.wzxlq.score.controller;

import com.wzxlq.score.entity.Student;
import com.wzxlq.score.service.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("query")
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 根据班级名称和学期查询总体成绩,包括每个学生的所有科目成绩
     *
     * @param className
     * @param term
     * @return
     */
    @GetMapping("term/allGrade")
    public List<Student> selectAllGrade(String className, String term) {

        return this.studentService.queryAllByClassAndTerm(className, term);
    }
}
