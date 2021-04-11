package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.House;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IOwnerService;
import com.yx.pojo.Owner;
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
@RequestMapping("/owner")
public class OwnerController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IOwnerService ownerService;

    @RequestMapping("/queryOwnerAll")
    public JsonObject queryHouseAll(@RequestParam(defaultValue = "1")Integer pageNum,
                                    @RequestParam(defaultValue = "15")Integer limit,
                                    Owner owner){

        PageInfo<Owner> pageInfo = ownerService.queryOwnerAll(pageNum, limit, owner);

        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("/queryAll")
    @Transactional
    public List queryAll(){
        PageInfo<Owner> pageInfo= ownerService.queryOwnerAll(1,100,null);
        return pageInfo.getList();
    }

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public R add(@RequestBody Owner owner){
        int num = ownerService.add(owner);
        if (num > 0){
            return R.ok();
        }else{
            return R.fail("添加失败");
        }
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list) {
            ownerService.delete(Long.parseLong(id));//这里必须接收long类型，所以转成long
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Owner owner){
        int num = ownerService.updateData(owner);
        if (num > 0){
            return R.ok();
        }else{
            return R.fail("修改失败");
        }
    }
    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Owner> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return ownerService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Owner findById(@PathVariable Long id){
        return ownerService.findById(id);
    }

}
