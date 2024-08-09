package com.imzyao.modules.dto.role;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 新增角色参数
 */
@Getter
@Setter
@ToString
public class AddRoleParam {

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 排序
     */
    @ApiModelProperty("排序字段")
    private Integer sort;

    /**
     * 状态
     */
    @ApiModelProperty("角色状态（0正常 1停用）")
    private Integer status;

    /**
     * 菜单id数组
     */
    @ApiModelProperty("菜单id数组")
    private List<Long> menuIds;

}
