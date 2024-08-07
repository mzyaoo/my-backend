package com.imzyao.service;

import com.imzyao.modules.entity.SysJob;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.entity.SysUser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-06
 */
public interface ISysJobService extends IService<SysJob> {

    /**
     * 查询表格数据
     *
     * @return
     */
    List<SysJob> queryTableList();


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
