package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Building;
import com.yx.dao.BuildingMapper;
import com.yx.service.IBuildingService;
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
public class BuildingServiceImpl extends ServiceImpl<BuildingMapper, Building> implements IBuildingService {

    @Autowired
    private BuildingMapper buildingDao;
    @Override
    public PageInfo<Building> queryBuildAll(Integer pageNum, Integer limit, String numbers) {
        PageHelper.startPage(pageNum,limit);
        List<Building> buildingList = buildingDao.queryBuildAll(numbers);
        return new PageInfo<>(buildingList);
    }

    @Override
    public  IPage<Building> findListByPage(Integer page, Integer pageCount){
        IPage<Building> wherePage = new Page<>(page, pageCount);
        Building where = new Building();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Building building){
        return baseMapper.insert(building);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Building building){
        return baseMapper.updateById(building);
    }

    @Override
    public Building findById(Long id){
        return  baseMapper.selectById(id);
    }
}
