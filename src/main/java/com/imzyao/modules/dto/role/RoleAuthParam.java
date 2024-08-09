package com.imzyao.modules.dto.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色菜单授权
 */
@Getter
@Setter
@ToString
public class RoleAuthParam {

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("菜单id数组")
    private Long[] menuIds;

}
