package com.wzxlq.score.utils;

import com.google.gson.Gson;
import com.wzxlq.score.entity.AccessToken;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 王照轩
 * @date 2020/2/29 - 10:51
 */
public class sentUtil {
    //TODO
    private static final String CORPID = "ww9b8c761b26841ee0";
    //TODO
    private static final String SECRET = "WD-VjEF02vy483e-jktGE4KFeDWJ0WJmSjKV0CnBOmA";

    private static final String GET_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET";

    private static AccessToken at=null;

    public static String post(String url, String data) {
        try {
            URL urlObj = new URL(url);
            URLConnection connection = urlObj.openConnection();
            // 要发送数据出去，必须要设置为可发送数据状态
            connection.setDoOutput(true);
            // 获取输出流
            OutputStream os = connection.getOutputStream();
            // 写出数据
            os.write(data.getBytes());
            os.close();
            // 获取输入流
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 向指定的地址发送get请求
     */
    public static String get(String url) {
        try {
            URL urlObj = new URL(url);
            // 开连接
            URLConnection connection = urlObj.openConnection();
            InputStream is = connection.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = is.read(b)) != -1) {
                sb.append(new String(b, 0, len));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void getToken() {
        String url = GET_TOKEN_URL.replace("ID", CORPID).replace("SECRET", SECRET);
        String tokenStr = sentUtil.get(url);
        Gson gson = new Gson();
        at = gson.fromJson(tokenStr, AccessToken.class);
        at.setExpires_in(System.currentTimeMillis()+at.getExpires_in()*1000);
    }

    /**
     * 向处暴露的获取token的方法
     *
     */
    public static String getAccessToken() {
        if (at == null || at.isExpired()) {
            getToken();
        }
        return at.getAccess_token();
    }
}
