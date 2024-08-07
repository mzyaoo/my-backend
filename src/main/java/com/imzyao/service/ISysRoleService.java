package com.imzyao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 系统角色表 服务类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-06
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * 查询表格数据
     *
     * @return
     */
    IPage<SysRole> queryTableList(SearchRoleTableParam param);


    /**
     * 新增数据
     *
     * @param sysUser
     */
    void add(SysUser sysUser);


    /**
     * 根据id修改数据
     *
     * @param sysUser
     */
    void editById(SysUser sysUser);

    /**
     * 根据id删除数据
     *
     * @param id
     */
    void deleteById(Integer id);


}
