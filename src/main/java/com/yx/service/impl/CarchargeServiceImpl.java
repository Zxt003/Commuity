package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Carcharge;
import com.yx.dao.CarchargeMapper;
import com.yx.service.ICarchargeService;
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
public class CarchargeServiceImpl extends ServiceImpl<CarchargeMapper, Carcharge> implements ICarchargeService {

    @Autowired
    private CarchargeMapper carchargeDao;

    @Override
    public PageInfo<Carcharge> queryCarChargeAll(Integer pageNum, Integer limit, Carcharge carcharge) {
        PageHelper.startPage(pageNum,limit);
        List<Carcharge> list = carchargeDao.queryCarchargeAll(carcharge);
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<Carcharge> findListByPage(Integer page, Integer pageCount){
        IPage<Carcharge> wherePage = new Page<>(page, pageCount);
        Carcharge where = new Carcharge();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Carcharge carcharge){
        return baseMapper.insert(carcharge);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Carcharge carcharge){
        return baseMapper.updateById(carcharge);
    }

    @Override
    public Carcharge findById(Long id){
        return  baseMapper.selectById(id);
    }
}
