package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.Carcharge;
import com.yx.pojo.PropertyInfo;
import com.yx.dao.PropertyInfoMapper;
import com.yx.service.IPropertyInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.text.SimpleDateFormat;
import java.util.Date;
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
public class PropertyInfoServiceImpl extends ServiceImpl<PropertyInfoMapper, PropertyInfo> implements IPropertyInfoService {

    @Autowired
    private PropertyInfoMapper propertyInfoDao;

    @Override
    public void deleteInfoByHouIdAndTime(Integer houId, Date endTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(endTime);
        dateString = dateString.substring(0,9);
        propertyInfoDao.deleteByHouIdAndTime(houId,dateString);
    }

    @Override
    public PageInfo<PropertyInfo> queryPropertyInfoAll(Integer pageNum, Integer limit, PropertyInfo propertyInfo) {
        PageHelper.startPage(pageNum,limit);
        List<PropertyInfo> list = propertyInfoDao.queryListAll();
        return new PageInfo<>(list);
    }

    @Override
    public  IPage<PropertyInfo> findListByPage(Integer page, Integer pageCount){
        IPage<PropertyInfo> wherePage = new Page<>(page, pageCount);
        PropertyInfo where = new PropertyInfo();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(PropertyInfo propertyInfo){
        return baseMapper.insert(propertyInfo);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(PropertyInfo propertyInfo){
        return baseMapper.updateById(propertyInfo);
    }

    @Override
    public PropertyInfo findById(Long id){
        return  baseMapper.selectById(id);
    }
}
