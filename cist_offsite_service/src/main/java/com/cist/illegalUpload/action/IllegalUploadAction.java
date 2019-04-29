package com.cist.illegalUpload.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Encoder;

import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.alibaba.druid.util.StringUtils;
import com.cist.illegalUpload.domain.Vehicle;
import com.cist.illegalUpload.service.IllegalUploadService;
import com.cist.illegalUpload.service.QueryCarinfoService;
import com.cist.illegalUpload.service.VehicleUtil;
@RestController
@RequestMapping("illegalUploadAction")
public class IllegalUploadAction {

	private Logger log = LoggerFactory.getLogger(IllegalUploadAction.class);
	private static final ReentrantLock LOCK = new ReentrantLock();

	@Autowired
	private QueryCarinfoService queryService;
	@Autowired
	IllegalUploadService illegaluploadservice;
	//六合一接口-查询车驾信息
	@RequestMapping("queryCarInfo")
	public Vehicle queryCarInfo(@RequestBody HashMap<String,String> map){
		Vehicle ve = null;
		try
		{
		   Integer a=illegaluploadservice.cjgjkfs();
		   if(a==1) {//1查询接口2查询数据库
			   ve = queryService.queryVechile(map);
		   }else {
			   String hphm = map.get("hphm");
			   if(hphm.substring(0,1).equals("川")){
					map.put("hphm", hphm.substring(1));
					map.put("hpzl", map.get("hpzl"));
					ve = illegaluploadservice.vehicledate(map);
				}else{
					return null;
				}
			  
		   }
		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ve;
	}
	
	@RequestMapping("uploadIllegal")
	public Map<String,String> uploadIllegal(@RequestBody Map<String,String> map1){
		String code = "1";
		try
		{
			LOCK.lock();
			Tbloffeevdi tbl = new Tbloffeevdi();
			tbl.setWFPK(Long.parseLong(map1.get("wfpk")));
			illegaluploadservice.updateOffQue(tbl);
		}catch(Exception e){
			log.info("数据进入队列报错");
			code = "2";
		}finally{
			LOCK.unlock();
		}
		Map<String,String> result = new HashMap<String, String>();
		result.put("code", code);
		return result;
	}
	
	private String getilldate(String car_in,String code,String _code){
		try {
			int l = code.length();
			if(car_in.indexOf(code)!= -1){
				return car_in.substring(car_in.indexOf(code)+l, car_in.indexOf(_code));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	private String img2base64(String path){
		ByteArrayOutputStream byteArray = new ByteArrayOutputStream();  
		byte[] buffer = new byte[1024];  
		InputStream inputStream = null;
		String baseStr = null;
		int len = 0;
		HttpURLConnection conn = null;
		try{
			URL url = new URL(path);
			conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");  
	        conn.setConnectTimeout(5 * 1000);  
	        inputStream = conn.getInputStream();
	        while((len=inputStream.read(buffer))!=-1){
	        	byteArray.write(buffer,0, len);
	        }
	        
//	        FileOutputStream out = new FileOutputStream("d:\\"+new Date().getTime()+".jpeg");
//	        out.write(byteArray.toByteArray());
//	        out.flush();
//	        out.close();
	        
	        BASE64Encoder encoder = new BASE64Encoder();
	        baseStr = java.net.URLEncoder.encode(encoder.encodeBuffer(byteArray.toByteArray()).trim(),"utf-8"); 
		}catch(Exception e){
			baseStr = null;
			log.info("违法图片编码base64错误");
			//e.printStackTrace();
		}finally{
			if(conn!=null){
				conn.disconnect();  
			}
			if(inputStream!=null){
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(byteArray!=null){
					try {
						byteArray.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
			}
		}
		return baseStr;
	}
	
	private Tbloffeevdi checkOffedvi(Map<String,Object> map){
		Tbloffeevdi tbl = null;
		try{
		tbl = illegaluploadservice.checkOffedvi(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return tbl;
	}
}