package com.yx.service;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.RecordVo;
import com.yx.pojo.Records;
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
public interface IRecordsService extends IService<Records> {

    /**
     * 查询所有抄表记录
     */
    PageInfo<RecordVo> queryRecordsAll(Integer pageNum, Integer limit, RecordVo recordVo);

    public Records queryByHouIdAndTypeId(Integer houId, Integer typeId);
    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Records>
     */
    IPage<Records> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param records 
     * @return int
     */
    int add(Records records);

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
     * @param records 
     * @return int
     */
    int updateData(Records records);

    /**
     * id查询数据
     *
     * @param id id
     * @return Records
     */
    Records findById(Long id);
}
