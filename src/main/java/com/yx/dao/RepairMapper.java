package com.yx.dao;

import com.yx.pojo.Count;
import com.yx.pojo.Repair;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("RepairDao")
public interface RepairMapper extends BaseMapper<Repair> {

    List<Repair> queryRepairAll(Repair repair);

    //统计处理
    List<Count> queryCount();
}
