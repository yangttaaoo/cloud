package com.example.demo;

import java.util.Date;
import org.assertj.core.internal.Dates;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.config.HelloSender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqTest01ApplicationTests {
	
	public final static long ONE_Minute =  60 * 1000;
	@Test
	public void contextLoads() {
	}
	
	@Autowired HelloSender helloSender;
	
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    @Scheduled(fixedDelay=ONE_Minute)
    public void fixedDelayJob(){
        System.out.println("我执行了定时任务");
    }
    

}
