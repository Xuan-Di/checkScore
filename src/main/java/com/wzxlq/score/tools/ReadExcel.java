package com.wzxlq.score.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.wzxlq.score.entity.Excel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;



/**

 */

public class ReadExcel {

    private static String xls2003 = "F:\\mycourse.xls";
    /**
     * 读取Excel2003的主表数据 （单个sheet）
     *
     * @param filePath
     * @return
     */
    public static List<Excel> readFromXLS2003(String filePath,String className,String term) {
        File excelFile = null;// Excel文件对象
        InputStream is = null;// 输入流对象
        String cellStr = null;// 单元格，最终按字符串处理
        List<Excel> employeeList = new ArrayList<>();// 返回封装数据的List
        Excel employee = null;// 每一个雇员信息对象
        try {
            excelFile = new File(filePath);
            is = new FileInputStream(excelFile);// 获取文件输入流
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);// 创建Excel2003文件对象
            HSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0
            // 开始循环遍历行，表头不处理，从1开始
            for (int i = 3; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);// 获取行对象
                employee = new Excel();// 实例化Student对象
                if (row == null) {// 如果为空，不处理
                    continue;
                }
                employee.setStudentNum(row.getCell(0).getStringCellValue());
                employee.setStudentName(row.getCell(1).getStringCellValue());
                employee.setCourseNum(Integer.parseInt(row.getCell(2).getStringCellValue()));
                employee.setClassName(className);
                employee.setTerm(term);
                employee.setScores(new ArrayList<>());
                for (int j = 3; j < employee.getCourseNum() + 3; j++) {
                        employee.getScores().add(row.getCell(j).getStringCellValue());
                }
                int j = employee.getCourseNum() + 3;
                employee.setFlunkNum(Integer.parseInt(row.getCell(j).getStringCellValue()));
                employee.setAvgScore(Float.valueOf(row.getCell(j + 1).getStringCellValue()));
                employee.setAllScore(Float.valueOf(row.getCell(j + 2).getStringCellValue()));
                employee.setAllCreditScore(Float.valueOf(row.getCell(j + 3).getStringCellValue()));
                employee.setAvgCredit(Float.valueOf(row.getCell(j + 4).getStringCellValue()));
                employee.setAvgCreditPoint(Float.valueOf(row.getCell(j + 5).getStringCellValue()));
                employee.setMajorRank(Integer.parseInt(row.getCell(j + 6).getStringCellValue()));
                employeeList.add(employee);// 数据装入List
            }
            int n = employeeList.get(0).getCourseNum();
            employee = new Excel();
            employee.setCourseName(new ArrayList<>());
            for (int i = 3; i < 3 + n; i++) {
                employee.getCourseName().add(sheet.getRow(2).getCell(i).getStringCellValue());
            }
            employeeList.add(employee);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// 关闭文件流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employeeList;
    }

    public static void main(String[] args) {
        System.out.println("************读取Excel2003的主表数据（将Excel单元格设为文本格式）******************");
        List<Excel> list2003 = readFromXLS2003(xls2003,"2017软件工程一班","201909");
        for (Excel employee : list2003) {
            System.out.println(employee);
        }

    }

//    https://open.weixin.qq.com/connect/oauth2/authorize?appid=ww0b671be552210405&redirect_uri=http://score.xiaomy.net/getUserInfo&response_type=code&scope=snsapi_privateinfo&agentid=1000009#wechat_redirect

 }

