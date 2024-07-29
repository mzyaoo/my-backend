package com.imzyao.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@TableName("sys_oper_log")
@ApiModel(value = "SysOperLog对象", description = "操作日志记录")
public class SysOperLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志主键")
    @TableId(value = "oper_id", type = IdType.AUTO)
    private Long operId;

    @ApiModelProperty("模块标题")
    private String title;

    @ApiModelProperty("业务类型（0其它 1新增 2修改 3删除）")
    private Integer businessType;

    @ApiModelProperty("方法名称")
    private String method;

    @ApiModelProperty("请求方式")
    private String requestMethod;

    @ApiModelProperty("操作类别（0其它 1后台用户 2手机端用户）")
    private Integer operatorType;

    @ApiModelProperty("操作人员")
    private String operName;

    @ApiModelProperty("部门名称")
    private String deptName;

    @ApiModelProperty("请求URL")
    private String operUrl;

    @ApiModelProperty("主机地址")
    private String operIp;

    @ApiModelProperty("操作地点")
    private String operLocation;

    @ApiModelProperty("请求参数")
    private String operParam;

    @ApiModelProperty("返回参数")
    private String jsonResult;

    @ApiModelProperty("操作状态（0正常 1异常）")
    private Integer status;

    @ApiModelProperty("错误消息")
    private String errorMsg;

    @ApiModelProperty("操作时间")
    private LocalDateTime operTime;

    @ApiModelProperty("消耗时间")
    private Long costTime;

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }
    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }
    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }
    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }
    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }
    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }
    public String getJsonResult() {
        return jsonResult;
    }

    public void setJsonResult(String jsonResult) {
        this.jsonResult = jsonResult;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public LocalDateTime getOperTime() {
        return operTime;
    }

    public void setOperTime(LocalDateTime operTime) {
        this.operTime = operTime;
    }
    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    @Override
    public String toString() {
        return "SysOperLog{" +
            "operId=" + operId +
            ", title=" + title +
            ", businessType=" + businessType +
            ", method=" + method +
            ", requestMethod=" + requestMethod +
            ", operatorType=" + operatorType +
            ", operName=" + operName +
            ", deptName=" + deptName +
            ", operUrl=" + operUrl +
            ", operIp=" + operIp +
            ", operLocation=" + operLocation +
            ", operParam=" + operParam +
            ", jsonResult=" + jsonResult +
            ", status=" + status +
            ", errorMsg=" + errorMsg +
            ", operTime=" + operTime +
            ", costTime=" + costTime +
        "}";
    }
}
