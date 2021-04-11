package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Owner;
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
public interface IOwnerService extends IService<Owner> {


    /**
     * 查询所有业主信息
     */
    PageInfo<Owner> queryOwnerAll(Integer pageNum,Integer limit,Owner owner);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Owner>
     */
    IPage<Owner> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param owner 
     * @return int
     */
    int add(Owner owner);

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
     * @param owner 
     * @return int
     */
    int updateData(Owner owner);

    /**
     * id查询数据
     *
     * @param id id
     * @return Owner
     */
    Owner findById(Long id);
}
