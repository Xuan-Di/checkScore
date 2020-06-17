package com.wzxlq.score.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * (Student)实体类
 *
 * @author makejava
 * @since 2020-02-28 12:47:48
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 406806713808985250L;
    private Integer id;
    private String studentNum;
    private String studentName;
    private String className;
    private String term;
    private Integer courseNum;
    private Integer flunkNum;
    private Float avgScore;
    private Float allScore;
    private Float allCreditScore;
    private Float avgCredit;
    private Float avgCreditPoint;
    private Integer majorRank;
    private Integer status;
    private List<CourseGrade> courseGrades;

    public Student(String studentNum, String studentName, String className, String term, Integer courseNum, Integer flunkNum, Float avgScore, Float allScore, Float allCreditScore, Float avgCredit, Float avgCreditPoint, Integer majorRank, Integer status) {
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.className = className;
        this.term = term;
        this.courseNum = courseNum;
        this.flunkNum = flunkNum;
        this.avgScore = avgScore;
        this.allScore = allScore;
        this.allCreditScore = allCreditScore;
        this.avgCredit = avgCredit;
        this.avgCreditPoint = avgCreditPoint;
        this.majorRank = majorRank;
        this.status = status;
    }

    public Student() {
    }
}