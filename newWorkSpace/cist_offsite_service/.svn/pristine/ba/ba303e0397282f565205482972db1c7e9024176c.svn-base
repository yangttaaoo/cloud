package com.cist.illegalUpload.service;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.cist.illegalUpload.domain.Vehicle;

@Service
public class QueryCarinfoService {
	
	/***
	 * 获取车辆信息
	 * @param map
	 * @return
	 */
	public Vehicle queryVechile(Map<String,String> map) {
		Vehicle i = new Vehicle();
		String hphm = map.get("hphm");
		if(null!=hphm&&!hphm.equals("")){
			if(hphm.substring(0,1).equals("川")){
				map.put("hphm", hphm.substring(1));
				map.put("hpzl", map.get("hpzl"));
			}else{
				return null;
			}
		}else{
			return null;
		}
		VehicleUtil vehicle = new VehicleUtil();
		String car_info = vehicle.search_car("QueryCondition", map);
		if(car_info != null &&!"".equals(car_info) && car_info.substring(car_info.indexOf("<code>")+6, car_info.indexOf("</code>")).equals("1") && car_info.substring(car_info.indexOf("<rownum>")+8, car_info.indexOf("</rownum>")).equals("1")){
			i.setZsxxdz(getilldate(car_info,"<zsxxdz>","</zsxxdz>"));
			i.setQzbfqzName(getilldate(car_info,"<qzbfqz>","</qzbfqz>"));
			i.setDwbh(getilldate(car_info,"<dwbh>","</dwbh>"));
			i.setYxqzName(getilldate(car_info,"<yxqz>","</yxqz>"));
			i.setZt(getilldate(car_info,"<zt>","</zt>"));//状态是编码 G
			i.setZtName(getCarZtName(i.getZt()));
			i.setClyt(getilldate(car_info,"<clyt>","</clyt>"));
			//-	i.setClytName(SysTempStoreUtils.getSysBaseCodeTempState(Constants.CAR_USE_AGE+Constants.JOIN+i.getClyt()));//用途 是编码 9
			i.setSyxz(getilldate(car_info,"<syxz>","</syxz>"));
			i.setSyxzName(getsyxz(i.getSyxz()));//使用性质 是编码 A
			//i.setSyxzName(SysTempStoreUtils.getSysBaseCodeTempState(Constants.CAR_USE_TYPE+Constants.JOIN+i.getSyxz()));//使用性质 是编码 A
			i.setClxhName(getilldate(car_info,"<clxh>","</clxh>"));//车辆型号 编码BJ7182VXL
			i.setClxh(getilldate(car_info,"<clxh>","</clxh>"));//车辆型号 编码BJ7182VXL
			i.setHpzl(getilldate(car_info,"<hpzl>","</hpzl>"));//号牌种类 编码 02
			i.setHpzlName(gethpzl_name(i.getHpzl()));
			i.setSfzmhm(getilldate(car_info,"<sfzmhm>","</sfzmhm>"));
			//i.setHpzlName(SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_PLATE_TYPE+Constants.JOIN+i.getHpzl()));//号牌种类 编码 02
			i.setCsys(getilldate(car_info,"<csys>","</csys>"));
			i.setCsysName(getcsys_name(i.getCsys())+"("+i.getCsys()+")");//车身颜色 编码J
			i.setCar_type_in(getilldate(car_info,"<clpp1>","</clpp1>"));//准载类型
			i.setCllx(getilldate(car_info,"<cllx>","</cllx>"));
		//-	i.setCllxName(SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_CAR_TYPE+Constants.JOIN+i.getCllx()));
			i.setLxdh(getilldate(car_info,"<sjhm>","</sjhm>"));
			i.setSyr(getilldate(car_info,"<syr>","</syr>"));
			i.setFzjg(getilldate(car_info,"<fzjg>","</fzjg>"));
			if(hphm.indexOf("挂") != -1)
			{
				i.setHphm(i.getFzjg().substring(0,1)+getilldate(car_info,"<hphm>","</hphm>")+"挂");
			}
			else if(hphm.indexOf("学") != -1){
				i.setHphm(i.getFzjg().substring(0,1)+getilldate(car_info,"<hphm>","</hphm>")+"学");
			}else{
				i.setHphm(i.getFzjg().substring(0,1)+getilldate(car_info,"<hphm>","</hphm>"));
			}
			i.setClpp1(getilldate(car_info,"<clpp1>","</clpp1>"));
			i.setCar_xml(car_info);
			return i;
		}else{
			return null;
		}
	}
	
	private String getCarZtName(String zt){
		String ztStr = "";
		if(null!=zt && !"".equals(zt)){
			if(zt.length()>1){
				for(int index=0;index<zt.length();index++){
					ztStr += getCarZt(zt.charAt(index)+"")+"-";
				}
				ztStr = ztStr.substring(0, ztStr.length()-1);
			}else{
				ztStr = getCarZt(zt);
			}
		}else{
			return "未知";
		}
		return ztStr;
	}
	
	private String getCarZt(String zt){
		String carzt = "";
		if(null!=zt && !"".equals(zt)){
			
			/**
			if("A".equals(zt)){
				carzt = "正常";
			}else if("B".equals(zt)){
				carzt = "转出";
			}else if("C".equals(zt)){
				carzt = "被盗抢";
			}else if("D".equals(zt)){
				carzt = "停驶";
			}else if("E".equals(zt)){
				carzt = "注销";
			}else if("G".equals(zt)){
				carzt = "违法未处理";
			}else if("H".equals(zt)){
				carzt = "海关监管";
			}else if("I".equals(zt)){
				carzt = "事故未处理";
			}else if("J".equals(zt)){
				carzt = "嫌疑车";
			}else if("K".equals(zt)){
				carzt = "查封";
			}else if("L".equals(zt)){
				carzt = "暂扣";
			}else if("M".equals(zt)){
				carzt = "强制注销";
			}else if("N".equals(zt)){
				carzt = "事故逃逸";
			}else if("O".equals(zt)){
				carzt = "锁定";
			}else{
				carzt = "未知";
			}
			**/
			//-	carzt = SysTempStoreUtils.getSysBaseCodeTempState(Constants.C_CAR_STATUS+Constants.JOIN+zt);
		}else{
			carzt = "未知";
		}
		return carzt;
	}
	
	private String getsyxz(String syxz){
		try {
			if(syxz != null && !"".equals(syxz)){
				/**
				if(syxz.equals("A")){
					return "非运营";
				}else if (syxz.equals("B")){
					return "公路客运";
				}else if (syxz.equals("C")){
					return "公交客运";
				}else if (syxz.equals("D")){
					return "出租客运";
				}else if (syxz.equals("E")){
					return "旅游客运";
				}else if (syxz.equals("F")){
					return "货运";
				}else if (syxz.equals("G")){
					return "租赁";
				}else if (syxz.equals("H")){
					return "警用";
				}else if (syxz.equals("I")){
					return "消防";
				}else if (syxz.equals("G")){
					return "救护";
				}else if (syxz.equals("K")){
					return "工程抢险";
				}else if (syxz.equals("L")){
					return "营转非";
				}else if (syxz.equals("M")){
					return "出租转非";
				}else if (syxz.equals("Z")){
					return "其他";
				}else{
					return "未知";
				}
				**/
				return "";//-	SysTempStoreUtils.getSysBaseCodeTempState(Constants.CAR_USE_TYPE+Constants.JOIN+syxz);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "未知";
	}
	private String gethpzl_name(String hpzl){
		try {
			/**
			switch (Integer.parseInt(hpzl)) {
			case 1:
				return "大型汽车号牌";
			case 99:
				return "其他号牌";
			case 2:
				return "小型汽车号牌";
			case 3:
				return "使馆汽车号牌";
			case 4:
				return "领馆汽车号牌";
			case 5:
				return "境外汽车号牌";
			case 6:
				return "外籍汽车号牌";
			case 7:
				return "两、三轮摩托车号牌";
			case 8:
				return "轻便摩托车号牌";
			case 9:
				return "使馆摩托车号牌";
			case 10:
				return "领馆摩托车号牌";
			case 11:
				return "境外摩托车号牌";
			case 12:
				return "外籍摩托车号牌 ";
			case 13:
				return "农用运输车号牌";
			case 14:
				return "拖拉机号牌";
			case 15:
				return "挂车号牌";
			case 16:
				return "教练汽车号牌";
			case 17:
				return "教练摩托车号牌";
			case 18:
				return "试验汽车号牌";
			case 19:
				return "试验摩托车号牌";
			case 20:
				return "临时人境汽车号牌";
			case 21:
				return "临时人境摩托车号牌";
			case 22:
				return "临时行驶车号牌 ";
			case 23:
				return "警用汽车号牌";
			case 24:
				return "警用摩托号牌 ";
			default:
				return "未知";
			}
			**/
			return "";//-	SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_PLATE_TYPE+Constants.JOIN+hpzl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "未知";
		}
	}
	private String getcsys_name(String csys){
		try {
			if(csys != null && !"".equals(csys)){
					String[] a = csys.split("");
					String csysname = "";
					for(int s= 0 ;s< a.length;s++){
						csysname = csysname+getcsys_name_(a[s]);
					}
					return csysname;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "未知";
		}
		return "未知";
	}
	private String getcsys_name_(String csys){
		try {
			if(csys != null && !"".equals(csys)){
				
				return "";//-	SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_CAR_COLOR+Constants.JOIN+csys);
				//return csys.equals("A")?"白":(csys.equals("B")?"灰":(csys.equals("C")?"黄":(csys.equals("D")?"粉":(csys.equals("E")?"红":(csys.equals("F")?"紫":(csys.equals("G")?"绿":(csys.equals("H")?"蓝":(csys.equals("I")?"棕":(csys.equals("J")?"黑":(csys.equals("Z")?"其他":""))))))))));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "";
		}
		return "";
	}
	private String getilldate(String car_in,String code,String _code){
		try {
			int l = code.length();
			if(car_in.indexOf(code)!= -1){
				return car_in.substring(car_in.indexOf(code)+l, car_in.indexOf(_code));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
}
