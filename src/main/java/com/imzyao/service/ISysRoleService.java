package com.imzyao.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imzyao.modules.dto.role.AddRoleParam;
import com.imzyao.modules.dto.role.EditRoleParam;
import com.imzyao.modules.dto.role.RoleAuthParam;
import com.imzyao.modules.dto.role.SearchRoleTableParam;
import com.imzyao.modules.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.modules.vo.RoleAuthVO;

import java.security.Principal;

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
     * @param param
     */
    void add(AddRoleParam param, Principal principal);


    /**
     * 根据id修改数据
     *
     * @param param
     */
    void editById(EditRoleParam param, Principal principal);

    /**
     * 根据id删除数据
     *
     * @param id
     */
    void deleteById(Integer id, Principal principal);


    /**
     * 角色授权
     *
     * @param param
     * @param principal
     */
    void auth(RoleAuthParam param, Principal principal);

    /**
     * 获取角色菜单权限
     *
     * @param roleId
     * @return
     */
    RoleAuthVO getRoleAuth(Integer roleId);
}
