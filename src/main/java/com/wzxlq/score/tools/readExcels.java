package com.wzxlq.score.tools;

import com.wzxlq.score.entity.TeacherExcel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author 王照轩
 * @date 2020/3/6 - 10:55
 */
public class readExcels implements Callable<List<TeacherExcel>> {
    private String filePath = "F:\\" + "teacherExcels\\";
    private static int depth = 1;
    final static HashMap<Character, String> map = new HashMap<>();

    public readExcels(String filePath) {
        this.filePath += filePath;
    }

    static {
        map.put('1', "一");
        map.put('2', "二");
        map.put('3', "三");
        map.put('4', "四");
        map.put('5', "五");
        map.put('6', "六");
        map.put('7', "七");
        map.put('8', "八");
    }

    /**
     * 读取Excel2003的主表数据 （单个sheet）
     *
     * @return
     */
    @Override
    public List<TeacherExcel> call() {
        File excelFile = null;// Excel文件对象
        InputStream is = null;// 输入流对象
        StringBuffer sb;
        List<TeacherExcel> teacherList = new ArrayList<>();// 返回封装数据的List
        TeacherExcel teacher = null;// 每一个雇员信息对象
        try {
            excelFile = new File(filePath);
            is = new FileInputStream(excelFile);// 获取文件输入流
            HSSFWorkbook workbook2003 = new HSSFWorkbook(is);// 创建Excel2003文件对象
            HSSFSheet sheet = workbook2003.getSheetAt(0);// 取出第一个工作表，索引是0
            // 开始循环遍历行，表头不处理，从1开始
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);// 获取行对象
                teacher = new TeacherExcel();// 实例化Student对象
                if (row == null) {// 如果为空，不处理
                    continue;
                }
                row.getCell(1).setCellType(CellType.STRING);
                teacher.setWorkNum(row.getCell(1).getStringCellValue());
                String className = row.getCell(2).getStringCellValue();
                sb = new StringBuffer(className);
                if (map.containsKey(className.charAt(className.length() - 2))) {
                    sb.replace(className.length() - 2, className.length() - 1, map.get(className.charAt(className.length() - 2)));
                }
                teacher.setClassName(sb.toString());
                teacherList.add(teacher);// 数据装入List
            }
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
        return teacherList;
    }

    public static void main(String[] args) throws Exception  {
        //读取F:\teacherExcels文件夹下所有老师excel文件。
        String[] fileArray = find("F:\\teacherExcels", depth);
        //创建线程池。
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        //获得excel文件名列表
        List<String> list = Arrays.asList(fileArray);
        //封装到Callable
        List<Callable<List<TeacherExcel>>> collect = list.stream().map(s -> {
            return (Callable<List<TeacherExcel>>) () -> {
                return  new readExcels(s).call();
            };
        }).collect(Collectors.toList());
        //执行，得到List<List<TeacherExcel>>,注意发到服务器需要遍历发送。每次发送List<TeacherExcel>.
        List<List<TeacherExcel>> teacherExcels = executorService.invokeAll(collect).stream().map(future -> {
            try {
                List<TeacherExcel> teacherExcel = future.get();
                return teacherExcel;
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }).collect(Collectors.toList());
        for (List<TeacherExcel> tl: teacherExcels) {
            //这里应该发送到服务器。
            System.out.println(tl);
        }
        executorService.shutdown();
    }

    public static String[] find(String pathName, int depth) throws IOException {
        int filecount = 0;
        //获取pathName的File对象
        File dirFile = new File(pathName);
        //判断该文件或目录是否存在，不存在时在控制台输出提醒
        if (!dirFile.exists()) {
            System.out.println("do not exit");
            return null;
        }
        //判断如果不是一个目录，就判断是不是一个文件，时文件则输出文件路径
        if (!dirFile.isDirectory()) {
            if (dirFile.isFile()) {
                System.out.println(dirFile.getCanonicalFile());
            }
            return null;
        }

        for (int j = 0; j < depth; j++) {
            System.out.print("  ");
        }
        System.out.print("|--");
        System.out.println(dirFile.getName());
        //获取此目录下的所有文件名与目录名
        String[] fileList = dirFile.list();
        int currentDepth = depth + 1;
        for (int i = 0; i < fileList.length; i++) {
            //遍历文件目录
            String string = fileList[i];
            //File("documentName","fileName")是File的另一个构造器
            File file = new File(dirFile.getPath(), string);
            String name = file.getName();
            //如果是一个目录，搜索深度depth++，输出目录名后，进行递归
            if (file.isDirectory()) {
                //递归
                find(file.getCanonicalPath(), currentDepth);
            } else {
                //如果是文件，则直接输出文件名
                for (int j = 0; j < currentDepth; j++) {
                    System.out.print("   ");
                }
                System.out.print("|--");
                System.out.println(name);

            }
        }
        return fileList;
    }
}
