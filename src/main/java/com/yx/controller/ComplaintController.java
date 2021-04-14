package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IComplaintService;
import com.yx.pojo.Complaint;
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
@RequestMapping("/complaint")
public class ComplaintController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IComplaintService complaintService;

    @RequestMapping("/queryComplaintAll")
    public JsonObject queryComplaintAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "15") Integer limit, Complaint complaint){
        PageInfo<Complaint> pageInfo = complaintService.queryComplaintAll(pageNum, limit, complaint);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Complaint complaint){
        return complaintService.add(complaint);
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R deleteByIds(String ids){
        List<String> list = Arrays.asList(ids.split(","));
        for (String id : list){
            complaintService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(Integer id){
        Complaint complaint = new Complaint();
        complaint.setId(id);
//        complaint.setClr();
        complaint.setStatus(1);
        int num = complaintService.updateData(complaint);
        if (num > 0){
            return R.ok();
        }else {
            return R.fail("处理失败");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Complaint> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return complaintService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Complaint findById(@PathVariable Long id){
        return complaintService.findById(id);
    }

}
