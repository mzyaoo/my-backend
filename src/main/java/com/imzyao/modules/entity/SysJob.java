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
 * 定时任务调度表
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@TableName("sys_job")
@ApiModel(value = "SysJob对象", description = "定时任务调度表")
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务ID")
    @TableId(value = "job_id", type = IdType.AUTO)
    private Long jobId;

    @ApiModelProperty("任务名称")
    private String jobName;

    @ApiModelProperty("任务组名")
    private String jobGroup;

    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty("cron执行表达式")
    private String cronExpression;

    @ApiModelProperty("计划执行错误策略（1立即执行 2执行一次 3放弃执行）")
    private String misfirePolicy;

    @ApiModelProperty("是否并发执行（0允许 1禁止）")
    private String concurrent;

    @ApiModelProperty("状态（0正常 1暂停）")
    private String status;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("备注信息")
    private String remark;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
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
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy;
    }
    public String getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(String concurrent) {
        this.concurrent = concurrent;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SysJob{" +
            "jobId=" + jobId +
            ", jobName=" + jobName +
            ", jobGroup=" + jobGroup +
            ", invokeTarget=" + invokeTarget +
            ", cronExpression=" + cronExpression +
            ", misfirePolicy=" + misfirePolicy +
            ", concurrent=" + concurrent +
            ", status=" + status +
            ", createBy=" + createBy +
            ", createTime=" + createTime +
            ", updateBy=" + updateBy +
            ", updateTime=" + updateTime +
            ", remark=" + remark +
        "}";
    }
}
