package com.imzyao.modules.entity;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
@Data
@TableName("sys_menu")
@ApiModel(value = "SysMenu对象", description = "")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("组件路径")
    private String component;

    @ApiModelProperty("组件地址")
    private String path;

    @ApiModelProperty("排序字段")
    private Integer orderNum;

    @ApiModelProperty("父菜单ID")
    private Integer parentId;

    @ApiModelProperty("参数（JSON）")
    private String query;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("菜单状态（0显示 1隐藏）")
    private String visible;

    @ApiModelProperty("菜单状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("菜单类型（M目录 C菜单 F按钮）")
    private String menuType;

    @TableField(exist = false)
    @ApiModelProperty("子菜单集合")
    private List<SysMenu> children;

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", name=" + name +
                ", component=" + component +
                ", path=" + path +
                ", orderNum=" + orderNum +
                ", parentId=" + parentId +
                ", query=" + query +
                ", icon=" + icon +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", visible=" + visible +
                ", status=" + status +
                ", perms=" + perms +
                ", menuType=" + menuType +
                ", children=" + JSON.toJSONString(children) +
                "}";
    }
}
