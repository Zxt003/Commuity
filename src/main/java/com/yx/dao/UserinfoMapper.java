package com.yx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yx.model.Userinfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author kappy
 * @since 2020-10-28
 */
@Component("userinfoDao")
public interface UserinfoMapper extends BaseMapper<Userinfo> {

    List<Userinfo> queryUserinfoAll(Userinfo userinfo);

    Userinfo queryUserByNameAndPwd(Userinfo userinfo);

}
