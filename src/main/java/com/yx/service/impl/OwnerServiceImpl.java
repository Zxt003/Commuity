package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.dao.HouseMapper;
import com.yx.pojo.Owner;
import com.yx.dao.OwnerMapper;
import com.yx.service.IOwnerService;
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
public class OwnerServiceImpl extends ServiceImpl<OwnerMapper, Owner> implements IOwnerService {

    @Autowired
    private OwnerMapper ownerDao;

    @Override
    public PageInfo<Owner> queryOwnerAll(Integer pageNum, Integer limit, Owner owner) {
        PageHelper.startPage(pageNum,limit);
        List<Owner> list = ownerDao.queryOwnerAll(owner);
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<Owner> findListByPage(Integer page, Integer pageCount){
        IPage<Owner> wherePage = new Page<>(page, pageCount);
        Owner where = new Owner();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Owner owner){
        return baseMapper.insert(owner);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Owner owner){
        return baseMapper.updateById(owner);
    }

    @Override
    public Owner findById(Long id){
        return  baseMapper.selectById(id);
    }
}
