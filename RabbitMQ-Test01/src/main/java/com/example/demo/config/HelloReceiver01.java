package com.example.demo.config;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(bindings = {@QueueBinding(value = @Queue(value = "async"), exchange = @Exchange(value = "async.exchange"))})
public class HelloReceiver01 {

   @RabbitHandler
   public void process(String hello) throws InterruptedException {
	   System.out.println("Receiver01  : " + "我开始消费了");
	   System.out.println("Receiver01  : " + "我消费结束了"+hello);
   }

}