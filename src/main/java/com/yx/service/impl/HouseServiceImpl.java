package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.House;
import com.yx.dao.HouseMapper;
import com.yx.service.IHouseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
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
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements IHouseService {

    @Autowired
    private HouseMapper houseDao;

    @Override
    public PageInfo<House> queryHouseAll(Integer pageNum, Integer limit, String numbers) {
        PageHelper.startPage(pageNum,limit);
        List<House> houseList = houseDao.queryHouseAll(numbers);
        return new PageInfo<>(houseList);
    }

    @Override
    public  IPage<House> findListByPage(Integer page, Integer pageCount){
        IPage<House> wherePage = new Page<>(page, pageCount);
        House where = new House();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(House house){
        return baseMapper.insert(house);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(House house){
        return baseMapper.updateById(house);
    }

    @Override
    public House findById(Long id){
        return  baseMapper.selectById(id);
    }
}
