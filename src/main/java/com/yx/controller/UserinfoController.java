package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.util.JsonObject;
import com.yx.util.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.yx.service.IUserinfoService;
import com.yx.pojo.Userinfo;
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
@RequestMapping("/userinfo")
public class UserinfoController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IUserinfoService userinfoService;

    /**
     * 查找所有管理信息
     * @param userinfo
     * @return
     */
    @RequestMapping("/queryUserInfoAll")
    public JsonObject queryUserInfoAll(@RequestParam(defaultValue = "1") Integer pageNum,
                                       @RequestParam(defaultValue = "15") Integer limit,
                                       Userinfo userinfo){
        PageInfo<Userinfo> pageInfo= userinfoService.queryUserinfoAll(pageNum,limit,userinfo);
        return new JsonObject(0,"ok",pageInfo.getTotal(),pageInfo.getList());
    }

    @ApiOperation(value = "新增")
    @RequestMapping("/add")
    public R add(@RequestBody Userinfo userinfo){
        userinfoService.add(userinfo);
        return R.ok();
    }

    @ApiOperation(value = "删除")
    @RequestMapping("/deleteByIds")
    public R delete(String  ids){
        List<String> list= Arrays.asList(ids.split(","));
        //遍历遍历进行删除
        for(String id:list){
            userinfoService.delete(Long.parseLong(id));
        }
        return R.ok();
    }

    @ApiOperation(value = "更新")
    @RequestMapping("/update")
    public R update(String oldPwd,String newPwd,Integer id){
        //根据id获取当前的数据记录
        Userinfo user=userinfoService.findById(new Long(id));
        if(oldPwd.equals(user.getPassword())){//输入的老密码和原密码一致
            user.setPassword(newPwd);
            userinfoService.updateData(user);
            return R.ok();
        }else{
            return R.fail("两次密码不一致");
        }
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Userinfo> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return userinfoService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Userinfo findById(@PathVariable Long id){
        return userinfoService.findById(id);
    }

}
