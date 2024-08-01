package com.imzyao.mappers;

import com.imzyao.modules.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUser selectByUserName(String userName);

}
