package com.imzyao.mappers;

import com.imzyao.modules.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imzyao.modules.pojo.SysUserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUserInfo getUserInfoByName(@Param("username") String username);

}
