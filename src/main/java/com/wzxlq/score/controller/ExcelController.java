package com.wzxlq.score.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wzxlq.score.entity.*;
import com.wzxlq.score.service.CourseGradeService;
import com.wzxlq.score.service.MajorService;
import com.wzxlq.score.service.StudentService;
import com.wzxlq.score.service.TeacherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

//import static com.wzxlq.score.tools.readExcels.readFromXLS2003;

/**
 *
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @Resource
    StudentService studentService;
    @Resource
    CourseGradeService courseGradeService;
    @Resource
    TeacherService teacherService;
    @Resource
    MajorService majorService;

    final static HashMap<String, Integer> map = new HashMap<>();

    static {
        map.put("优", 5);
        map.put("良", 4);
        map.put("中", 3);
        map.put("及格", 2);
        map.put("不及格", 1);
        map.put("NULL", 0);
        map.put("优*", 5);
        map.put("良*", 4);
        map.put("中*", 3);
        map.put("及格*", 2);
        map.put("不及格*", 1);
    }

    /**
     * 获取到传过来的excel数据
     */
    @PostMapping("insertExcel")
    public Integer insertExcel(String excels) {
        Gson gson = new Gson();
        List<Excel> excelList = gson.fromJson(excels, new TypeToken<List<Excel>>() {
        }.getType());
        ArrayList<String> courseNameList = excelList.get(0).getCourseName();
        excelList.remove(0);
        List<Student> studentList = excelList.stream().map(excel -> new Student(excel.getStudentNum(), excel.getStudentName(),
                excel.getClassName(), excel.getTerm(), excel.getCourseNum(), excel.getFlunkNum(), excel.getAvgScore(),
                excel.getAllScore(), excel.getAllCreditScore(), excel.getAvgCredit(), excel.getAvgCreditPoint(), excel.getMajorRank(),
                1)).collect(Collectors.toList());
        studentService.insertAllStudent(studentList);
        //获取班级名称
        String className = studentList.get(0).getClassName();
        //截取专业名称
        String majorName = className.substring(0, className.length() - 2);
        //获取学期
        String term = studentList.get(0).getTerm();
        //判断是否数据库已有数据,0代表没有数据,否则有数据就不插入.
        Integer isExist = majorService.queryIsExist(majorName, term);
        if (isExist == 0) {
            ArrayList<Major> majorList = new ArrayList<>();
            for (String courseName : courseNameList) {
                majorList.add(new Major(majorName, term, courseName, 1));
            }
            //插入专业表
            majorService.insertMajor(majorList);
        }
        List<CourseGrade> courseGradeList = new ArrayList<>();
        int score;
        for (int j = 0; j < excelList.size(); j++) {
            ArrayList<String> temp = excelList.get(j).getScores();
            for (int i = 0; i < temp.size(); i++) {
                if (map.containsKey(temp.get(i))) {
                    score = map.get(temp.get(i));
                } else {
                    score = Integer.parseInt(temp.get(i).replace("*", ""));
                }
                courseGradeList.add(new CourseGrade(studentList.get(j).getStudentNum(), studentList.get(j).getStudentName(),
                        studentList.get(j).getTerm(), courseNameList.get(i), temp.get(i), score));
            }
        }
        courseGradeService.insertAllGrades(courseGradeList);
        return 1;
    }

    /**
     * 老师的excel插入
     */
    @PostMapping("insertTeacherExcel")
    public int insertTeacherExcel(String excels) {
        Gson gson = new Gson();
        List<TeacherExcel> teacherExcelList = gson.fromJson(excels, new TypeToken<List<TeacherExcel>>() {
        }.getType());
        List<Teacher> teacherList = teacherExcelList.stream().map(excel -> new Teacher(excel.getWorkNum(), 1, excel.getClassName(), 1))
                .collect(Collectors.toList());
        System.out.println(teacherList);
        teacherService.insertAllTeachers(teacherList);
        return 1;
    }
}
