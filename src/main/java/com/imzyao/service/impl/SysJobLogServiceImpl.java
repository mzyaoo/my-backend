package com.imzyao.service.impl;

import com.imzyao.modules.entity.SysJobLog;
import com.imzyao.mappers.SysJobLogMapper;
import com.imzyao.service.ISysJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author imzyao
 * @since 2024-07-29
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements ISysJobLogService {

}
