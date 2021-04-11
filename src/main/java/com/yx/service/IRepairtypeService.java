package com.yx.service;

import com.yx.pojo.Repairtype;
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
public interface IRepairtypeService extends IService<Repairtype> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Repairtype>
     */
    IPage<Repairtype> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param repairtype 
     * @return int
     */
    int add(Repairtype repairtype);

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
     * @param repairtype 
     * @return int
     */
    int updateData(Repairtype repairtype);

    /**
     * id查询数据
     *
     * @param id id
     * @return Repairtype
     */
    Repairtype findById(Long id);
}
