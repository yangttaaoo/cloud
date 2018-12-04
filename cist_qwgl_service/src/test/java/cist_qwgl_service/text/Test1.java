package cist_qwgl_service.text;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.cist.ServiceApplication;
import com.cist.myScheduling.service.MySchedulingService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Test1 {
	@Autowired
	private MySchedulingService service;

	@Test
	public void testTest() {
		System.out.println(service.selectlist(new HashMap<String,Object>() {
			{
				put("report_person_id", "4008");
			}
		}));
	}

}
