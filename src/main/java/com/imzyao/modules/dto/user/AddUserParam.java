package com.imzyao.modules.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 新增角色参数
 */
@Getter
@Setter
@ToString
public class AddUserParam {

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("联系方式")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("用户性别（0男 1女 2未知）")
    private String sex;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;

}
