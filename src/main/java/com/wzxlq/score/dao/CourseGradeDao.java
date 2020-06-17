package com.wzxlq.score.dao;

import com.wzxlq.score.entity.CourseGrade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (CourseGrade)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-27 22:00:38
 */
@Mapper
public interface CourseGradeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CourseGrade queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<CourseGrade> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据班级名称和学期查询不及格名单
     * @param className
     * @param term
     * @return
     */
    List<CourseGrade> queryFlunkByClassAndTerm(@Param("className") String className, @Param("term") String term);

    /**
     * 根据班级名称、学期、科目名称查询单科成绩
     * @param className
     * @param courseName
     * @return
     */
    List<CourseGrade> queryOneGradeByClassAndTermAndCourse(@Param("className") String className, @Param("courseName") String courseName);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param courseGrade 实例对象
     * @return 对象列表
     */
    List<CourseGrade> queryAll(CourseGrade courseGrade);

    /**
     * 新增数据
     *
     * @param courseGrade 实例对象
     * @return 影响行数
     */
    int insert(CourseGrade courseGrade);

    /**
     * 修改数据
     *
     * @param courseGrade 实例对象
     * @return 影响行数
     */
    int update(CourseGrade courseGrade);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void insertAllGrades(List<CourseGrade> courseGradeList);
}