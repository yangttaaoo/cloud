package com.yt;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yt.demo.entity.User;
import com.yt.demo.service.UserService;
import com.yt.redis.util.RedisUtil;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemo1ApplicationTests {

	@Autowired RedisUtil redisUtil;
	@Autowired UserService userService;
	
	@Test
	public void contextLoads() {
		List<User> selectList = userService.selectList(null);
		System.out.println(selectList.toString());
		redisUtil.set("xm", "张三");
	}

}
