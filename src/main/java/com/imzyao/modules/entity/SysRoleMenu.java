package com.imzyao.modules.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author imzyao
 * @since 2024-08-06
 */
@Setter
@Getter
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "角色和菜单关联表")
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    private Long roleId;

    @ApiModelProperty("菜单ID")
    private Long menuId;

    @Override
    public String toString() {
        return "SysRoleMenu{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                "}";
    }
}
