package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Userinfo;
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
public interface IUserinfoService extends IService<Userinfo> {


    PageInfo<Userinfo> queryUserinfoAll(Integer pageNum, Integer limit, Userinfo userinfo);
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Userinfo>
     */
    IPage<Userinfo> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param userinfo 
     * @return int
     */
    int add(Userinfo userinfo);

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
     * @param userinfo 
     * @return int
     */
    int updateData(Userinfo userinfo);

    /**
     * id查询数据
     *
     * @param id id
     * @return Userinfo
     */
    Userinfo findById(Long id);

    Userinfo queryUserByNameAndPwd(Userinfo userinfo);
}
