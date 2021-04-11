package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IBuildingService;
import com.yx.pojo.Building;
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
@RequestMapping("/building")
public class BuildingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IBuildingService buildingService;

    /**
     * 查询所有楼宇记录
     */
    @RequestMapping("/queryBuildAll")
    public JsonObject queryBuildAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                    @RequestParam(defaultValue = "15") Integer limit,
                                    String numbers){
        JsonObject jsonObject = new JsonObject();
        PageInfo<Building> buildingPageInfo = buildingService.queryBuildAll(pageNum, limit, numbers);
        jsonObject.setCode(0);
        jsonObject.setMsg("ok");
        jsonObject.setCount(buildingPageInfo.getTotal());
        jsonObject.setData(buildingPageInfo.getList());
        return jsonObject;
    }

    /**
     * 下拉框，查询所有楼宇信息
     * @return
     */
    @RequestMapping("/queryBuild")
    public List<Building> queryBuild(){
        PageInfo<Building> pageInfo = buildingService.queryBuildAll(1, 100, null);
        return pageInfo.getList();
    }

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public R add(@RequestBody Building building){
        int num = buildingService.add(building);
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
            buildingService.delete(Long.parseLong(id));//这里必须接收long类型，所以转成long
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Building building){
        int num = buildingService.updateData(building);
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
    public IPage<Building> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return buildingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Building findById(@PathVariable Long id){
        return buildingService.findById(id);
    }

}
