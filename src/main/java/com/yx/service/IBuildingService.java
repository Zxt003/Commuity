package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Building;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
public interface IBuildingService extends IService<Building> {

    /**
     * 查询所有楼宇信息
     * @param pageNum
     * @param limit
     * @param numbers
     * @return
     */
    PageInfo<Building> queryBuildAll(Integer pageNum,Integer limit,String numbers);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Building>
     */
    IPage<Building> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param building 
     * @return int
     */
    int add(Building building);

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
     * @param building 
     * @return int
     */
    int updateData(Building building);

    /**
     * id查询数据
     *
     * @param id id
     * @return Building
     */
    Building findById(Long id);
}
