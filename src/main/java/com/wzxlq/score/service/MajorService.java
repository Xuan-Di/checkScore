package com.wzxlq.score.service;

import com.wzxlq.score.entity.Major;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * (Major)表服务接口
 *
 * @author makejava
 * @since 2020-02-27 22:00:50
 */
public interface MajorService {

    /**
     * 根据专业名称和年级查询所有的科目名称
     * @param majorName
     * @param grade
     * @return
     */
    List<Major> queryAllByMajorAndGrade(String majorName, String grade);

    void insertMajor(ArrayList<Major> majorList);

    Integer queryIsExist(String majorName,String term);
}