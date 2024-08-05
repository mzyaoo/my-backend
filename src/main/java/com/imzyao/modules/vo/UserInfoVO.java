package com.imzyao.modules.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 用户信息实体
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoVO {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户操作权限
     */
    private List<String> permissions;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;


}
