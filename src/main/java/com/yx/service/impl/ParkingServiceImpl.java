package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Parking;
import com.yx.dao.ParkingMapper;
import com.yx.service.IParkingService;
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
public class ParkingServiceImpl extends ServiceImpl<ParkingMapper, Parking> implements IParkingService {

    @Autowired
    private ParkingMapper parkingDao;

    @Override
    public PageInfo<Parking> queryParkAll(Integer pageNum, Integer limit, String numbers) {
        PageHelper.startPage(pageNum,limit);
        List<Parking> list = parkingDao.queryParkAll(numbers);
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<Parking> findListByPage(Integer page, Integer pageCount){
        IPage<Parking> wherePage = new Page<>(page, pageCount);
        Parking where = new Parking();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Parking parking){
        return baseMapper.insert(parking);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Parking parking){
        return baseMapper.updateById(parking);
    }

    @Override
    public Parking findById(Long id){
        return  baseMapper.selectById(id);
    }
}
