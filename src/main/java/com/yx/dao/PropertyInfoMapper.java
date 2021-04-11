package com.yx.dao;

import com.yx.pojo.PropertyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("propertyInfoDao")
public interface PropertyInfoMapper extends BaseMapper<PropertyInfo> {
    /**
     * 根据登记时间和房子id获取当前记录信息
     */
    void deleteByHouIdAndTime(@Param("houId") Integer houId, @Param("endDate") String onTime);

}
