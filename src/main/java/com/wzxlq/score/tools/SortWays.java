package com.wzxlq.score.tools;

import com.wzxlq.score.entity.CourseGrade;
import com.wzxlq.score.entity.Student;
import java.util.List;

public class SortWays {


    /**
     * 排序总体成绩,按总分降序排序
     * @param students
     */
    public static void sortStudentByGrade(List<Student> students) {
        students.sort(((o1, o2) -> o2.getAllScore().compareTo(o1.getAllScore())));
    }

    /**
     * 排序总体成绩,按平均学分绩点降序排序
     * @param students
     */
    public static void sortStudentByCreditPoint(List<Student> students) {
        students.sort(((o1, o2) -> o1.getMajorRank().compareTo(o2.getMajorRank())));
    }

    /**
     * 排序总体成绩,按学号升序排序
     * @param student 要排序的对象
     */
    public static void sortStudentByStudentNum(List<Student> student) {
        student.sort(((o1, o2) -> o1.getStudentNum().compareTo(o2.getStudentNum())));
    }

    /**
     * 排序单科成绩和不及格成绩,按学号升序排序
     * @param courseGrades 要排序的对象
     */
    public static void sortCourseGradeByStudentNum(List<CourseGrade> courseGrades) {
        courseGrades.sort(((o1, o2) -> o1.getStudentNum().compareTo(o2.getStudentNum())));
    }

    /**
     * 排序单科成绩,按成绩降序排序
     * @param courseGrades
     */
    public static void sortCourseGradeByGrade(List<CourseGrade> courseGrades) {

        courseGrades.sort(((o1, o2) -> o2.getScore() - o1.getScore()));
    }

    /**
     * 排序不及格名单,按课程名称排名
     * @param courseGrades
     */
    public static void sortCourseGradeByCourseName(List<CourseGrade> courseGrades) {
        courseGrades.sort(((o1, o2) -> o2.getCourseName().compareTo(o1.getCourseName())));
    }
}
