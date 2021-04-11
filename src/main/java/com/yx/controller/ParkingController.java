package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IParkingService;
import com.yx.pojo.Parking;
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
@RequestMapping("/parking")
public class ParkingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IParkingService parkingService;

    @RequestMapping("/queryParkAll")
    public JsonObject queryParkAll(@RequestParam(defaultValue = "1")Integer pageNum,
                                   @RequestParam(defaultValue = "15")Integer limit,
                                   String numbers){
        PageInfo<Parking> pageInfo = parkingService.queryParkAll(pageNum,limit,numbers);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @ApiOperation(value = "新增")
    @PostMapping("/add")
    public R add(@RequestBody Parking parking){
        int num = parkingService.add(parking);
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
            parkingService.delete(Long.parseLong(id));//这里必须接收long类型，所以转成long
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(@RequestBody Parking parking){
        Parking park = new Parking();
        if(parking.getOwnerId()!=null){//关联到了户主
            park.setStatus(1);
        }else{
            park.setStatus(0);
        }
        park.setId(parking.getId());
        park.setNumbers(parking.getNumbers());
        park.setRemarks(parking.getRemarks());
        park.setOwnerId(parking.getOwnerId());
        int num = parkingService.updateData(parking);
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
    public IPage<Parking> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return parkingService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Parking findById(@PathVariable Long id){
        return parkingService.findById(id);
    }

}
