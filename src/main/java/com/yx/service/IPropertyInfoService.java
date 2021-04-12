package com.yx.service;

import com.yx.pojo.PropertyInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
public interface IPropertyInfoService extends IService<PropertyInfo> {



    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<PropertyInfo>
     */
    IPage<PropertyInfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 根据时间和房子id获取相关记录信息
     */
    void deleteInfoByHouIdAndTime(@Param("houId") Integer houId,@Param("endDate") Date endDate);

    /**
     * 添加
     *
     * @param propertyInfo 
     * @return int
     */
    int add(PropertyInfo propertyInfo);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param propertyInfo 
     * @return int
     */
    int updateData(PropertyInfo propertyInfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return PropertyInfo
     */
    PropertyInfo findById(Long id);
}
