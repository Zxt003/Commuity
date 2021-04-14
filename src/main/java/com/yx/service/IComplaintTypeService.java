package com.yx.service;

import com.yx.pojo.ComplaintType;
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
public interface IComplaintTypeService extends IService<ComplaintType> {

    List<ComplaintType> queryType();

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<ComplaintType>
     */
    IPage<ComplaintType> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param complaintType 
     * @return int
     */
    int add(ComplaintType complaintType);

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
     * @param complaintType 
     * @return int
     */
    int updateData(ComplaintType complaintType);

    /**
     * id查询数据
     *
     * @param id id
     * @return ComplaintType
     */
    ComplaintType findById(Long id);
}
