package com.yx.dao;

import com.yx.pojo.Carcharge;
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
@Component("carchargeDao")
public interface CarchargeMapper extends BaseMapper<Carcharge> {

    List<Carcharge> queryCarchargeAll(Carcharge carcharge);
}
