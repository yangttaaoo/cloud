package com.cist.interfaceajk.controller;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cist.interfaceajk.model.SjgxInterfaces;
import com.cist.interfaceajk.model.Sjgxinterfaceconnect;
import com.cist.interfaceajk.service.PortsService;
import com.cist.utils.Timeutil;
/***
 * 接口调用监控
 * @author wt
 *
 */

@RestController
@RequestMapping("jkjk")
public class PortsController {
	
	@Autowired
	private PortsService portsService;
	@RequestMapping("face")
	public HashMap<String,Object> InterfaceTree() throws Exception{
		HashMap<String,Object> map=new HashMap<String, Object>();
		//接口总数
		List<SjgxInterfaces> sjgxInterfaces=portsService.listSjgxInterface();
		Integer zong=0;
		for (SjgxInterfaces sjgxInterfaces2 : sjgxInterfaces) {
			       if(sjgxInterfaces2.getInterface_enable_status().equals("0")) {//0未启用
			    	   zong=zong+1;
			       }
		}
		 NumberFormat numberFormat = NumberFormat.getInstance();   
		 numberFormat.setMaximumFractionDigits(2);   
		 String result = numberFormat.format((float)(sjgxInterfaces.size()-zong)/(float)sjgxInterfaces.size()*100);
		 map.put("result", result);
		 map.put("sjgxInterfaces", sjgxInterfaces);
		 map.put("sjgxInterfacecount", portsService.sjgxInterfacecount());
		 
		 //接口调用成功率
		 List<Sjgxinterfaceconnect> sjgxinterfaceconnect=portsService.sjgxinterfaceconnect();
		 Integer success=0;
		 for (Sjgxinterfaceconnect sjgxinterfaceconnect2 : sjgxinterfaceconnect) {
			  if(sjgxinterfaceconnect2.getConnect_status()==1) {
				  success=success+1;
			  }
		 }
		 //成功率
		 String connect = numberFormat.format((float)success/(float)sjgxinterfaceconnect.size()*100);
		 map.put("connect", connect);
		 //日环比
		int facez= portsService.sjgxinterfacez();//昨天成功率
		int facej= portsService.sjgxinterfacej();//今日成功率  
	    numberFormat.setMaximumFractionDigits(2);
	    if(facez!=0) {
	    	String annularratio = numberFormat.format(((float)facej-(float)facez)/facez*100);
	    	map.put("annularratio", annularratio);//日环比
	    }else {
	    	map.put("annularratio", 0);//日环比
	    }
	    //
	    int rtb=  portsService.sjgxinterfacertb();//日同比  去年的今天
	    if(facej!=0) {
	    	if(rtb==0) {
	    		 map.put("dayandday", 100);//日同比
	    	}else {
	    		  String dayandday = numberFormat.format(((float)facej-(float)rtb)/rtb*100);
	    		    map.put("dayandday", dayandday);//日同比
	    	}
	    }else {
	    	map.put("dayandday", 0);//日同比
	    }
	    //接口调用量（周） 总数
	    map.put("sjgxinterfacezong",portsService.sjgxinterfacezong());
	    //接口调用量（周） 每天
	    List<SjgxInterfaces> listfaces=portsService.listSjgxInterfaceweekday();
	    Integer fex=0;
	    for (SjgxInterfaces sjgxInterfaces2 : listfaces) {
	    	fex=fex+Integer.valueOf(sjgxInterfaces2.getCoun());
		}
	    NumberFormat numberFormats = NumberFormat.getInstance();   
	    numberFormats.setMaximumFractionDigits(2);   
	    String listSjgxInterfacedayc = numberFormats.format(((float)fex/(float)7));
	    map.put("listSjgxInterfacedayc",listSjgxInterfacedayc);//日均调用量
	    map.put("listSjgxInterfaceweekday",listfaces);//接口调用量（周） 每天
	    //接口调用总量（月）
	    Integer monthly=portsService.monthly();
	    map.put("monthly",monthly);//总数
	    String monthlydayc = numberFormats.format(((float)monthly/(float)Timeutil.getCurrentMonthDay()));//日均调用n 次
	    map.put("monthlydayc",monthlydayc);//日均调用量
	    //月环比
	    Integer monthlyshang=portsService.monthlyshang();
	    if(facez!=0) {
	    	String annularratio = numberFormat.format(((float)monthly-(float)monthlyshang)/monthlyshang*100);
	    	map.put("monthlyshang", annularratio);//日环比
	    }else {
	    	map.put("monthlyshang", 0);//日环比
	    }
	    //月同比
	    Integer monthlyshangyue=portsService.monthlyshangyue();
	    if(facez!=0) {
	    	String annularratio = numberFormat.format(((float)monthly-(float)monthlyshangyue)/monthlyshangyue*100);
	    	map.put("monthlyshangyue", annularratio);//日环比
	    }else {
	    	map.put("monthlyshangyue", 0);//日环比
	    }
	    //接口调用次数排名
	    map.put("numberOfranking",  portsService.numberOfranking(new HashMap<String, Object>()));
	    //接口调用 Top 5
	    List<String> listtime=new ArrayList<String>();
	    for(int i=0;i<7;i++) {
	    Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);  
	    Date today = calendar.getTime();  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    String resulttime = format.format(today);
	    listtime.add(resulttime);
	    }
	    List<SjgxInterfaces> listtop= portsService.numberOfrankingTop(new HashMap<String, Object>());
	    List<SjgxInterfaces> listvm=new ArrayList<SjgxInterfaces>();
	    List<SjgxInterfaces>  listsvquan=new ArrayList<SjgxInterfaces>();
	    for (String time : listtime) {//7天的时间
	    	SjgxInterfaces h=new SjgxInterfaces();
	    	h.setCreate_times(time);
	    	List<SjgxInterfaces>  listff=new ArrayList<SjgxInterfaces>();
			for (SjgxInterfaces sjgxInterfaces2 : listtop) {//排名前五的数据
				map.put("starttimes", time);
				map.put("interfaceids", sjgxInterfaces2.getInterface_id());
				SjgxInterfaces faces=new SjgxInterfaces();
				faces.setCoun(portsService.kingTop(map).toString());
				faces.setInterface_name(sjgxInterfaces2.getInterface_name());
				faces.setInterface_id(sjgxInterfaces2.getInterface_id());
				listff.add(faces);
				listsvquan.add(faces);
			}
			map.put("listff", listff);
			h.setFaces(listff);
			listvm.add(h);
		}
	    map.put("listsvquan", listsvquan);
	    map.put("listvm", listvm);
	    map.put("listtop", listtop);
		return map;
	}
	/***
	 * 接口调用次数排名
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("ranking")
	public HashMap<String,Object> ranking(@RequestBody HashMap<String,Object> map) throws Exception{
		map.put("numberOfranking",  portsService.numberOfranking(map));
		return map;
	}
	/***
	 *  接口调用 Top 5
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("Interfacecall")
	public HashMap<String,Object> Interfacecall(@RequestBody HashMap<String,Object> map) throws Exception{
		String data=map.get("data").toString();
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		if(data.equals("1")) {//今天
			map.put("starttime", dateFormat.format(date));
			map.put("endtime", dateFormat.format(date));
		}else if(data.equals("2")) {//本周
			map.put("starttime", dateFormat.format(Timeutil.getBeginDayOfWeek()));
			map.put("endtime", dateFormat.format(Timeutil.getEndDayOfWeek()));
		}else if(data.equals("3")) {//本月
			map.put("starttime", dateFormat.format(Timeutil.getBeginDayOfMonth()));
			map.put("endtime", dateFormat.format(Timeutil.getEndDayOfMonth()));
		}
	    List<String> listtime=new ArrayList<String>();
	    for(int i=0;i<7;i++) {
	    Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);  
	    Date today = calendar.getTime();  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    String resulttime = format.format(today);
	    listtime.add(resulttime);
	    }
	    List<SjgxInterfaces> listtop= portsService.numberOfrankingTop(map);
	    List<SjgxInterfaces> listvm=new ArrayList<SjgxInterfaces>();
	    List<SjgxInterfaces>  listsvquan=new ArrayList<SjgxInterfaces>();
	    for (String time : listtime) {//7天的时间
	    	SjgxInterfaces h=new SjgxInterfaces();
	    	h.setCreate_times(time);
	    	List<SjgxInterfaces>  listff=new ArrayList<SjgxInterfaces>();
			for (SjgxInterfaces sjgxInterfaces2 : listtop) {//排名前五的数据
				map.put("starttimes", time);
				map.put("interfaceids", sjgxInterfaces2.getInterface_id());
				SjgxInterfaces faces=new SjgxInterfaces();
				faces.setCoun(portsService.kingTop(map).toString());
				faces.setInterface_name(sjgxInterfaces2.getInterface_name());
				faces.setInterface_id(sjgxInterfaces2.getInterface_id());
				listff.add(faces);
				listsvquan.add(faces);
			}
			map.put("listff", listff);
			h.setFaces(listff);
			listvm.add(h);
		}
	    map.put("listsvquan", listsvquan);
	    map.put("listvm", listvm);
	    map.put("listtop", listtop);
		return map;
	}
}
