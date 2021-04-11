package com.yx.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IComplaintTypeService;
import com.yx.pojo.ComplaintType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/complaint-type")
public class ComplaintTypeController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IComplaintTypeService complaintTypeService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody ComplaintType complaintType){
        return complaintTypeService.add(complaintType);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return complaintTypeService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody ComplaintType complaintType){
        return complaintTypeService.updateData(complaintType);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<ComplaintType> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return complaintTypeService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public ComplaintType findById(@PathVariable Long id){
        return complaintTypeService.findById(id);
    }

}
