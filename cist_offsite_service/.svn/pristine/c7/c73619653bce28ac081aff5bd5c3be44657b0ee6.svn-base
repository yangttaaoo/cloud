package com.cist.illegalUpload.action;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sun.misc.BASE64Encoder;

import com.cist.illegalUpload.domain.Tbloffeevdi;
import com.alibaba.druid.util.StringUtils;
import com.cist.illegalUpload.domain.Vehicle;
import com.cist.illegalUpload.service.QueryCarinfoService;
import com.cist.illegalUpload.service.VehicleUtil;
@RestController
@RequestMapping("illegalUploadAction")
public class IllegalUploadAction {

	private Logger log = LoggerFactory.getLogger(IllegalUploadAction.class);
	private static final ReentrantLock LOCK = new ReentrantLock();

	@Autowired
	private QueryCarinfoService queryService;
	
	//六合一接口-查询车驾信息
	//map.put("hphm", "川K361C5");
	//map.put("hpzl", "02");
	@RequestMapping("queryCarInfo")
	public Vehicle queryCarInfo(@RequestBody Map<String,String> map){
		Vehicle ve = null;
		try
		{
		   ve = queryService.queryVechile(map);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ve;
	}
	
	//@RemotingInclude
	//@DoLog(value="违法数据上传-六合一接口-违法数据上传",type=LogType.UPDATE)
	@RequestMapping("uploadIllegal")
	public Map<String,String> uploadIllegal(Map<String,String> map1){
		String code = "error";
		String msg = "";
		try
		{
			LOCK.lock();
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("WFPK", map1.get("WFPK"));
			Tbloffeevdi t = checkOffedvi(map2);
			if(null!=t && (t.getSHBZ()==8 || t.getSHBZ()==9) && (t.getSHBZ()+"").equals(map1.get("SHBZ")))
			{
				VehicleUtil ve = new VehicleUtil();
				HashMap<String,String> map = new HashMap<String,String>();
				map.put("xh","");
				map.put("cjjg","511700000000");
				map.put("clfl", "3");
				map.put("hpzl", map1.get("HPZL"));
				String temp_hphm = map1.get("HPHM");
				if(null!=temp_hphm && !"".equals(temp_hphm)){
					if(temp_hphm.indexOf("学")!=-1 || temp_hphm.indexOf("挂")!=-1){
						temp_hphm = temp_hphm.substring(0, temp_hphm.length()-1);
					}
				}else{
					temp_hphm = "";
				}
				map.put("hphm",temp_hphm);
				map.put("jdcsyr",map1.get("JDCSYR"));
				map.put("syxz", map1.get("SYXZ"));
				map.put("fdjh", map1.get("FDJH"));
				map.put("clsbdh", map1.get("CLSBDH"));
				map.put("csys",map1.get("CSYS"));
				map.put("clpp", map1.get("CLPP1"));
				map.put("jtfs", map1.get("CLLX"));
				map.put("fzjg", map1.get("FZJG"));
				map.put("zsxzqh", "");
				map.put("zsxxdz", map1.get("ZSXXDZ"));
				map.put("dh", "");
				map.put("lxfs", "");
				map.put("tzsh", "");
				map.put("tzrq", null);
				map.put("cjfs", map1.get("SJLY"));
				map.put("wfsj",map1.get("WFSJ"));
				map.put("xzqh", map1.get("RESVE"));
				if(null!=map1.get("KKBH") && !"".equals(map1.get("KKBH"))){
					map.put("wfdd", map1.get("KKBH").substring(0, 5));
					map.put("lddm", map1.get("KKBH").substring(5, 9));
					map.put("ddms", map1.get("KKBH").substring(9, 12));
				}else{
					map.put("wfdd", "");
					map.put("lddm", "");
					map.put("ddms", "");
				}
				map.put("wfdz", map1.get("WFDD"));
				map.put("wfxw",map1.get("WFXW"));
				map.put("scz",map1.get("CLSD"));
				map.put("bzz",map1.get("BDSD"));
				map.put("zqmj","");
				map.put("spdz","");
				map.put("sbbh",map1.get("SBBH"));
				boolean isImgAsBase64 = true;
				String imgBase64 = null;
				Tbloffeevdi tbl = new Tbloffeevdi();
				if(null!=map1.get("WFZJ1") && !"".equals(map1.get("WFZJ1"))){
					imgBase64 = img2base64(map1.get("WFZJ1"));
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
				if(isImgAsBase64 && null!=map1.get("WFZJ2") && !"".equals(map1.get("WFZJ2"))){
					imgBase64 = img2base64(map1.get("WFZJ2"));
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
				if(isImgAsBase64 && null!=map1.get("WFZJ3") && !"".equals(map1.get("WFZJ3"))){
					imgBase64 = img2base64(map1.get("WFZJ3"));
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
				String str ="";
				tbl.setWFPK(Long.parseLong(map1.get("WFPK")));
				tbl.setHPHM(map1.get("HPHM"));
				tbl.setHPZL(map1.get("HPZL"));
				tbl.setWFXW(map1.get("WFXW"));
				tbl.setSHLC(map1.get("SHLC"));
				try
				{
					log.info("-----------违法数据手动上传开始-----------");
					String info = "违法数据主键=" +map1.get("WFPK") + "\r\n违法地点=" + map1.get("WFDD") + "\r\n违法行为="
							+ map1.get("WFXW") + "\r\n号牌号码=" + map1.get("HPHM") + "\r\n违法时间=" + map1.get("WFSJ") + "\r\n卡口编号="
							+ map1.get("KKBH") + "\r\n设备编号="+map1.get("SBBH")+"\r\n图片路径1="+map1.get("WFZJ1")+"\r\n图片路径2="+map1.get("WFZJ2")+"\r\n图片路径3="
							+map1.get("WFZJ3");
					log.info(info);
					if(isImgAsBase64 && "1".equals(map1.get("ECSCYY")))
					{
						str = ve.Uploadillage_wsh("viosurveil", map);
						if(null!=str && !"".equals(str)){
							code = getilldate(str,"<code>","</code>");
							String restr1 = getilldate(str,"<msg1>","</msg1>");//success
							String restr = getilldate(str,"<msg>","</msg>"); //failure
							tbl.setSCDM(restr);
							if("1".equals(code)){
								tbl.setSCDM(restr1+":"+restr);
								tbl.setSHBZ(7);
							}else{
								tbl.setSCDM(restr1+":"+restr);
								tbl.setSHBZ(8);
							}
						}else{
							tbl.setSHBZ(8);
							tbl.setSCDM("六合一无返回结果");
						}
					}
				}catch(Exception e){
					tbl.setSHBZ(8);
					tbl.setSCDM("手动上传违法数据至六合一时程序执行出错");
				}
				msg = tbl.getSCDM();
				log.info("数据上传结果="+tbl.getSCDM());
				log.info("-----------违法数据手动上传结束-----------");
				log.info("----------违法数据手动上传结果更新开始------------");
				try{
					if("2".equals(map1.get("ECSCYY"))){
						code = "1";
						tbl.setSHBZ(7);
					}
					/*service.updateOffEdv1(tbl);*/
				}catch(Exception e){
					log.info("违法数据手动上传结果更新出错",e.fillInStackTrace());
				}
			}else{
				if(null==t){
					code = "2";
				}else if(t.getSHBZ()==7){
					code = "3";
				}else if(!(t.getSHBZ()+"").equals(map1.get("SHBZ"))){
					code = "4" ;
				}else{
					code = "5";
				}
			}
		}catch(Exception e){
			log.info("手动上传程序报错");
		}finally{
			LOCK.unlock();
		}
		Map<String,String> result = new HashMap<String, String>();
		result.put("code", code);
		result.put("msg", msg);
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
		/*	tbl = service.checkOffedvi(map);*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return tbl;
	}
}
