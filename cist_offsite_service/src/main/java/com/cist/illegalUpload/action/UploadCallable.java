package com.cist.illegalUpload.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sun.misc.BASE64Encoder;


import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.cist.illegalUpload.service.VehicleUtil;

public class UploadCallable implements Callable<List<Tbloffeevdi>>{
	private List<Tbloffeevdi> list;
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private Logger log = LoggerFactory.getLogger(UploadCallable.class);
	public UploadCallable(List<Tbloffeevdi> list){
		this.list = list;
	}
	@Override
	public List<Tbloffeevdi> call(){
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
					map.put("hphm", temp_hphm);
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
					//TODO -联系方式暂时不知 默认为空
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
					map.put("wfxw",tbl.getWFXW());
					map.put("scz",tbl.getCLSD()+"");
					map.put("bzz",tbl.getBDSD()+"");
					map.put("zqmj","");
					map.put("spdz","");
					map.put("sbbh",tbl.getSBBH());
					if(null!=tbl.getWFZJ1() && !"".equals(tbl.getWFZJ1())){
						map.put("zpstr1",img2base64(tbl.getWFZJ1()));
					}else{
						map.put("zpstr1","");
					}
					if(null!=tbl.getWFZJ2() && !"".equals(tbl.getWFZJ2())){
						map.put("zpstr2",img2base64(tbl.getWFZJ2()));
					}else{
						map.put("zpstr2","");
					}
					if(null!=tbl.getWFZJ3() && !"".equals(tbl.getWFZJ3())){
						map.put("zpstr3",img2base64(tbl.getWFZJ3()));
					}else{
						map.put("zpstr3","");
					}
					String s = ve.Uploadillage_wsh("viosurveil",map);
					//System.out.println(temp_hphm+"-------"+s);
					log.info(temp_hphm+"-------"+s);
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
						tbl.setSHBZ(8);
						tbl.setSCDM("六合一报错或无返回结果");
					}
				}catch(Exception e) {
					tbl.setSHBZ(8);
					tbl.setSCDM("程序执行出错");
					//e.printStackTrace();
					log.info("上传失败违法数据：\r\n"+tbl.toString());
					log.error("自动上传违法数据错误：",e.fillInStackTrace());
			   }
			}
		return list;
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
			log.error("违法图片编码base64错误：",e.fillInStackTrace());
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
	
	public static void main(String[] args) {
		String str = new UploadCallable(null).img2base64("");
		System.out.println(str);
	}
}
