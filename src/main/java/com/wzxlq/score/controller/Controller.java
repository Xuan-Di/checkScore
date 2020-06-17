package com.wzxlq.score.controller;


import com.google.gson.Gson;
import com.wzxlq.score.entity.Teacher;
import com.wzxlq.score.entity.UserInfo;
import com.wzxlq.score.service.TeacherService;
import com.wzxlq.score.utils.sentUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王照轩
 * @date 2020/2/27 - 16:04
 */
@RestController
public class Controller {

    @Resource
    private TeacherService teacherService;

    /**
     * 根据workNum查询是否有该工号的信息
     *
     * @return
     */
    @GetMapping("getUserInfo")
    public List<Teacher> getUserInfo(HttpServletRequest request, HttpServletResponse response) {
        //获取code
        String code = request.getParameter("code");
        System.out.println(code);
        if (code == null) {
            return null;
        }
        System.out.println(code);
        String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
        String at = sentUtil.getAccessToken();
        url = url.replace("ACCESS_TOKEN", at).replace("CODE", code);
        String result = sentUtil.get(url);
        Gson gson = new Gson();
        UserInfo userInfo = gson.fromJson(result, UserInfo.class);
        //学号或者工号
        String userId = userInfo.getUserId();

        System.out.println(userId);
        List<Teacher> teachers  = new ArrayList<>();
        //学生无权限
        if (userId.length() == 10) {
            return teachers;
        }
        teachers = teacherService.queryAllByWorkNum(userId);
        return teachers;
    }
}
