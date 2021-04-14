package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Parking;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IPropertyInfoService;
import com.yx.pojo.PropertyInfo;
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
@RequestMapping("/propertyinfo")
public class PropertyInfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IPropertyInfoService propertyInfoService;

    @RequestMapping("/queryPropertyAll")
    public JsonObject queryPropertyAll(@RequestParam(defaultValue = "1")Integer pageNum,
                                   @RequestParam(defaultValue = "15")Integer limit,
                                   PropertyInfo propertyInfo){
        PageInfo<PropertyInfo> pageInfo = propertyInfoService.queryPropertyInfoAll(pageNum,limit,propertyInfo);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody PropertyInfo propertyInfo){
        return propertyInfoService.add(propertyInfo);
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list= Arrays.asList(ids.split(","));
        for(String id:list){
            Long idLong=new Long(id);
            propertyInfoService.delete(idLong);
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody PropertyInfo propertyInfo){
        return propertyInfoService.updateData(propertyInfo);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<PropertyInfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return propertyInfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public PropertyInfo findById(@PathVariable Long id){
        return propertyInfoService.findById(id);
    }

}
