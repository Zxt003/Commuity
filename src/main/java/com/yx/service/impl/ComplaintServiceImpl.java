package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Complaint;
import com.yx.dao.ComplaintMapper;
import com.yx.pojo.ComplaintType;
import com.yx.service.IComplaintService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Service
public class ComplaintServiceImpl extends ServiceImpl<ComplaintMapper, Complaint> implements IComplaintService {

    @Autowired
    private ComplaintMapper complaintDao;
    @Override
    public PageInfo<Complaint> queryComplaintAll(Integer pageNum, Integer limit, Complaint complaint) {
        PageHelper.startPage(pageNum,limit);
        List<Complaint> list = complaintDao.queryComplaintAll(complaint);
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<Complaint> findListByPage(Integer page, Integer pageCount){
        IPage<Complaint> wherePage = new Page<>(page, pageCount);
        Complaint where = new Complaint();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Complaint complaint){
        return baseMapper.insert(complaint);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Complaint complaint){
        return baseMapper.updateById(complaint);
    }

    @Override
    public Complaint findById(Long id){
        return  baseMapper.selectById(id);
    }
}
