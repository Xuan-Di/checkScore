package com.wzxlq.score.dao;

import com.wzxlq.score.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Teacher)表数据库访问层
 *
 * @author makejava
 * @since 2020-02-27 22:01:16
 */
@Mapper
public interface TeacherDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Teacher queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Teacher> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据workNum查询该老师所有的班级信息
     * @param workNum 工号
     * @return
     */
    List<Teacher> queryAllByWorkNum(@Param("workNum") String workNum);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param teacher 实例对象
     * @return 对象列表
     */
    List<Teacher> queryAll(Teacher teacher);

    /**
     * 新增数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int insert(Teacher teacher);

    /**
     * 修改数据
     *
     * @param teacher 实例对象
     * @return 影响行数
     */
    int update(Teacher teacher);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    void insertAllTeachers(List<Teacher> teacherList);
}