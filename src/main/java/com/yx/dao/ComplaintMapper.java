package com.yx.dao;

import com.yx.pojo.Complaint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("complaintDao")
public interface ComplaintMapper extends BaseMapper<Complaint> {

    List<Complaint> queryComplaintAll(Complaint complaint);
}
