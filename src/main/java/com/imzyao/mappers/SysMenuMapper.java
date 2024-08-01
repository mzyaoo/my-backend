package com.imzyao.mappers;

import com.imzyao.modules.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author imzyao
 * @since 2024-08-01
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getSystemMenuList();

}
