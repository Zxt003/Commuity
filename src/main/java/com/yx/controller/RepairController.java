package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Count;
import com.yx.pojo.Repairtype;
import com.yx.service.IRepairtypeService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IRepairService;
import com.yx.pojo.Repair;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Api(tags = {""})
@RestController
@RequestMapping("/repair")
public class RepairController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IRepairService repairService;

    @Resource
    private IRepairtypeService repairtypeService;


    @RequestMapping("/queryRepairAll")
    public JsonObject queryComplaintAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit, Repair repair){
        PageInfo<Repair> pageInfo = repairService.queryRepairAll(pageNum, limit, repair);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }


    @RequestMapping("/queryAll")
    public List<Repairtype> queryAll(){
        return repairtypeService.findList();
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Repair repair){
        return repairService.add(repair);
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list){
            repairService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Repair repair){
        return repairService.updateData(repair);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Repair> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return repairService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Repair findById(@PathVariable Long id){
        return repairService.findById(id);
    }


    /**
     * 统计分析
     */
    @RequestMapping("/queryCount")
    public List<Count> queryCount(){
        return repairService.queryCount();
    }
}
