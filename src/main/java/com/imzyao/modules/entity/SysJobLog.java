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
 * 定时任务调度日志表
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@TableName("sys_job_log")
@ApiModel(value = "SysJobLog对象", description = "定时任务调度日志表")
public class SysJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务日志ID")
    @TableId(value = "job_log_id", type = IdType.AUTO)
    private Long jobLogId;

    @ApiModelProperty("任务名称")
    private String jobName;

    @ApiModelProperty("任务组名")
    private String jobGroup;

    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty("日志信息")
    private String jobMessage;

    @ApiModelProperty("执行状态（0正常 1失败）")
    private String status;

    @ApiModelProperty("异常信息")
    private String exceptionInfo;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    public Long getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(Long jobLogId) {
        this.jobLogId = jobLogId;
    }
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
    public String getInvokeTarget() {
        return invokeTarget;
    }

    public void setInvokeTarget(String invokeTarget) {
        this.invokeTarget = invokeTarget;
    }
    public String getJobMessage() {
        return jobMessage;
    }

    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getExceptionInfo() {
        return exceptionInfo;
    }

    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SysJobLog{" +
            "jobLogId=" + jobLogId +
            ", jobName=" + jobName +
            ", jobGroup=" + jobGroup +
            ", invokeTarget=" + invokeTarget +
            ", jobMessage=" + jobMessage +
            ", status=" + status +
            ", exceptionInfo=" + exceptionInfo +
            ", createTime=" + createTime +
        "}";
    }
}
