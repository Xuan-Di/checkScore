package com.wzxlq.score.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Teacher)实体类
 *
 * @author makejava
 * @since 2020-02-28 12:24:57
 */
@Data
@ToString
@Accessors
public class Teacher implements Serializable {
    private static final long serialVersionUID = 211993234195027741L;
    
    private Integer id;
    
    private String workNum;
    
    private Integer roleType;
    
    private String className;
    
    private Integer status;


    public Teacher(String workNum, Integer roleType, String className, Integer status) {
        this.workNum = workNum;
        this.roleType = roleType;
        this.className = className;
        this.status = status;
    }

    public Teacher() {
    }
}