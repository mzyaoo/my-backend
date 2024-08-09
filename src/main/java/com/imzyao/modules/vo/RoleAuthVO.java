package com.imzyao.modules.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoleAuthVO {

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("全选节点数组")
    private Long[] checkedKeys;

    @ApiModelProperty("半选节点数组")
    private Long[] halfSelected;

}
