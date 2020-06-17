package com.wzxlq.score.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Major)实体类
 *
 * @author makejava
 * @since 2020-02-28 12:23:47
 */
@Data
public class Major implements Serializable {
    private static final long serialVersionUID = -55225857684765726L;
    
    private Integer id;
    
    private String majorName;
    
    private String grade;
    
    private String courseName;
    
    private Integer status;

    public Major(String majorName, String grade, String courseName, Integer status) {
        this.majorName = majorName;
        this.grade = grade;
        this.courseName = courseName;
        this.status = status;
    }

    public Major() {
    }
}