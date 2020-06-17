package com.wzxlq.score.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (CourseGrade)实体类
 *
 * @author makejava
 * @since 2020-02-28 19:10:35
 */
@Data
@Accessors
public class CourseGrade implements Serializable {
    private static final long serialVersionUID = -10422456198484810L;
    
    private Integer id;
    
    private String studentNum;
    private String studentName;
    private String term;
    
    private String courseName;
    private String level;
    
    private int score;

    public CourseGrade(String studentNum, String studentName, String term, String courseName, String level, int score) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.term = term;
        this.courseName = courseName;
        this.level = level;
        this.score = score;
    }

    public CourseGrade() {
    }
}