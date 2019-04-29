package com.cist.qwgl.qwpb.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.qwpb.model.DEPT;
import com.cist.qwgl.qwpb.model.QWGL_PBGL_CXCL;
import com.cist.qwgl.qwpb.model.QWGL_PBGL_PBINFO;
import com.cist.qwgl.qwpb.model.QWGL_POLICE_CAR;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_QWLX;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_QWQY;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_TJ;
import com.cist.qwgl.qwpb.model.QWGL_ZB_INFO;
import com.cist.qwgl.qwpb.model.SYS_POLICE_INFO;
import com.cist.qwgl.qwpb.model.VW_QWGL_PB_INFO;
import com.cist.qwgl.qwpb.model.ZB_Police;
import com.cist.qwgl.qwpb.service.QwpbService;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("pbgl")
public class QwpbController {
	@Autowired
	private QwpbService service;
	/**
	 * 查询排班信息
	 * @param map
	 * @return
	 */
	@RequestMapping("querypb")
	public PageInfo<QWGL_PBGL_PBINFO> querypb(@RequestBody HashMap<String,Object> map){
		PageInfo info = new PageInfo();
		if(map.get("currentPage")!=null){
			info.setPageNum( Integer.parseInt(map.get("currentPage").toString()) );
		}else{
			info.setPageNum(1);
		}
		if(map.get("pageSize")!=null){
			info.setPageSize(Integer.parseInt(map.get("pageSize").toString()) );
		}else{
			info.setPageSize(9);
		}
		PageInfo<QWGL_PBGL_PBINFO> pageinfo = (PageInfo<QWGL_PBGL_PBINFO>)service.querypbpageList(map, info);
		return pageinfo;
	}
	/**
	 * 添加排班信息
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addpb(@RequestBody HashMap<String,Object> map) {
		int count = 0 ;
		//值班领导
		String zbld =map.get("zbld").toString();
		if(zbld.length()>2) {
			zbld = zbld.substring(1, zbld.length()-1);
			if(zbld.indexOf(",")!=-1) {
				String[] str = zbld.split(",");
				String str1="";
				for (int i = 0; i < str.length; i++) {
					str1 = str1 + str[i]+",";
				}
				zbld=str1;
			}
			map.put("zbld", zbld.substring(0, zbld.length()-1));
		}else if (zbld.length()==2) {
			map.put("zbld", "");
		}
		//值班科长
		String zbkz =map.get("zbkz").toString();
		if(zbkz.length()>2) {
			zbkz = zbkz.substring(1, zbkz.length()-1);
			if(zbkz.indexOf(",")!=-1) {
				String[] str = zbkz.split(",");
				String str1="";
				for (int i = 0; i < str.length; i++) {
					str1 = str1 + str[i]+",";
				}
				zbkz=str1;
				map.put("zbkz", zbkz.substring(0, zbkz.length()-1));
			}else {
				map.put("zbkz",zbkz);
			}
			
		}else if (zbkz.length()==2) {
			map.put("zbkz", "");
		}
		//值班民警
		String zbmj = map.get("zbmj").toString();
		if (zbmj.length() > 2) {
			zbmj = zbmj.substring(1, zbmj.length() - 1);
			if (zbmj.indexOf(",") != -1) {
				String[] str = zbmj.split(",");
				String str1 = "";
				for (int i = 0; i < str.length; i++) {
					str1 = str1 + str[i]+",";
				}
				zbmj = str1;
				map.put("zbmj", zbmj.substring(0, zbmj.length()-1));
			}else {
				map.put("zbmj", zbmj);
			}
			
		} else if (zbmj.length() == 2) {
			map.put("zbmj", "");
		}
		// 值班协警
		String zbxj = map.get("zbxj").toString();
		if (zbxj.length() > 2) {
			zbxj = zbxj.substring(1, zbxj.length() - 1);
			if (zbxj.indexOf(",") != -1) {
				String[] str = zbxj.split(",");
				String str1 = "";
				for (int i = 0; i < str.length; i++) {
					str1 = str1 + str[i]+",";
				}
				zbxj = str1;
				map.put("zbxj", zbxj.substring(0, zbxj.length()-1));
			}else {
				map.put("zbxj", zbxj);
			}
			
		} else if (zbxj.length() == 2) {
			map.put("zbxj", "");
		}
		// 备用车辆
		String bycl = map.get("bycl").toString();
		if (bycl.length() > 2) {
			bycl = bycl.substring(1, bycl.length() - 1);
			if (bycl.indexOf(",") != -1) {
				String[] str = bycl.split(",");
				String str1 = "";
				for (int i = 0; i < str.length; i++) {
					str1 = str1 + str[i]+",";
				}
				bycl = str1;
				map.put("bycl", bycl.substring(0, bycl.length()-1));
			}else {
				map.put("bycl", bycl);
			}
			
		} else if (bycl.length() == 2) {
			map.put("bycl", "");
		}
		
		String str1=map.get("bc_pk").toString();
		if(str1.indexOf(",")==-1) {			
			if(str1.length()>2) {
				//只选择了一个班次
				map.put("bc_pk", str1.substring(1, str1.length()-1));
				 String[] kssj = map.get("kssj").toString().split(" ");
				 String[] jssj = map.get("jssj").toString().split(" ");
				List<Qwgl_bc_info> list = service.querysj(str1.substring(1, str1.length()-1));
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String bc_kssj =  sdf.format(list.get(0).getBc_kssj());
				 String[] bc_kssj1= bc_kssj.split(" ");
				 String pbkssj = kssj[0]+" "+bc_kssj1[1];	
				 String bc_jssj =  sdf.format(list.get(0).getBc_jssj());
				 String[] bc_jssj1= bc_jssj.split(" ");
				 String pbjssj = jssj[0]+" "+bc_jssj1[1];
				 map.put("kssj", pbkssj);
				 map.put("jssj", pbjssj);
				 count = service.addpb(map);
			}
		}else if(str1.indexOf(",")!=-1) {
			//选择了多个班次
			HashMap<String,Object> map1 = null;
			String[] str = str1.substring(1, str1.length()-1).split(",");
			for (int i = 0; i < str.length; i++) {
				map1 = map;
				map1.put("bc_pk", str[i]);
				 String[] kssj = map.get("kssj").toString().split(" ");
				 String[] jssj = map.get("jssj").toString().split(" ");
				List<Qwgl_bc_info> list = service.querysj(str[i]);
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String bc_kssj =  sdf.format(list.get(0).getBc_kssj());
				 String[] bc_kssj1= bc_kssj.split(" ");
				 String pbkssj = kssj[0]+" "+bc_kssj1[1];	
				 String bc_jssj =  sdf.format(list.get(0).getBc_jssj());
				 String[] bc_jssj1= bc_jssj.split(" ");
				 String pbjssj = jssj[0]+" "+bc_jssj1[1];
				 map1.put("kssj", pbkssj);
				 map1.put("jssj", pbjssj);
				if(service.addpb(map1)==1) {
					count++;
				}
			}
		}
		
		return count;
	}
	/**
	 * 查询值班领导
	 * @return
	 */
	@RequestMapping("queryzbld")
	public List<ZB_Police> queryzbld(){
		List<Integer> list = service.queryzbld();
		List<ZB_Police> list1 = service.queryld(list);
		return list1;
	}
	/**
	 * 查询值班科长
	 * @return
	 */
	@RequestMapping("queryzbkz")
	public List<ZB_Police> queryzbkz(){
		return service.queryzbkz();
	}
	
	/**
	 * 查询值班民警
	 * @return
	 */
	@RequestMapping("queryzbmj")
	public List<ZB_Police> queryzbmj(){
		return service.queryzbmj();
	}
	
	/**
	 * 查询值班协警
	 * @return
	 */
	@RequestMapping("queryzbxj")
	public List<ZB_Police> queryzbxj(){
		return service.queryzbxj();
	}
	/**
	 * 警车信息
	 * @param map
	 * @return
	 */
	@RequestMapping("querypolicecar")
	public List<QWGL_POLICE_CAR> querypolicecar(HashMap<String,Object> map){
		return service.querypolicecar(null);
	}
	/**
	 * 查询负责人
	 * @param map
	 * @return
	 */
	@RequestMapping("queryfzr")
	public List<ZB_Police> queryfzr(HashMap<String,Object> map){
		return service.queryfzr();
	}
	
	@RequestMapping("addjmqw")
	public Integer addjmqw(@RequestBody HashMap<String,Object> map) {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		int count = 0;
		//车巡信息
		List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) map.get("xc");
		for (int i = 0; i < list.size(); i++) {
			String fzr = list.get(i).get("fzr").toString();
			String zqmj = list.get(i).get("zqmj").toString();
			String zqxj = list.get(i).get("zqxj").toString();
			if(fzr.length()>2) {
				list.get(i).put("fzr", fzr.substring(1, fzr.length()-1));
			}else {
				list.get(i).put("fzr", "");
			}
			if(zqmj.length()>2) {
				list.get(i).put("zqmj",zqmj.substring(1, zqmj.length()-1));
			}else {
				list.get(i).put("zqmj","");
			}
			if(zqxj.length()>2) {
				list.get(i).put("zqxj",zqxj.substring(1, zqxj.length()-1));
			}else {
				list.get(i).put("zqxj","");
			}
			list.get(i).put("cx",uuid);
			HashMap<String, Object> m = list.get(i);
			int k = service.addcx(m);
			if(k==1) {
				count++;
			}
		}
		//添加装备
		List<HashMap<String,Object>> zb = (List<HashMap<String,Object>>) map.get("zb");
		for(int j = 0 ;j<zb.size();j++) {
			HashMap<String,Object> map2 =zb.get(j);
			zb.get(j).put("qwbb", uuid);
			int l = service.addzbbb(map2);
			if(l==1) {
				count++;
			}
		}
		//街面勤务报备
		HashMap<String, Object> map1 = (HashMap<String, Object>)map.get("pb");
		map1.put("car_pk", uuid);
		String bc_pk = map1.get("bc_pk").toString();
		String bxfzr = map1.get("bxfzr").toString();
		String zqmj = map1.get("zqmj").toString();
		String zqxj = map1.get("zqxj").toString();
		String hh = map1.get("hh").toString();
		map1.put("zbbb", uuid);
		map1.put("cx", uuid);
		if(hh.length()>2) {
			map1.put("hh", hh.substring(1, hh.length()-1));
		}else {
			map1.put("hh", "");
		}
		if(bxfzr.length()>2) {
			map1.put("bxfzr", bxfzr.substring(1, bxfzr.length()-1));
		}else {
			map1.put("bxfzr", "");
		}
		if(zqmj.length()>2) {
			map1.put("zqmj", zqmj.substring(1, zqmj.length()-1));
		}else {
			map1.put("zqmj", "");
		}
		if(zqxj.length()>2) {
			map1.put("zqxj", zqxj.substring(1, zqxj.length()-1));
		}else {
			map1.put("zqxj", "");
		}
		
		if(bc_pk.length()>2) {
			bc_pk = bc_pk.substring(1, bc_pk.length()-1);
			if(bc_pk.indexOf(",")!=-1) {
				String[] str = bc_pk.split(",");
				for(int i=0;i<str.length;i++) {
					map1.put("bc_pk", str[i]);
					 String[] kssj = map1.get("kssj").toString().split(" ");
					 String[] jssj = map1.get("jssj").toString().split(" ");
					List<Qwgl_bc_info> list1 = service.querysj(str[i]);
					 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
					 String bc_kssj =  sdf.format(list1.get(0).getBc_kssj());
					 String[] bc_kssj1= bc_kssj.split(" ");
					 String pbkssj = kssj[0]+" "+bc_kssj1[1];	
					 String bc_jssj =  sdf.format(list1.get(0).getBc_jssj());
					 String[] bc_jssj1= bc_jssj.split(" ");
					 String pbjssj = jssj[0]+" "+bc_jssj1[1];
					 map1.put("kssj", pbkssj);
					 map1.put("jssj", pbjssj);
					//添加
					int k = service.addpb(map1);
					if(k==1) {
						count++;
					}
				}
			}else {
				map1.put("bc_pk", bc_pk);
				String ks = map1.get("kssj").toString();
				String js = map1.get("jssj").toString();
				 String[] kssj = ks.split(" ");
				 String[] jssj = js.split(" ");
				List<Qwgl_bc_info> list1 = service.querysj(bc_pk);
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				 String bc_kssj =  sdf.format(list1.get(0).getBc_kssj());
				 String[] bc_kssj1= bc_kssj.split(" ");
				 String pbkssj = kssj[0]+" "+bc_kssj1[1];	
				 String bc_jssj =  sdf.format(list1.get(0).getBc_jssj());
				 String[] bc_jssj1= bc_jssj.split(" ");
				 String pbjssj = jssj[0]+" "+bc_jssj1[1];
				 map1.put("kssj", pbkssj);
				 map1.put("jssj", pbjssj);
				//添加
				int k = service.addpb(map1);
				if(k==1) {
					count++;
				}
			}
			
		}else {
			
		}
		return count;
	}
	/**
	 * 根据id查询号牌号码
	 * @param map
	 * @return
	 */
	@RequestMapping("queryhphm")
	public List<QWGL_POLICE_CAR> queryhphm(@RequestBody HashMap<String,Object> map) {
		String sypi_pk = map.get("sypi_pk").toString();
		String[] str =  sypi_pk.substring(1, sypi_pk.length()-1).split(",");
		map.put("sypi_pk", str);
		List<QWGL_POLICE_CAR> zb = service.queryhphm(map);
		return zb;
	}
	/**
	 * 查询所有呼号
	 * @return
	 */
	@RequestMapping("queryhh")
	public List<SYS_POLICE_INFO> queryhh(){
		return service.queryhh();
	}
	@RequestMapping("queryzbinfo")
	public List<QWGL_ZB_INFO> queryzbinfo(@RequestBody HashMap<String,Object> map){
		return service.queryzbinfo(map);
	}
	@RequestMapping("queryzb")
	public List<QWGL_ZB_INFO> queryzb(@RequestBody HashMap<String,Object> map){
		String zb_pk = map.get("zb_pk").toString();
		String[] str =  zb_pk.substring(1, zb_pk.length()-1).split(",");
		map.put("zb_pk", str);
		return service.queryzb(map);
	}
	/**
	 * 报表
	 * @param map
	 * @throws ParseException
	 */
	@RequestMapping("querybb")
	public List<QWGL_QWPB_TJ> querybb(@RequestBody HashMap<String,Object> map) throws ParseException {
		Date kssj=null;
		Date jssj=null;
		int rownum = 0;
		int rownum1 = 0;
		int rownum2 = 0;
		if(map.get("kssj")!=null && map.get("kssj")!="" && map.get("jssj") !=null && map.get("jssj")!="") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ks = map.get("kssj").toString();
			String js = map.get("jssj").toString();
			kssj = sdf.parse(ks);
			jssj = sdf.parse(js);
		}else {
			kssj = service.queryminsj(map);
			jssj = service.querymaxsj(map);
		}
		Calendar canlandar1 = Calendar.getInstance();//开始时间
		Calendar canlandar2 = Calendar.getInstance();//结束时间
		Calendar canlandar3 = Calendar.getInstance();
		Calendar canlandar4 = Calendar.getInstance();
		canlandar1.setTime(kssj);
		canlandar2.setTime(jssj);
		List<Date> returnList = new ArrayList<Date>();
		while(canlandar1.compareTo(canlandar2) < 1){
		  returnList.add(canlandar1.getTime());
		  canlandar1.add(canlandar1.DATE, 1);//每次循环增加一天
		}
		List<String> rylist = null;
		List<QWGL_QWPB_TJ> list1 = new ArrayList<QWGL_QWPB_TJ>();
		QWGL_QWPB_TJ tj = null;
		HashMap<String,Object> map1 = map;
		List<VW_QWGL_PB_INFO> list=null;
		for (int i = 0; i < returnList.size(); i++) {
			
			tj = new QWGL_QWPB_TJ();
			map1.put("sj", returnList.get(i));
			list = service.querytj(map1);
			List<DEPT> deptlist = service.querydeptname(map1);
			List<QWGL_QWPB_QWLX> qwlxlist = null;
			HashMap<String,Object> map2 = null;
			HashMap<String,Object> map3 = null;
			for (int j = 0; j < deptlist.size(); j++) {
				map2 = map1;
				qwlxlist = new ArrayList<QWGL_QWPB_QWLX>();
				QWGL_QWPB_QWLX qwlx = new QWGL_QWPB_QWLX();
				QWGL_QWPB_QWLX qwlx1 = new QWGL_QWPB_QWLX();
				qwlx.setQw_name("值班值守");
				map2.put("qw_name", "值班值守");
				List<QWGL_QWPB_QWQY> qwqylist = service.queryqwqy(map2);
				if(qwqylist!=null) {
					for (int k = 0; k < qwqylist.size(); k++) {
						map2.put("qw_qy", qwqylist.get(k).getQw_qy());
						List<VW_QWGL_PB_INFO> pbinfolist = service.querytj(map2);
						List<String> sj = new ArrayList<String>();
						//统计警员、车辆
						for (int l = 0; l < pbinfolist.size(); l++) {
							canlandar4.setTime(pbinfolist.get(l).getKssj());
							String ks = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							canlandar4.setTime(pbinfolist.get(l).getJssj());
							String js = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							String bc =pbinfolist.get(l).getBc_name()+"("+ks
									+"-"+js+")";
							if(sj.indexOf(bc)==-1) {
								sj.add(bc);
							}
							
							map3 = new HashMap<String,Object>();
							//统计民警姓名及人数
							if(pbinfolist.get(l).getZbmj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZbmj().split(","));
								String pname = service.querypolice(map3);
								if(pname!=null) {
									qwqylist.get(k).setMj_name(pname);
									qwqylist.get(k).setMj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getZbxj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZbxj().split(","));
								String pname = service.querypolice(map3);
								if(pname!=null) {
									qwqylist.get(k).setXj_name(pname);
									qwqylist.get(k).setXj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getCx()!=null) {
								map3.put("cx", pbinfolist.get(l).getCx());
								String cxmj = service.querycxmj(map3);
								if(cxmj!=null) {
									map3.put("sypi_pk", cxmj.split(","));	
									String cxmjname = service.querypolice(map3);
									if(qwqylist.get(k).getMj_name()!=null) {
										qwqylist.get(k).setMj_name(qwqylist.get(k).getMj_name()+","+cxmjname);
										int a = qwqylist.get(k).getMj_num()+cxmjname.split(",").length;
										qwqylist.get(k).setMj_num(a);
									}else {
										qwqylist.get(k).setMj_name(cxmjname);
										if(cxmjname==null) {
											qwqylist.get(k).setMj_num(0);
										}else {
											qwqylist.get(k).setMj_num(cxmjname.split(",").length);
										}
										
									}
								}
								String cxxj = service.querycxxj(map3);
								if(cxxj!=null) {
									map3.put("sypi_pk", cxxj.split(","));	
									String cxxjname = service.querypolice(map3);
									if(qwqylist.get(k).getXj_name()!=null) {
										qwqylist.get(k).setXj_name(qwqylist.get(k).getXj_name()+","+cxxjname);
										int a = qwqylist.get(k).getXj_num()+cxxjname.split(",").length;
										qwqylist.get(k).setXj_num(a);
									}else {
										qwqylist.get(k).setXj_name(cxxjname);
										if(cxxjname==null) {
											qwqylist.get(k).setXj_num(0);
										}else {
											qwqylist.get(k).setXj_num(cxxjname.split(",").length);
										}
										
									}
								}
								String cxhphm = service.querycxhphm(map3);
								qwqylist.get(k).setCl_hphm(cxhphm);
								qwqylist.get(k).setCl_num(cxhphm.split(",").length);
							}
						
						}
						rownum2++;
						rownum++;
						rownum1++;
						qwqylist.get(k).setSj(sj);
					}
					qwlx.setQw_qy(qwqylist);
					qwlx.setRownum(rownum2);
					qwlxlist.add(qwlx);
					rownum2=0;
					
				}

				
				
				
				
				qwlx1.setQw_name("街面勤务");
				map2.put("qw_name", "街面勤务");
				List<QWGL_QWPB_QWQY> qwqylist1 = service.queryqwqy(map2);
				if(qwqylist1!=null) {
					List<String> sj = new ArrayList<String>();
					for (int k = 0; k < qwqylist1.size(); k++) {
						map2.put("qw_qy", qwqylist1.get(k).getQw_qy());
						List<VW_QWGL_PB_INFO> pbinfolist = service.querytj(map2);
						//统计警员、车辆
						for (int l = 0; l < pbinfolist.size(); l++) {
							canlandar4.setTime(pbinfolist.get(l).getKssj());
							String ks = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							canlandar4.setTime(pbinfolist.get(l).getJssj());
							String js = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							String bc =pbinfolist.get(l).getBc_name()+"("+ks
									+"-"+js+")";
							if(sj.indexOf(bc)==-1) {
								sj.add(bc);
							}
							map3 = new HashMap<String,Object>();
							//统计民警姓名及人数
							if(pbinfolist.get(l).getZqmj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZqmj().split(","));
								String pname = service.querypolice(map3);
									qwqylist1.get(k).setMj_name(pname);
									if(pname==null) {
										qwqylist1.get(k).setMj_num(0);
									}else {
										qwqylist1.get(k).setMj_num(pname.split(",").length);
									}
									
								
							}
							if(pbinfolist.get(l).getZqxj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZqxj().split(","));
								String pname = service.querypolice(map3);
								qwqylist1.get(k).setXj_name(pname);
								if(pname==null) {
									qwqylist1.get(k).setXj_num(0);
								}else {
									qwqylist1.get(k).setXj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getCx()!=null) {
								map3.put("cx", pbinfolist.get(l).getCx());
								String cxmj = service.querycxmj(map3);
								if(cxmj!=null) {
									map3.put("sypi_pk", cxmj.split(","));	
									String cxmjname = service.querypolice(map3);
									if(qwqylist1.get(k).getMj_name()!=null) {
										String str = qwqylist1.get(k).getMj_name()+","+cxmjname;
										String[] str1 = str.split(",");
										rylist = new ArrayList<>();
										for (int m = 0; m < str1.length; m++) {
											if(rylist.indexOf(str1[m])==-1) {
												rylist.add(str1[m]);
											}
										}
										
										String str2 = rylist.toString();
										qwqylist1.get(k).setMj_name(str2.substring(1, str2.length()-1));
										int a = str2.split(",").length;
										qwqylist1.get(k).setMj_num(a);
									}else {
										qwqylist1.get(k).setMj_name(cxmjname);
										if(cxmjname==null) {
											qwqylist1.get(k).setMj_num(0);	
										}else {
											qwqylist1.get(k).setMj_num(cxmjname.split(",").length);
										}
									}
								}
								String cxxj = service.querycxxj(map3);
								if(cxxj!=null) {
									map3.put("sypi_pk", cxxj.split(","));	
									String cxxjname = service.querypolice(map3);
									if(qwqylist1.get(k).getXj_name()!=null) {
										String str = qwqylist1.get(k).getXj_name()+","+cxxjname;
										String[] str1 = str.split(",");
										rylist = new ArrayList<>();
										for (int m = 0; m < str1.length; m++) {
											if(rylist.indexOf(str1[m])==-1) {
												rylist.add(str1[m]);
											}
										}
										
										String str2 = rylist.toString();
										qwqylist1.get(k).setXj_name(str2.substring(1, str2.length()-1));
										int a = str2.split(",").length;
										qwqylist1.get(k).setXj_num(a);
									}else {
										qwqylist1.get(k).setXj_name(cxxjname);
										if(cxxjname==null) {
											qwqylist1.get(k).setXj_num(0);
										}else {
											qwqylist1.get(k).setXj_num(cxxjname.split(",").length);
										}
									}
								}
								String cxhphm = service.querycxhphm(map3);
								qwqylist1.get(k).setCl_hphm(cxhphm);
								if(cxhphm==null) {
									qwqylist1.get(k).setCl_num(0);
								}else {
									qwqylist1.get(k).setCl_num(cxhphm.split(",").length);
								}
								
							}
						
						}
						rownum2++;
						rownum++;
						rownum1++;
						qwqylist1.get(k).setSj(sj);
					}
					qwlxlist.add(qwlx1);
					qwlx1.setQw_qy(qwqylist1);
					qwlx1.setRownum(rownum2);
					deptlist.get(j).setQw_name(qwlxlist);
					rownum2=0;
					
				}
				
				deptlist.get(j).setRownum(rownum1);
				rownum1=0;
			}
			
			canlandar3.setTime(returnList.get(i));
			tj.setSj(canlandar3.get(canlandar3.YEAR)+"-"+(canlandar3.get(Calendar.MONTH)+1)+"-"+canlandar3.get(Calendar.DAY_OF_MONTH));
			tj.setDept(deptlist);
			if(rownum!=0) {
				tj.setRownum(rownum);
				list1.add(tj);	
			}
			rownum=0;
		}
		return list1;
	}
	/**
	 * 导出excel表格
	 * @param map
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@RequestMapping("excel")
	public void export(@RequestParam HashMap<String,Object> map,HttpServletResponse response) throws IOException, ParseException {
		Date kssj=null;
		Date jssj=null;
		int rownum = 0;
		int rownum1 = 0;
		int rownum2 = 0;
		if(map.get("kssj")!=null && map.get("kssj")!="" && map.get("jssj") !=null && map.get("jssj")!="") {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String ks = map.get("kssj").toString();
			String js = map.get("jssj").toString();
			kssj = sdf.parse(ks);
			jssj = sdf.parse(js);
		}else {
			kssj = service.queryminsj(map);
			jssj = service.querymaxsj(map);
		}
		Calendar canlandar1 = Calendar.getInstance();//开始时间
		Calendar canlandar2 = Calendar.getInstance();//结束时间
		Calendar canlandar3 = Calendar.getInstance();
		Calendar canlandar4 = Calendar.getInstance();
		canlandar1.setTime(kssj);
		canlandar2.setTime(jssj);
		List<Date> returnList = new ArrayList<Date>();
		while(canlandar1.compareTo(canlandar2) < 1){
		  returnList.add(canlandar1.getTime());
		  canlandar1.add(canlandar1.DATE, 1);//每次循环增加一天
		}
		List<String> rylist = null;
		List<QWGL_QWPB_TJ> list1 = new ArrayList<QWGL_QWPB_TJ>();
		QWGL_QWPB_TJ tj = null;
		HashMap<String,Object> map1 = map;
		List<VW_QWGL_PB_INFO> list=null;
		for (int i = 0; i < returnList.size(); i++) {
			
			tj = new QWGL_QWPB_TJ();
			map1.put("sj", returnList.get(i));
			list = service.querytj(map1);
			List<DEPT> deptlist = service.querydeptname(map1);
			List<QWGL_QWPB_QWLX> qwlxlist = null;
			HashMap<String,Object> map2 = null;
			HashMap<String,Object> map3 = null;
			for (int j = 0; j < deptlist.size(); j++) {
				map2 = map1;
				qwlxlist = new ArrayList<QWGL_QWPB_QWLX>();
				QWGL_QWPB_QWLX qwlx = new QWGL_QWPB_QWLX();
				QWGL_QWPB_QWLX qwlx1 = new QWGL_QWPB_QWLX();
				qwlx.setQw_name("值班值守");
				map2.put("qw_name", "值班值守");
				List<QWGL_QWPB_QWQY> qwqylist = service.queryqwqy(map2);
				if(qwqylist!=null) {
					for (int k = 0; k < qwqylist.size(); k++) {
						map2.put("qw_qy", qwqylist.get(k).getQw_qy());
						List<VW_QWGL_PB_INFO> pbinfolist = service.querytj(map2);
						List<String> sj = new ArrayList<String>();
						//统计警员、车辆
						for (int l = 0; l < pbinfolist.size(); l++) {
							canlandar4.setTime(pbinfolist.get(l).getKssj());
							String ks = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							canlandar4.setTime(pbinfolist.get(l).getJssj());
							String js = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							String bc =pbinfolist.get(l).getBc_name()+"("+ks
									+"-"+js+")";
							if(sj.indexOf(bc)==-1) {
								sj.add(bc);
							}
							
							map3 = new HashMap<String,Object>();
							//统计民警姓名及人数
							if(pbinfolist.get(l).getZbmj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZbmj().split(","));
								String pname = service.querypolice(map3);
								if(pname!=null) {
									qwqylist.get(k).setMj_name(pname);
									qwqylist.get(k).setMj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getZbxj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZbxj().split(","));
								String pname = service.querypolice(map3);
								if(pname!=null) {
									qwqylist.get(k).setXj_name(pname);
									qwqylist.get(k).setXj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getCx()!=null) {
								map3.put("cx", pbinfolist.get(l).getCx());
								String cxmj = service.querycxmj(map3);
								if(cxmj!=null) {
									map3.put("sypi_pk", cxmj.split(","));	
									String cxmjname = service.querypolice(map3);
									if(qwqylist.get(k).getMj_name()!=null) {
										qwqylist.get(k).setMj_name(qwqylist.get(k).getMj_name()+","+cxmjname);
										int a = qwqylist.get(k).getMj_num()+cxmjname.split(",").length;
										qwqylist.get(k).setMj_num(a);
									}else {
										qwqylist.get(k).setMj_name(cxmjname);
										if(cxmjname==null) {
											qwqylist.get(k).setMj_num(0);
										}else {
											qwqylist.get(k).setMj_num(cxmjname.split(",").length);	
										}
										
									}
								}
								String cxxj = service.querycxxj(map3);
								if(cxxj!=null) {
									map3.put("sypi_pk", cxxj.split(","));	
									String cxxjname = service.querypolice(map3);
									if(qwqylist.get(k).getXj_name()!=null) {
										qwqylist.get(k).setXj_name(qwqylist.get(k).getXj_name()+","+cxxjname);
										int a = qwqylist.get(k).getXj_num()+cxxjname.split(",").length;
										qwqylist.get(k).setXj_num(a);
									}else {
										qwqylist.get(k).setXj_name(cxxjname);
										if(cxxjname==null) {
											qwqylist.get(k).setXj_num(0);
										}else {
											qwqylist.get(k).setXj_num(cxxjname.split(",").length);
										}
									}
								}
								String cxhphm = service.querycxhphm(map3);
								qwqylist.get(k).setCl_hphm(cxhphm);
								if(cxhphm==null) {
									qwqylist.get(k).setCl_num(0);
								}else {
									qwqylist.get(k).setCl_num(cxhphm.split(",").length);
								}
							}
							
						}
						rownum2++;
						rownum++;
						rownum1++;
						qwqylist.get(k).setSj(sj);
					}
					qwlx.setQw_qy(qwqylist);
					qwlx.setRownum(rownum2);
					qwlxlist.add(qwlx);
					rownum2=0;
					
				}

				
				
				
				
				qwlx1.setQw_name("街面勤务");
				map2.put("qw_name", "街面勤务");
				List<QWGL_QWPB_QWQY> qwqylist1 = service.queryqwqy(map2);
				if(qwqylist1!=null) {
					List<String> sj = new ArrayList<String>();
					for (int k = 0; k < qwqylist1.size(); k++) {
						map2.put("qw_qy", qwqylist1.get(k).getQw_qy());
						List<VW_QWGL_PB_INFO> pbinfolist = service.querytj(map2);
						//统计警员、车辆
						for (int l = 0; l < pbinfolist.size(); l++) {
							canlandar4.setTime(pbinfolist.get(l).getKssj());
							String ks = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							canlandar4.setTime(pbinfolist.get(l).getJssj());
							String js = canlandar4.get(Calendar.HOUR_OF_DAY)+":"+canlandar4.get(Calendar.MINUTE);
							String bc =pbinfolist.get(l).getBc_name()+"("+ks
									+"-"+js+")";
							if(sj.indexOf(bc)==-1) {
								sj.add(bc);
							}
							map3 = new HashMap<String,Object>();
							//统计民警姓名及人数
							if(pbinfolist.get(l).getZqmj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZqmj().split(","));
								String pname = service.querypolice(map3);
								qwqylist1.get(k).setMj_name(pname);
								if(pname==null) {
									qwqylist1.get(k).setMj_num(0);
								}else {
									qwqylist1.get(k).setMj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getZqxj()!=null) {
								map3.put("sypi_pk", pbinfolist.get(l).getZqxj().split(","));
								String pname = service.querypolice(map3);
								qwqylist1.get(k).setXj_name(pname);
								if(pname==null) {
									qwqylist1.get(k).setXj_num(0);
								}else {
									qwqylist1.get(k).setXj_num(pname.split(",").length);
								}
							}
							if(pbinfolist.get(l).getCx()!=null) {
								map3.put("cx", pbinfolist.get(l).getCx());
								String cxmj = service.querycxmj(map3);
								if(cxmj!=null) {
									map3.put("sypi_pk", cxmj.split(","));	
									String cxmjname = service.querypolice(map3);
									if(qwqylist1.get(k).getMj_name()!=null) {
										String str = qwqylist1.get(k).getMj_name()+","+cxmjname;
										String[] str1 = str.split(",");
										rylist = new ArrayList<>();
										for (int m = 0; m < str1.length; m++) {
											if(rylist.indexOf(str1[m])==-1) {
												rylist.add(str1[m]);
											}
										}
										
										String str2 = rylist.toString();
										qwqylist1.get(k).setMj_name(str2.substring(1, str2.length()-1));
										int a = str2.split(",").length;
										qwqylist1.get(k).setMj_num(a);
									}else {
										qwqylist1.get(k).setMj_name(cxmjname);
										if(cxmjname==null) {
											qwqylist1.get(k).setMj_num(0);
										}else {
											qwqylist1.get(k).setMj_num(cxmjname.split(",").length);
										}
									}
								}
								String cxxj = service.querycxxj(map3);
								if(cxxj!=null) {
									map3.put("sypi_pk", cxxj.split(","));	
									String cxxjname = service.querypolice(map3);
									if(qwqylist1.get(k).getXj_name()!=null) {
										String str = qwqylist1.get(k).getXj_name()+","+cxxjname;
										String[] str1 = str.split(",");
										rylist = new ArrayList<>();
										for (int m = 0; m < str1.length; m++) {
											if(rylist.indexOf(str1[m])==-1) {
												rylist.add(str1[m]);
											}
										}
										
										String str2 = rylist.toString();
										qwqylist1.get(k).setXj_name(str2.substring(1, str2.length()-1));
										int a = str2.split(",").length;
										qwqylist1.get(k).setXj_num(a);
									}else {
										qwqylist1.get(k).setXj_name(cxxjname);
										if(cxxjname==null) {
											qwqylist1.get(k).setXj_num(0);
										}else {
											qwqylist1.get(k).setXj_num(cxxjname.split(",").length);
										}
										
									}
								}
								String cxhphm = service.querycxhphm(map3);
								qwqylist1.get(k).setCl_hphm(cxhphm);
								if(cxhphm==null) {
									qwqylist1.get(k).setCl_num(0);
								}else {
									qwqylist1.get(k).setCl_num(cxhphm.split(",").length);
								}
							}
							
						}
						rownum2++;
						rownum++;
						rownum1++;
						qwqylist1.get(k).setSj(sj);
					}
					qwlxlist.add(qwlx1);
					qwlx1.setQw_qy(qwqylist1);
					qwlx1.setRownum(rownum2);
					deptlist.get(j).setQw_name(qwlxlist);
					rownum2=0;
					
				}
				
				deptlist.get(j).setRownum(rownum1);
				rownum1=0;
			}
			
			canlandar3.setTime(returnList.get(i));
			tj.setSj(canlandar3.get(canlandar3.YEAR)+"-"+(canlandar3.get(Calendar.MONTH)+1)+"-"+canlandar3.get(Calendar.DAY_OF_MONTH));
			tj.setDept(deptlist);
			if(rownum!=0) {
				tj.setRownum(rownum);
				list1.add(tj);	
			}
			rownum=0;
		}	
		
		// 声明一个工作簿
        HSSFWorkbook wb = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = wb.createSheet("勤务排版表");
        // 生成一种样式
        HSSFCellStyle style = wb.createCellStyle();
        
        style.setAlignment(HorizontalAlignment.CENTER);//居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        
        // 生成一种字体
        HSSFFont font = wb.createFont();
        // 设置字体
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 字体加粗
        font.setBold(true);
        // 在样式中引用这种字体
        style.setFont(font);
        
        HSSFCellStyle style2 = wb.createCellStyle();
        HSSFFont font2 = wb.createFont();
        // 设置字体
        font2.setFontName("微软雅黑");
        // 设置字体大小
        font2.setFontHeightInPoints((short) 12);
        style2.setAlignment(HorizontalAlignment.CENTER);//居中
        style2.setVerticalAlignment(VerticalAlignment.CENTER);//垂直
        style2.setWrapText(true); 
        
        // 在样式2中引用这种字体
        style2.setFont(font2);
        String[] excelHeader = {"日期","部门","勤务类型","勤务区域","时间","人员"};
        //表头
        HSSFRow row = sheet.createRow(0);
        for (int k = 0; k < excelHeader.length; k++) {
        	sheet.autoSizeColumn(k, true);// 根据字段长度自动调整列的宽度
            HSSFCell cell = row.createCell(k);
            cell.setCellValue(excelHeader[k]);
            cell.setCellStyle(style);
		}
        
        //具体数据
        //循环数据第一列
        int count = 1;
        for (int n = 0; n < list1.size(); n++) {
      /*  	List<DEPT>  dept = list1.get(n).getDept();*/
        	//循环数据第二列
        	for (int i = 0; i < list1.get(n).getDept().size(); i++) {
        		//循环数据第三列
				for (int k = 0; k < list1.get(n).getDept().get(i).getQw_name().size(); k++) {
					//循环数据第四列
					for (int k2 = 0; k2 < list1.get(n).getDept().get(i).getQw_name().get(k).getQw_qy().size(); k2++) {
						//创建行
						row = sheet.createRow(count);
						count++;
						int rows=0;
						//创建列
						if(i==0&&k==0&&k2==0) {
							rows=6;
						}else if(list1.get(n).getDept().get(i).getRownum()==1&&i==0) {
							rows=6;
						}else if(list1.get(n).getDept().get(i).getRownum()==1&&i!=0){
							rows=5;
						}else if(k2==0&&k==0&&i!=0){
							rows=5;
						}else if(k2==0&&i!=0&&k==0) {
							rows=5;
						}else if((i==0&&k!=0&&k2==0)||(i!=0&&k==0&&k2==0)||(i==0&&k!=0&&k2==0)||(i!=0&&k!=0&&k2==0)) {
							rows=4;
						}else {
							rows=3;
						}
						String cellvalue = "";
						
						for (int l = 6-rows; l < 6; l++) {
							if(l==0) {
								cellvalue=list1.get(n).getSj();
							}else if(l==1) {
								cellvalue=list1.get(n).getDept().get(i).getDept_name();
							}else if(l==2) {
								cellvalue=list1.get(n).getDept().get(i).getQw_name().get(k).getQw_name();
							}else if(l==3) {
								cellvalue=list1.get(n).getDept().get(i).getQw_name().get(k).getQw_qy().get(k2).getQw_qy();
							}else if(l==4) {
								List<String> sjlist=list1.get(n).getDept().get(i).getQw_name().get(k).getQw_qy().get(k2).getSj();
								for (int j = 0; j < sjlist.size(); j++) {
									cellvalue+=sjlist.get(j)+"\r\n";
								}
							}else if(l==5) {
								QWGL_QWPB_QWQY qy =list1.get(n).getDept().get(i).getQw_name().get(k).getQw_qy().get(k2);
								cellvalue="民警("+(qy.getMj_num()==null?"":qy.getMj_num())+"):"+
											(qy.getMj_name()==null?"":qy.getMj_name())+"\r\n"+
										"协警("+(qy.getXj_num()==null?"":qy.getXj_num())+"):"+
											(qy.getXj_name()==null?"":qy.getXj_name())+"\r\n"+
										"车辆("+(qy.getCl_num()==null?"":qy.getCl_num())+"):"+(qy.getCl_hphm()==null?"":qy.getCl_hphm());
								
							}
							//创建行
							sheet.autoSizeColumn(l, true);
							HSSFCell cell = row.createCell(l);
							cell.setCellValue(cellvalue);
				            cell.setCellStyle(style2);
				            //合并单元格
				            //纵向合并行数
				            int hb = 0;
				            //判断这行是从什么位置开始的
				            if(l==0) {
				            	if(list1.get(n).getRownum()==1) {
				            		hb = count-1;
				            	}else {
				            		hb = count + list1.get(n).getRownum()-2;
				            	}
			            	}else if(l==1) {
			            		if(list1.get(n).getDept().get(i).getRownum()==1) {
			            			hb = count-1;
			            		}else {
			            			hb = count + list1.get(n).getDept().get(i).getRownum()-2;
			            		}
			            	}else if(l==2) {
			            		if(list1.get(n).getDept().get(i).getQw_name().get(k).getRownum()==1) {
			            			hb = count-1;
			            		}else {
			            			hb = count + list1.get(n).getDept().get(i).getQw_name().get(k).getRownum()-2;
			            		}
			            	}else {
			            		hb = count-1;
			            	}
//				            System.out.println(count-1+","+hb+","+l+","+l+","+cellvalue);
				            // 四个参数分别是：起始行号，终止行号， 起始列号，终止列号
				            if(count-1!=hb) {
				            	sheet.addMergedRegion(new CellRangeAddress(count-1, hb, l, l));
				            }
				            cellvalue="";
						}
					}
				}
			}
        	//row = sheet.createRow(j+1);
        	
		}
        

        
        response.setContentType("application/vnd.ms-excel");
        response.addHeader("Content-Disposition", "attachment;filename="+ java.net.URLEncoder.encode("勤务排版表", "UTF-8")+".xls");  
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
	}
	
	/**
	 * 查询勤务区域
	 * @param map
	 * @return
	 */
	@RequestMapping("queryqy")
	public List<QWGL_XQGL_INFO> queryqy(@RequestParam HashMap<String,Object> map){
		return service.queryqy(null);
	}
	
}
