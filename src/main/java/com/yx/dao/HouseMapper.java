package com.yx.dao;

import com.yx.pojo.House;
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
@Component("houseDao")
public interface HouseMapper extends BaseMapper<House> {

    /**
     * 查询所有房屋信息
     * @return
     */
    List<House> queryHouseAll(@Param("numbers")String numbers);
}
