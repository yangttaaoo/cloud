package com.yt.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yt.demo.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yt123
 * @since 2019-04-29
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
