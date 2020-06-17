package com.wzxlq.score.entity;

import lombok.Data;

@Data
public class AccessToken {
    private int errcode;
    private String errmag;
    private String access_token;
    private long expires_in;


    /**
     * 判断token是否过期
     *
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expires_in;
    }

}
