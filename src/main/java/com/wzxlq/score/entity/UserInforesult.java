package com.wzxlq.score.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 王照轩
 * @date 2020/2/29 - 12:47
 */
@Data
@Accessors
public class UserInforesult {

    /**
     * userid : lisi
     * name : 李四
     * department : [3]
     * position : 后台工程师
     * mobile : 15050495892
     * gender : 1
     * email : xxx@xx.com
     * avatar : http://shp.qpic.cn/bizmp/xxxxxxxxxxx/0
     */

    private String userid;
    private String name;
    private String position;
    private String mobile;
    private int gender;
    private String email;
    private String avatar;
    private List<Integer> department;


}
