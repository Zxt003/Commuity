package com.yx.dao;

import com.yx.pojo.RecordVo;
import com.yx.pojo.Records;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
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
@Component("recordsDao")
public interface RecordsMapper extends BaseMapper<Records> {

    /**
     * 查询所有记录信息
     */
    List<RecordVo> queryRecordsAll(RecordVo recordVo);

    //根据房子id和类型id获取最后一次记录信息
    Records queryByHouIdAndTypeId(@Param("houId") Integer houId, @Param("typeId") Integer typeId);
}
