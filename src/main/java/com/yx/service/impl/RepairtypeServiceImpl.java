package com.yx.service.impl;

import com.yx.dao.RepairMapper;
import com.yx.pojo.Repairtype;
import com.yx.dao.RepairtypeMapper;
import com.yx.service.IRepairtypeService;
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
public class RepairtypeServiceImpl extends ServiceImpl<RepairtypeMapper, Repairtype> implements IRepairtypeService {

    @Autowired
    private RepairMapper repairDao;

    @Override
    public List<Repairtype> findList() {
        return baseMapper.selectList(null);
    }

    @Override
    public  IPage<Repairtype> findListByPage(Integer page, Integer pageCount){
        IPage<Repairtype> wherePage = new Page<>(page, pageCount);
        Repairtype where = new Repairtype();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Repairtype repairtype){
        return baseMapper.insert(repairtype);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Repairtype repairtype){
        return baseMapper.updateById(repairtype);
    }

    @Override
    public Repairtype findById(Long id){
        return  baseMapper.selectById(id);
    }
}
