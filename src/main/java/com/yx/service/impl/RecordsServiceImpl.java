package com.yx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yx.pojo.RecordVo;
import com.yx.pojo.Records;
import com.yx.dao.RecordsMapper;
import com.yx.service.IRecordsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class RecordsServiceImpl extends ServiceImpl<RecordsMapper, Records> implements IRecordsService {

    @Autowired
    private RecordsMapper recordsDao;

    @Override
    public PageInfo<RecordVo> queryRecordsAll(Integer page, Integer limit, RecordVo recordVo) {
        PageHelper.startPage(page,limit);
        List<RecordVo> list=recordsDao.queryRecordsAll(recordVo);
        return new PageInfo<>(list);
    }

    @Override
    public Records queryByHouIdAndTypeId(Integer houId, Integer typeId) {
        return recordsDao.queryByHouIdAndTypeId(houId,typeId);
    }

    @Override
    public  IPage<Records> findListByPage(Integer page, Integer pageCount){
        IPage<Records> wherePage = new Page<>(page, pageCount);
        Records where = new Records();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Records records){
        return baseMapper.insert(records);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Records records){
        return baseMapper.updateById(records);
    }

    @Override
    public Records findById(Long id){
        return  baseMapper.selectById(id);
    }
}
