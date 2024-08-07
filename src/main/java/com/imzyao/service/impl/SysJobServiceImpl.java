package com.imzyao.service.impl;

import com.imzyao.modules.entity.SysJob;
import com.imzyao.mappers.SysJobMapper;
import com.imzyao.modules.entity.SysUser;
import com.imzyao.service.ISysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-08-06
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

    @Override
    public List<SysJob> queryTableList() {
        return Collections.emptyList();
    }

    @Override
    public void add(SysUser sysUser) {

    }

    @Override
    public void editById(SysUser sysUser) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
