package com.imzyao.modules.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

/**
 * 路由配置信息
 *
 * @author ruoyi
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RouterVO {

    /**
     * 菜单路径
     */
    private String path;

    /**
     * 菜单组件地址
     */
    private String component;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;
    /**
     *
     */
    private MetaVO meta;

    /**
     * 子路由
     */
    private List<RouterVO> children;


}
