package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Count;
import com.yx.pojo.Repair;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
public interface IRepairService extends IService<Repair> {


    PageInfo<Repair> queryRepairAll(Integer pageNum, Integer limit, Repair repair);
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repair>
     */
    IPage<Repair> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param repair 
     * @return int
     */
    int add(Repair repair);

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
     * @param repair 
     * @return int
     */
    int updateData(Repair repair);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repair
     */
    Repair findById(Long id);

    //统计
    List<Count> queryCount();
}
