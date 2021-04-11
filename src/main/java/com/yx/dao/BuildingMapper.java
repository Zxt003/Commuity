package com.yx.dao;

import com.yx.pojo.Building;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("buildingDao")
public interface BuildingMapper extends BaseMapper<Building> {

    /**
     * 查询所有记录信息
     * @param numbers
     * @return
     */
    List<Building> queryBuildAll(@Param("numbers")String numbers);

}
