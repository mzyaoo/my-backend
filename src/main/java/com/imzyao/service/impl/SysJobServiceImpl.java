package com.imzyao.service.impl;

import com.imzyao.modules.entity.SysJob;
import com.imzyao.mappers.SysJobMapper;
import com.imzyao.service.ISysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements ISysJobService {

}
