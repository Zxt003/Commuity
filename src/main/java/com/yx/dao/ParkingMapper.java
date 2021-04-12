package com.yx.dao;

import com.yx.pojo.Parking;
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
@Component("parkingDao")
public interface ParkingMapper extends BaseMapper<Parking> {

    //分页查询车位信息
    List<Parking> queryParkAll(@Param("numbers")String numbers);

    //查询已经使用的车位信息
    List<Parking> queryParkAllByStatus();
}
