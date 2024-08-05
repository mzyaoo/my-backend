package com.imzyao.modules.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("sys_user")
@ApiModel(value = "SysUser对象", description = "")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String passWord;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("头像")
    private String avatar;

    @ApiModelProperty("联系方式")
    private String telephone;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String sex;

    @ApiModelProperty("帐号状态（0正常 1停用）")
    private String status;

    @ApiModelProperty("删除标志（0代表存在 2代表删除）")
    private String delFlag;

    @ApiModelProperty("最后登录IP")
    private String loginIp;

    @ApiModelProperty("最后登录时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime loginDate;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime createTime;

    @ApiModelProperty("修改者")
    private String updateBy;

    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private LocalDateTime updateTime;


    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", userName=" + userName +
                ", passWord=" + passWord +
                ", nickName=" + nickName +
                ", avatar=" + avatar +
                ", telephone=" + telephone +
                ", email=" + email +
                ", sex=" + sex +
                ", status=" + status +
                ", delFlag=" + delFlag +
                ", loginIp=" + loginIp +
                ", loginDate=" + loginDate +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                "}";
    }
}
