package com.example.demo.config;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "hello " + new Date();
		System.out.println("生产者生产了");
		this.rabbitTemplate.convertAndSend("async",context);//异步发送
//		this.rabbitTemplate.convertAndSend("hello", context);
	}
}
