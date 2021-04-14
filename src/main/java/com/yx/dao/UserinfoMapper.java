package com.yx.dao;

import com.yx.pojo.Userinfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yx
 * @since 2021-04-09
 */
@Component("userinfoDao")
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    /**
     * 管理
     * @param userinfo
     * @return
     */
    List<Userinfo> queryUserinfoAll(Userinfo userinfo);

    Userinfo queryUserByNameAndPwd(Userinfo userinfo);//参数可以传多个值，但一个对象包含所有值就用对象，封装思想
}
