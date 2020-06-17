package com.wzxlq.score.dao;

import com.wzxlq.score.entity.Major;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * (Major)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-27 22:00:50
 */
@Mapper
public interface MajorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Major queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Major> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据专业名称和年级查询所有的科目名称
     * @param majorName
     * @param grade
     * @return
     */
    List<Major> queryAllByMajorAndGrade(@Param("majorName") String majorName, @Param("grade") String grade);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param major 实例对象
     * @return 对象列表
     */
    List<Major> queryAll(Major major);

    /**
     * 新增数据
     *
     * @param major 实例对象
     * @return 影响行数
     */
    int insert(Major major);

    /**
     * 修改数据
     *
     * @param major 实例对象
     * @return 影响行数
     */
    int update(Major major);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void insertMajor(ArrayList<Major> majorList);

    Integer queryIsExist(String majorName, String term);
}