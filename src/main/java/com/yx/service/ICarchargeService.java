package com.yx.service;

import com.yx.pojo.Carcharge;
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
public interface ICarchargeService extends IService<Carcharge> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Carcharge>
     */
    IPage<Carcharge> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param carcharge 
     * @return int
     */
    int add(Carcharge carcharge);

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
     * @param carcharge 
     * @return int
     */
    int updateData(Carcharge carcharge);

    /**
     * id查询数据
     *
     * @param id id
     * @return Carcharge
     */
    Carcharge findById(Long id);
}
