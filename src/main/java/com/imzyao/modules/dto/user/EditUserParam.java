package com.imzyao.modules.dto.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 修改角色参数
 */
@Getter
@Setter
@ToString
public class EditUserParam extends AddUserParam {

    @ApiModelProperty("用户id")
    private Integer id;

}
