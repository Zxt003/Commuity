package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.pojo.Parking;
import com.yx.service.IParkingService;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yx.service.ICarchargeService;
import com.yx.pojo.Carcharge;
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
@RequestMapping("/carcharge")
public class CarchargeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ICarchargeService carchargeService;

    @Autowired
    private IParkingService parkingService;

    @RequestMapping("/queryCarchargeAll")
    public JsonObject queryCarchargeAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit,Carcharge carcharge,String numbers){
        if (numbers != null){
            Parking parking = new Parking();
            parking.setNumbers(numbers);
            carcharge.setParking(parking);
        }
        PageInfo<Carcharge> pageInfo = carchargeService.queryCarChargeAll(pageNum, limit, carcharge);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }


    @ApiOperation(value = "新增")
    @RequestMapping("/initData")
    public R initData(@RequestBody Carcharge carcharge){
        /**
         * 遍历所有的车位信息（这是为了给所有车一起收费）
         */
        List<Parking> parkings = parkingService.queryParkAllByStatus();//获取到所有正在使用的车位
        for (Parking parking : parkings){
            carcharge.setStatus(0);//初始化后的车肯定是未使用的
            carcharge.setOwnerId(parking.getOwnerId());
            carcharge.setType("停车费");
            carcharge.setParkId(parking.getId());
            carchargeService.add(carcharge);
        }
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list){
            carchargeService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(Integer id){
        Carcharge carcharge = new Carcharge();
        carcharge.setId(id);
        carcharge.setStatus(1);//已经缴费
        int num = carchargeService.updateData(carcharge);
        if (num > 0){
            return R.ok();
        }else {
            return R.fail("修改失败");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Carcharge> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return carchargeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Carcharge findById(@PathVariable Long id){
        return carchargeService.findById(id);
    }

}
