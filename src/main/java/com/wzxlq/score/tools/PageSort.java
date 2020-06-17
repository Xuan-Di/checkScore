package com.wzxlq.score.tools;

import com.wzxlq.score.entity.CourseGrade;
import com.wzxlq.score.entity.Student;

import java.util.List;

public class PageSort {
    /**
     * 排序总体成绩页面
     * @param students 要排序的对象
     * @param sort 表示选择哪种排序方法 1:按学号升序 2:按总分降序 3:按平均学分绩点降序
     */
    public static void sortAllGradePage(List<Student> students, Integer sort) {
        if (sort == 1) {
            SortWays.sortStudentByStudentNum(students);
        } else if (sort == 2) {
            SortWays.sortStudentByGrade(students);
        } else {
            SortWays.sortStudentByCreditPoint(students);
        }
    }

    /**
     * 排序不及格页面
     * @param flunk 要排序的对象
     * @param sort 表示选择哪种排序方法 1:按学号升序 4:按课程名称
     */
    public static void sortFlunkPage(List<CourseGrade> flunk, Integer sort) {
        if (sort == 1) {
            SortWays.sortCourseGradeByStudentNum(flunk);
        } else {
            SortWays.sortCourseGradeByCourseName(flunk);
        }
    }

    /**
     * 排序单科成绩页面
     * @param courseGrade 要排序的对象
     * @param sort 表示选择哪种排序方法 1:按学号升序 2:按单科成绩降序
     */
    public static void sortOneGrade(List<CourseGrade> courseGrade, Integer sort) {
        if (sort == 1) {
            SortWays.sortCourseGradeByStudentNum(courseGrade);
        } else {
            SortWays.sortCourseGradeByGrade(courseGrade);
        }
    }
}
