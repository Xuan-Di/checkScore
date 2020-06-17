package com.wzxlq.score.controller;


import com.wzxlq.score.entity.Major;
import com.wzxlq.score.service.MajorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("query")
public class MajorController {
    @Resource
    private MajorService majorService;

    /**
     * 根据班级名称和学期查询课程名称
     * @param className
     * @param grade 学期 格式：2017-2018-1
     * @return
     */
    @GetMapping("courseName")
    public List<Major> selectCourseName(String className, String grade) {
        System.out.println(className);
        System.out.println(grade);
        String majorName = className.substring(0, className.length() - 2);
        return this.majorService.queryAllByMajorAndGrade(majorName, grade);
    }
}
