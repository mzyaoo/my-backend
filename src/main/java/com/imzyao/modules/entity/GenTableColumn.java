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
 * 代码生成业务表字段
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@TableName("gen_table_column")
@ApiModel(value = "GenTableColumn对象", description = "代码生成业务表字段")
public class GenTableColumn implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "column_id", type = IdType.AUTO)
    private Long columnId;

    @ApiModelProperty("归属表编号")
    private Long tableId;

    @ApiModelProperty("列名称")
    private String columnName;

    @ApiModelProperty("列描述")
    private String columnComment;

    @ApiModelProperty("列类型")
    private String columnType;

    @ApiModelProperty("JAVA类型")
    private String javaType;

    @ApiModelProperty("JAVA字段名")
    private String javaField;

    @ApiModelProperty("是否主键（1是）")
    private String isPk;

    @ApiModelProperty("是否自增（1是）")
    private String isIncrement;

    @ApiModelProperty("是否必填（1是）")
    private String isRequired;

    @ApiModelProperty("是否为插入字段（1是）")
    private String isInsert;

    @ApiModelProperty("是否编辑字段（1是）")
    private String isEdit;

    @ApiModelProperty("是否列表字段（1是）")
    private String isList;

    @ApiModelProperty("是否查询字段（1是）")
    private String isQuery;

    @ApiModelProperty("查询方式（等于、不等于、大于、小于、范围）")
    private String queryType;

    @ApiModelProperty("显示类型（文本框、文本域、下拉框、复选框、单选框、日期控件）")
    private String htmlType;

    @ApiModelProperty("字典类型")
    private String dictType;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    public Long getColumnId() {
        return columnId;
    }

    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }
    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }
    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }
    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }
    public String getIsPk() {
        return isPk;
    }

    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }
    public String getIsIncrement() {
        return isIncrement;
    }

    public void setIsIncrement(String isIncrement) {
        this.isIncrement = isIncrement;
    }
    public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired;
    }
    public String getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }
    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }
    public String getIsList() {
        return isList;
    }

    public void setIsList(String isList) {
        this.isList = isList;
    }
    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }
    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }
    public String getHtmlType() {
        return htmlType;
    }

    public void setHtmlType(String htmlType) {
        this.htmlType = htmlType;
    }
    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    @Override
    public String toString() {
        return "GenTableColumn{" +
            "columnId=" + columnId +
            ", tableId=" + tableId +
            ", columnName=" + columnName +
            ", columnComment=" + columnComment +
            ", columnType=" + columnType +
            ", javaType=" + javaType +
            ", javaField=" + javaField +
            ", isPk=" + isPk +
            ", isIncrement=" + isIncrement +
            ", isRequired=" + isRequired +
            ", isInsert=" + isInsert +
            ", isEdit=" + isEdit +
            ", isList=" + isList +
            ", isQuery=" + isQuery +
            ", queryType=" + queryType +
            ", htmlType=" + htmlType +
            ", dictType=" + dictType +
            ", sort=" + sort +
            ", createBy=" + createBy +
            ", createTime=" + createTime +
            ", updateBy=" + updateBy +
            ", updateTime=" + updateTime +
        "}";
    }
}
