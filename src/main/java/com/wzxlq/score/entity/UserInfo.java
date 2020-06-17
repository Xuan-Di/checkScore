package com.wzxlq.score.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 王照轩
 * @date 2020/2/29 - 10:57
 */
@Data
@Accessors
public class UserInfo {

    /**
     * UserId : USERID
     * DeviceId : DEVICEID
     * user_ticket : USER_TICKET
     * expires_in : 7200
     */

    private String UserId;
    private String DeviceId;
    private String user_ticket;
    private int expires_in;


}
