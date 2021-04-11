package com.yx.dao;

import com.yx.pojo.Owner;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口（业主）
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("ownerDao")
public interface OwnerMapper extends BaseMapper<Owner> {

    /**
     * 查询所有业主信息
     */
    List<Owner> queryOwnerAll(Owner owner);
}
