package com.imzyao.modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 登录参数
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    private String username;

    private String password;

}
