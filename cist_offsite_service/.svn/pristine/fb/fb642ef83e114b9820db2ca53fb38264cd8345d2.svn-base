package com.cist.illegalUpload.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;

import com.alibaba.druid.util.StringUtils;
import com.cist.frame.springContext.SpringContextUtil;
import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.cist.illegalUpload.service.IllegalUploadService;
import com.cist.illegalUpload.service.VehicleUtil;

public class IllegalAutoUploadCallable implements Runnable{
	/**六合一*/
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Logger log = LoggerFactory.getLogger(IllegalAutoUploadCallable.class);
	@SuppressWarnings({ "static-access", "unused" })
	@Override
	public void run(){
		try{
			IllegalUploadService service = SpringContextUtil.getBean(IllegalUploadService.class);
			Integer auto = service.automaticupload();
			 /**违法数据自动上传六合一获取上传标志，自动上传1关闭2启动*/
			if(true){//auto.equals(2)
				
				List<Tbloffeevdi> list =service.queryAutoOffeInfo();
				if(null!=list && !list.isEmpty()){
					service.updateOffzt(list);///**13-上传队列*/
					VehicleUtil ve = new VehicleUtil();
					for(Tbloffeevdi tbl : list){
						try {
							HashMap<String,String> map = new HashMap<String,String>();
							map.put("xh",""); 
							map.put("cjjg","511700000000");
							map.put("clfl", "3");
							map.put("hpzl", tbl.getHPZL());
							String temp_hphm = tbl.getHPHM();
							if(null!=temp_hphm && !"".equals(temp_hphm)){
								if(temp_hphm.indexOf("学")!=-1 || temp_hphm.indexOf("挂")!=-1){
									temp_hphm = temp_hphm.substring(0, temp_hphm.length()-1);
								}
							}else{
								temp_hphm = "";
							}
							//map.put("hphm", temp_hphm);
							map.put("hphm", "川SSN60");
							map.put("jdcsyr", tbl.getJDCSYR());
							map.put("syxz", tbl.getSYXZ());
							map.put("fdjh",tbl.getFDJH());
							map.put("clsbdh", tbl.getCLSBDH());
							map.put("csys",tbl.getCSYS());
							map.put("clpp", tbl.getCLPP1());
							map.put("jtfs", tbl.getCLLX());
							map.put("fzjg", tbl.getFZJG());
							map.put("zsxzqh", "");
							map.put("zsxxdz", tbl.getZSXXDZ());
							map.put("dh", "");
							map.put("lxfs", "");
							map.put("tzsh", "");
							map.put("tzrq", null);
							map.put("cjfs", tbl.getSJLY());
							map.put("wfsj",sdf.format(tbl.getWFSJ()));
							map.put("xzqh", tbl.getRESVE());
							if(null!=tbl.getKKBH() && !"".equals(tbl.getKKBH())){
								map.put("wfdd", tbl.getKKBH().substring(0, 5));
								map.put("lddm", tbl.getKKBH().substring(5, 9));
								map.put("ddms", tbl.getKKBH().substring(9, 12));
							}else{
								map.put("wfdd", "");
								map.put("lddm", "");
								map.put("ddms", "");
							}
							map.put("wfdz",tbl.getWFDD());
							if(StringUtils.equals(tbl.getWFXW(), "13441"))
							{
								map.put("wfxw","1344");
							}
							else
							{
								map.put("wfxw",tbl.getWFXW());
							}
							map.put("scz",tbl.getCLSD()+"");
							map.put("bzz",tbl.getBDSD()+"");
							map.put("zqmj","");
							map.put("spdz","");
							map.put("sbbh",tbl.getSBBH());
							boolean isImgAsBase64 = true;
							String imgBase64 = null;
							if(null!=tbl.getWFZJ1() && !"".equals(tbl.getWFZJ1())){
								imgBase64 = img2base64(tbl.getWFZJ1());
								map.put("zpstr1",imgBase64);
								if(StringUtils.isEmpty(imgBase64))
								{
									tbl.setSHBZ(8);
									tbl.setSCDM("第一张违法图片编码失败");
									isImgAsBase64 = false;
								}
							}else{
								map.put("zpstr1","");
								tbl.setSHBZ(8);
								tbl.setSCDM("第一张违法图片不允许为空");
								isImgAsBase64 = false;
							}
							if(isImgAsBase64 && null!=tbl.getWFZJ2() && !"".equals(tbl.getWFZJ2())){
								imgBase64 = img2base64(tbl.getWFZJ2());
								map.put("zpstr2",imgBase64);
								if(StringUtils.isEmpty(imgBase64))
								{
									tbl.setSHBZ(8);
									tbl.setSCDM("第二张违法图片编码失败");
									isImgAsBase64 = false;
								}
							}else{
								map.put("zpstr2","");
							}
							if(isImgAsBase64 && null!=tbl.getWFZJ3() && !"".equals(tbl.getWFZJ3())){
								imgBase64 = img2base64(tbl.getWFZJ3());
								map.put("zpstr3",imgBase64);
								if(StringUtils.isEmpty(imgBase64))
								{
									tbl.setSHBZ(8);
									tbl.setSCDM("第三张违法图片编码失败");
									isImgAsBase64 = false;
								}
							}else{
								map.put("zpstr3","");
							}
							log.info("------------上传违法数据开始--------------");
							log.info(tbl.toString());
							if(isImgAsBase64)
							{
								String s = ve.Uploadillage_wsh("viosurveil",map);
								if(null!=s && !"".equals(s)){
									String restr1 = getilldate(s,"<msg1>","</msg1>");//success
									String restr = getilldate(s,"<msg>","</msg>"); //failure
							
									String code  = getilldate(s,"<code>","</code>");
									if("1".equals(code)){
										tbl.setSCDM(restr1+":"+restr);
										tbl.setSHBZ(7);
									}else{
										tbl.setSCDM(restr1+":"+restr);
										tbl.setSHBZ(8);
									}
								}else{
									//tbl.setSHBZ(8);
									tbl.setSHBZ(13);
									tbl.setSCDM("六合一报错或无返回结果");
								}
							}
						}catch(Exception e) {
							tbl.setSHBZ(8);
							tbl.setSCDM("上传违法数据至六合一时程序执行出错");
					   }
						log.info("数据上传结果="+tbl.getSCDM());
						log.info("------------上传违法数据结束--------------");
						//更新数据库状态
						log.info("----------违法数据上传结果更新开始------------");
						int result = -1;
						try{
							System.err.println(tbl.toString());
							result = service.updateOffEdv(tbl);
						}catch(Exception e){
							log.info("违法数据上传结果更新出错"+e.getMessage());
						}
						if(result==0){
							try{
								log.info("数据上传过程中被删除，自动添加开始");
							//+	service.addOffedv(tbl);
								log.info("数据上传过程中被删除，自动添加结束");
							}catch(Exception e){
								e.printStackTrace();
								log.info("数据上传过程中被删除，自动添加失败");
							}
						}
						log.info("----------违法数据上传结果更新结束------------");
					}
				}else{
					log.info("无可上传数据，等待上传数据");
				}
			}else{
				log.info("违法数据自动上传已被关闭");
			}
		}catch(Throwable e){
			e.printStackTrace();
			log.info("查询可上传或更新队列中违法数据程序执行报错");
		}
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
}