package com.imzyao.modules.dto.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 角色信息修改
 */
@Getter
@Setter
@ToString
public class EditRoleParam extends AddRoleParam {

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    private Integer id;

}
