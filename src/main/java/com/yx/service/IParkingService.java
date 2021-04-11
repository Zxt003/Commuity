package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Parking;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
public interface IParkingService extends IService<Parking> {


    /**
     * 查询所有车位信息
     */
    PageInfo<Parking> queryParkAll(Integer pageNum,Integer limit,String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Parking>
     */
    IPage<Parking> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param parking 
     * @return int
     */
    int add(Parking parking);

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
     * @param parking 
     * @return int
     */
    int updateData(Parking parking);

    /**
     * id查询数据
     *
     * @param id id
     * @return Parking
     */
    Parking findById(Long id);
}
