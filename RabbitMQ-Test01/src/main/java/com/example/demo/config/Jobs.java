package com.example.demo.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Jobs {
    public final static long ONE_Minute =  60 * 1000;
    
    @Autowired HelloSender helleSender;
    @Scheduled(cron = "0/1 * * * * ? ") // 间隔5秒执行
    public void fixedDelayJob(){
        System.out.println("定时任务执行中...");
        helleSender.send();
        
    }
    
//    @Scheduled(fixedRate=ONE_Minute)
//    public void fixedRateJob(){
//        System.out.println("我执行了");
//    }
//
//    @Scheduled(cron="0 15 3 * * ?")
//    public void cronJob(){
//        System.out.println("我执行了");
//    }
}
