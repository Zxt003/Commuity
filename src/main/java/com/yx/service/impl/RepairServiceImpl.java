package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Count;
import com.yx.pojo.Repair;
import com.yx.dao.RepairMapper;
import com.yx.service.IRepairService;
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
public class RepairServiceImpl extends ServiceImpl<RepairMapper, Repair> implements IRepairService {

    @Autowired
    private RepairMapper repairDao;

    @Override
    public PageInfo<Repair> queryRepairAll(Integer pageNum, Integer limit, Repair repair) {
        PageHelper.startPage(pageNum,limit);
        List<Repair> list = repairDao.queryRepairAll(repair);
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<Repair> findListByPage(Integer page, Integer pageCount){
        IPage<Repair> wherePage = new Page<>(page, pageCount);
        Repair where = new Repair();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Repair repair){
        return baseMapper.insert(repair);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Repair repair){
        return baseMapper.updateById(repair);
    }

    @Override
    public Repair findById(Long id){
        return  baseMapper.selectById(id);
    }

    @Override
    public List<Count> queryCount() {
        return repairDao.queryCount();
    }
}
