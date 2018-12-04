package com.cist.offsite.invalidtrial.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.BaseInfo.model.BaseDataModel;
import com.cist.dataexport.util.UrlFilesToZip;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.model.CPlateColorInfo;
import com.cist.offsite.invalidtrial.model.CPlateKerisInfo;
import com.cist.offsite.invalidtrial.model.CPlateTypeInfo;
import com.cist.offsite.invalidtrial.model.CRoadItem;
import com.cist.offsite.invalidtrial.model.C_Monitor_Point_Ex;
import com.cist.offsite.invalidtrial.model.Depart_info;
import com.cist.offsite.invalidtrial.model.SysConfig;
import com.cist.offsite.invalidtrial.model.Sys_frm_code;
import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.offsite.invalidtrial.model.Tbl_dev_vio_config;
import com.cist.offsite.invalidtrial.model.VwDevInfo;
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.cist.offsite.invalidtrial.utils.XwpfTUtil;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.service.PictureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("invalidtrial")
public class InvalidTrialController {

	@Autowired
	InvalidTrialService service;
	@Autowired
	PictureService pService;

		/**
	 * 审核信息单条查询
	 * 
	 * @param request
	 *            请求
	 */
    @RequestMapping("selectbywfpkcheck")
	public TblOffeEvdiInfo selectByWfpk(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		try {
			TblOffeEvdiInfo selectByWfpk = service.selectByWfpk(map);
			return selectByWfpk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 审核无效数据信息
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping("edit")
	public String updateByWfpk(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		try {
			//判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
			TblOffeEvdiInfo selectStatus = service.selectStatus(map);
			if(selectStatus==null)
			{
				return "{\"result\":\"已审核\"}";
			}
			//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废
			if(map.get("shbz")=="5")//5为作废数据审核有效
			{
				if(service.selectValid(map)!=null)
				{
					map.put("shbz", "0");//若数据库存在有效数据时自动作废当前数据
				}
			
				
			}
			//限行违法数据同一天相同车辆只允许存在一条有效限行违法数据，如果已存则数据自动作废；
			if(map.get("shbz")=="5"&&map.get("wfxw").equals("1344"))//1344限行违法代码
			{
				
				if(service.selectRestriction(map)!=null)
				{
					map.put("shbz", map.get("shbzFlag")==null?"3":map.get("shbzFlag"));//若数据库存在有效数据时自动作废当前数据
				}
			}
			
			HashMap<String,Object> modelMap=new HashMap<String,Object>();
				HttpSession session = request.getSession();
				Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
				String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
				String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
				map.put("tool_user", userPk);//操作人pk
				map.put("tool_dept_code", deptCode);//操作部门代码
				//获取ip
				  String remoteAddr = request.getRemoteAddr();
			        String forwarded = request.getHeader("X-Forwarded-For");
			        String realIp = request.getHeader("X-Real-IP");
			        String ip = null;
			        if (realIp == null) {
			            if (forwarded == null) {
			                ip = remoteAddr;
			            } else {
			                ip = remoteAddr + "/" + forwarded;
			            }
			        } else {
			            if (realIp.equals(forwarded)) {
			                ip = realIp;
			            } else {
			                ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
			            }
			        }
			       map.put("tool_ip", forwarded);//客户端ip地址
 			Integer updateByWfpk = service.updateByWfpk(map);
 			if(updateByWfpk>0)
 			{
 				return "{\"result\":\"审核成功\"}";
 			}
 			else
 			{
 				return "{\"result\":\"审核失败\"}";
 			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 无效数据信息的多条件查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectbycondition")
	public PageInfo<TblOffeEvdiInfo> selectByCondition(@RequestBody HashMap<String,Object> map) {
		try{	
			ArrayList sbbh=(ArrayList)map.get("sbbh");
			//设备编号多选编号分隔数组用作查询
			if(sbbh.size()>0)
			{
					map.put("list", sbbh);
			}
			
	PageInfo pinfo = new PageInfo();
		    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<TblOffeEvdiInfo> pageinfo = (PageInfo<TblOffeEvdiInfo>)service.selectByConditionpageList(map,pinfo);
			return pageinfo;
			}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	/**
	 * 查询下一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	@RequestMapping(value="selectnextbywfpk")
	public TblOffeEvdiInfo selectNextByWfpk(@RequestBody HashMap<String,Object> map) {
		
	    	return service.selectNextByWfpk(map);
		
	}
	
	/**
	 * 查询上一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	@RequestMapping(value="selectUpByWfpk")
	public TblOffeEvdiInfo selectUpByWfpk(@RequestBody HashMap<String,Object> map) {
		return service.selectUpByWfpk(map);
	}
	/**
	 * 查询采集设备信息
	 * @return  List<VwDevInfo>
	 */
	@RequestMapping(value="selectbyvwdevinfo")
	public List<VwDevInfo> selectByVwDevInfo() {
		return service.selectByVwDevInfo();
	}
	
	 /**
	 * 查询号牌类别信息
	 * @return  List<CPlateTypeInfo>
	 */
	@RequestMapping(value="selectHpzl")
	public List<Sys_frm_code> selectByCPlateTypeInfo(String fct_code) {
		return service.selectSysFrmCode(fct_code);
	}
	
	/**
	 * 查询号牌颜色信息
	 * @return  List<CPlateColorInfo>
	 */
	@RequestMapping(value="selectbycplatecolorinfo")
	public List<CPlateColorInfo> selectByCPlateColorInfo() {
		return service.selectByCPlateColorInfo();
	}
	
	/**
	 * 查询号牌前两位
	 * @return  List<CPlateKerisInfo>
	 */
	@RequestMapping(value="selectBycplatekerisinfo")
	public List<CPlateKerisInfo> selectByCPlateKerisInfo() {
		return service.selectByCPlateKerisInfo();
	}
	/**
	 * 查询违法行为信息
	 * @return  Tbl_offe_cate
	 */
	@RequestMapping(value="selectByWfxw")
	public Tbl_offe_cate selectByWfxw (@RequestBody HashMap<String, Object> map) {
		return service.selectByWfxw(map);
	}
	
	/**
	 * 无效数据单条数据查看
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="showedit")
	public Map<String,Object> showEdit(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
//		  modelMap.put("tblOffeCate", service.selectByWfxw(map));//违法记分信息
	      modelMap.put("cPlateTypeList",service.selectSysFrmCode("C001"));//号牌种类C001对应号牌种类
	      modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
	      modelMap.put("cPlateColorList", service.selectSysFrmCode("C007"));//号牌颜色
	      modelMap.put("cPlateKerisList", service.selectSysFrmCode("C009"));//号牌前两位
	      modelMap.put("cReason", service.selectSysFrmCode("S001"));//作废原因
	      modelMap.put("term",service.selectSysFrmCode("W002"));//布控车辆期限
	      modelMap.put("clyt",service.selectSysFrmCode("C008"));//车辆用途
		return modelMap;
	}
	
	/**
	 * 无效数据单条数据查看
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectOne")
	public Map<String,Object> selectOne(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		PageInfo<TblOffeEvdiInfo> selectByCondition = selectByCondition(map);
//		   modelMap.put("tboc_name",selectByCondition.getList()==null?null:selectByCondition.getList().get(0).getWfxwname());//根据违法行为违法记分等信息
//		  modelMap.put("tblOffeCate", service.selectByWfxw(modelMap));//违法记分信息
		  modelMap.put("list",selectByCondition);
//	      modelMap.put("cPlateTypeList",service.selectSysFrmCode("C001"));//号牌种类
//	      modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
//	      modelMap.put("cPlateColorList", service.selectByCPlateColorInfo());//号牌颜色
//	      modelMap.put("cPlateKerisList", service.selectByCPlateKerisInfo());//号牌前两位
	
		return modelMap;
	}
//	
//	/**
//	 * 无效数据单条数据查看
//	 * 
//	 * @param request
//	 *            请求
//	 */
//	@RequestMapping(value="nextOne")
//	public Map<String,Object> nextOne(@RequestParam HashMap<String,Object> map,HttpServletRequest request) {
//		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
//		PageInfo<TblOffeEvdiInfo> selectByCondition = selectByCondition(map);
//		   modelMap.put("tboc_name",selectByCondition.getList().get(0).getWfxwcd());
//		  modelMap.put("tblOffeCate", service.selectByWfxw(modelMap));//违法记分信息
//		  modelMap.put("list",selectByCondition);
//	      modelMap.put("cPlateTypeList",service.selectByCPlateTypeInfo());//号牌种类
//	      modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
//	      modelMap.put("cPlateColorList", service.selectByCPlateColorInfo());//号牌颜色
//	      modelMap.put("cPlateKerisList", service.selectByCPlateKerisInfo());//号牌前两位
//	     
//		return modelMap;
//	}
	
	/**
	 * 无效数据审核首页
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="index")
	public HashMap<String,Object> index(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("plateTypeList", service.selectSysFrmCode("C001"));//号牌种类
		modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
		modelMap.put("shrList", service.selectPolice(map));//警员列表
		Integer sycivalue = pService.sycivalue(modelMap);//统计信息
		modelMap.put("sycivalue", sycivalue);//违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue));//开始时间
		modelMap.put("wfjssj",gettime(0));//结束时间
		modelMap.put("auditnumber", pService.auditnumber(modelMap));//违法数据有效期内多少违法数据
		modelMap.put("getjintiri",pService.getjintiri(modelMap));//结束时间
		return modelMap;
	}
	/**
	 * 今日工作量查询
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="selectCheck")
	public HashMap<String,Object> selectCheck(@RequestBody HashMap<String,Object> map) {
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		Integer sycivalue = service.sycivalue(modelMap);
		modelMap.put("sycivalue", sycivalue);//违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue));//开始时间
		modelMap.put("wfjssj",gettime(0));//结束时间
		modelMap.put("auditnumber", service.auditnumber(modelMap));//违法数据有效期内多少违法数据
		modelMap.put("getjintiri",service.getjintiri(modelMap));//结束时间
		return modelMap;
	}
	public String gettime(Integer day) {
		   Date date=new Date();//取时间
		   Calendar calendar = new GregorianCalendar();
		   calendar.setTime(date);
		   calendar.add(calendar.DATE,-day);//把日期往后增加一天.整数往后推,负数往前移动
		    date=calendar.getTime(); //这个时间就是日期往后推一天的结果 
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    String dateString = formatter.format(date);
		    
		 return dateString;
	}
	//违法地点树
		@RequestMapping("departinfo")
		public String departinfo() throws JsonProcessingException{
	    //顶级部门 null
		List<Depart_info>	departinfo=service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();	
		List<Depart_info> list=departinfodg(departinfo);
		String json=mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length()-1);
		}
		
		public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list){
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (Depart_info depart_info : list) {
				HashMap<String, Object> map=new HashMap();
				map.put("title", depart_info.getName());
				map.put("key", depart_info.getDept_code());
				map.put("selectable", depart_info.getSelectable());
				map.put("isLeaf", depart_info.getIsLeaf());
				if(null!=depart_info.getChildren()) {//下级
					
					map.put("children", getdiwfdidian(depart_info.getChildren()));
					listmap.add(map);
				}else {
					listmap.add(map);
				}
			}
			return listmap;
		}
		
		
		public List<Depart_info> departinfodg(List<Depart_info> departinfo){
			for (Depart_info depart_info : departinfo) {
				//安装地点
				depart_info.setChildren(service.Monitorpoint(depart_info.getDept_code()));
				//部门
				List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
				for (Depart_info depart_info2 : list) {
					depart_info.getChildren().add(depart_info2);
				}
				depart_info.setChildren(depart_info.getChildren());
				if(null!=list){
					departinfodg(list);
				}
			}
			return departinfo;
		}
		//采集设备树
		@RequestMapping("acquisition")
		public String acquisition() throws JsonProcessingException{
	    //顶级部门 null
		List<Depart_info>	departinfo=service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		
		List<Depart_info> list=acquisition(departinfo);
		String json=mapper.writeValueAsString(getjiaojishebei(list));
		
		return json.substring(1, json.length()-1);
		}
		public List<HashMap<String, Object>> getjiaojishebei(List<Depart_info> list){
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (Depart_info depart_info : list) {
				HashMap<String, Object> map=new HashMap();
				map.put("title", depart_info.getName());
				map.put("key", depart_info.getDept_code());
				map.put("disableCheckbox", depart_info.getSelectable()==true?false:true);
				map.put("isLeaf", depart_info.getIsLeaf());
				if(null!=depart_info.getChildren()) {//下级
					map.put("children", getjiaojishebei(depart_info.getChildren()));
					listmap.add(map);
				}else {
					listmap.add(map);
				}
			}
			return listmap;
		}
		public List<Depart_info> acquisition(List<Depart_info> departinfo){
			for (Depart_info depart_info : departinfo) {
				//采集设备
				depart_info.setChildren(new ArrayList<Depart_info>());
				//部门
				List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
				for (Depart_info depart_info2 : list) {
					depart_info.getChildren().add(depart_info2);
				}
				depart_info.setChildren(depart_info.getChildren());
				if(null!=list){
					acquisition(list);
				}
			}
			return departinfo;
		}
		//设备列表树
		@RequestMapping(value = "/selectDev")
		public List<HashMap<String, Object>> selectDev(@RequestBody String dept_code) throws JsonProcessingException {
			List<CRoadItem> selectDev = service.selectRoad(dept_code);
			ObjectMapper mapper = new ObjectMapper();
			List<CRoadItem> list=point(selectDev);
//			String json=mapper.writeValueAsString(getTree(list));
//			return json.substring(1, json.length()-1);
				
				
			
			return getTree(list);
		}	
		public List<CRoadItem> point(List<CRoadItem> departinfo){
			for (CRoadItem road : departinfo) {
				//道路
				road.setChildren(new ArrayList<C_Monitor_Point_Ex>());
				//根据道路代码查询下面的点位信息
				List<C_Monitor_Point_Ex> list= service.selectPoint(road.getRoim_code());
				for (C_Monitor_Point_Ex point : list) {
				road.getChildren().add(point);
				}
				road.setChildren(road.getChildren());
//				if(null!=list){
//					point(list);
//				}
			}
			return departinfo;
		}
		
		public List<HashMap<String, Object>> getTree(List<CRoadItem> list){
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (CRoadItem road : list) {
				HashMap<String, Object> map=new HashMap();
				map.put("title", road.getRoim_name());
				map.put("key", road.getRoim_code());
				
				if(null!=road.getChildren()) {//下级
					map.put("isLeaf",false);
					map.put("children", getTreePoint(road.getChildren()));
					listmap.add(map);
				}else {
					map.put("isLeaf",true);
					listmap.add(map);
				}
			}
			return listmap;
		}
		public List<HashMap<String, Object>> getTreePoint(List<C_Monitor_Point_Ex> list){
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (C_Monitor_Point_Ex point : list) {
				HashMap<String, Object> map=new HashMap();
				map.put("title", point.getM_name());
				map.put("key", point.getM_pk());
				
				List<Tbl_dev_vio_config> selectDev = service.selectDev(point.getM_pk());
				if(null!=selectDev) {//下级
					map.put("isLeaf",false);
					map.put("children", getTreeDev(selectDev));
					listmap.add(map);
				}else {
					map.put("isLeaf",true);
					listmap.add(map);
				}
			}
			return listmap;
		}
		public List<HashMap<String, Object>> getTreeDev(List<Tbl_dev_vio_config> list){
			List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
			for (Tbl_dev_vio_config dev : list) {
				HashMap<String, Object> map=new HashMap();
				map.put("title", dev.getDvc_name());
				map.put("key", dev.getDvc_code());
					map.put("isLeaf",true);
					listmap.add(map);
			}
			return listmap;
		}
		/**
		 * 下载信息的压缩包
		 * 
		 * @param request
		 *            请求
		 */
		@RequestMapping(value = "/downloadFiles")
		public void downloadFiles(@RequestBody  HashMap<String,Object> map,HttpServletRequest request,
				HttpServletResponse response) {
//			TblOffeEvdiInfo selectExport = service.selectExport(map);
			try {
				// 获取当前时间当做文件夹名
				Date da = new Date();
				SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");// 格式化日期
				int rd = (int) (Math.random() * 1000);// 第一层文件夹名的末尾的随机数
				String format = sf.format(da) + "_" + rd;// 时间文件名结尾加三位随机数

				// 控制文件名编码
				// 响应头的设置
				response.reset();
				response.setCharacterEncoding("utf-8");
				response.setContentType("multipart/form-data");

				// 设置压缩包的名字
				// 解决不同浏览器压缩包名字含有中文时乱码的问题
				String downloadName = format + ".zip";
				String agent = request.getHeader("USER-AGENT");
				try {
					if (agent.contains("MSIE") || agent.contains("Trident")) {
						downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
					} else {
						downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
				// 设置压缩流：直接写入response，实现边压缩边下载
				ZipOutputStream zipos = null;
				zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
				zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
				ArrayList<String> urls = new ArrayList<String>();// 存放图片路径
				UrlFilesToZip s = new UrlFilesToZip();
				// 循环将文件写入压缩流
				DataOutputStream os = null;
				try {
					if(map.get("wfzj1")!=null)
					{
						urls.add(map.get("wfzj1").toString());
					}
					if(map.get("wfzj2")!=null)
					{
						urls.add(map.get("wfzj2").toString());
					}
					if(map.get("wfzj3")!=null)
					{
						urls.add(map.get("wfzj3").toString());
					}
						for (String oneFile : urls) {
							// 根据实体字段名生成压缩包内文件路径
							zipos.putNextEntry(
									new ZipEntry(format + "/" + map.get("wfdz") + "(" +map.get("kkbh")
											+ ")" + "/" + map.get("sbbh")+ "/" + map.get("wfxw")
											+ "/" + map.get("hphm") + "/" + oneFile.substring(21)));

							byte[] bytes = s.getImageFromURL(oneFile);
							os = new DataOutputStream(zipos);
							os.write(bytes, 0, bytes.length);
							zipos.closeEntry();

						}
						urls.clear();// 操作完一条记录清除一次图片路径
					// 关闭流
					zipos.close();
					//os.flush();
					os.close();
				} catch (IOException e) {
					// 此异常不打印，用户在下载途中点击取消中断流的输出会报此异常
				}
				// 更改已导出数据的状态为导出
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		/**
		 * 证据设备报修导出
		 * 
		 * @param request
		 *            请求
//		 */
		@RequestMapping("repair")
		public void repair(@RequestBody HashMap<String,Object> map,HttpServletRequest request,HttpServletResponse response)throws Exception {
			Map<String, Object> params = new HashMap<String, Object>();  
		      
            params.put("${tbr}", map.get("tbr")==null?"":map.get("tbr").toString());  
            params.put("${time}",map.get("time")==null?"":map.get("time").toString());  
            params.put("${sbmc}", map.get("sbmc")==null?"":map.get("sbmc").toString());  
            params.put("${gzms}", map.get("gzms")==null?"":map.get("gzms").toString());  
            params.put("${szdd}", map.get("szdd")==null?"":map.get("szdd").toString());  
            XwpfTUtil wordUtil=new XwpfTUtil();
            UrlFilesToZip s=new UrlFilesToZip();
            String fileNameInResource = "sta.docx";  
            InputStream is;  
            /*is = new FileInputStream(filePath);*/  
            is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);
            try{
                Map<String,Object> header = new HashMap<String, Object>();
                header.put("width", 500);
                header.put("height", 300);
                header.put("type", "jpg");
                header.put("content", s.getImageFromURL((String)map.get("wfzj1")));
                params.put("${wfzj1}",header);
                Map<String,Object> header2 = new HashMap<String, Object>();
                header2.put("width", 500);
                header2.put("height", 300);
                header2.put("type", "jpg");
                header2.put("content", s.getImageFromURL((String)map.get("wfzj1")));
                params.put("${wfzj2}",header2);
                String path=fileNameInResource;  //模板文件位置
                String fileName= new String("证据设备报修.docx".getBytes("UTF-8"),"iso-8859-1");    //生成word文件的文件名
                wordUtil.getWord(path,params,null,fileName,response);

            }catch(Exception e){
                e.printStackTrace();
            }
		}
		/**
		 * 更新六合一数据
		 * @param map
		 * @return
		 */
		@RequestMapping("updateCarInfo")
		public String updateCarInfo(@RequestBody HashMap<String,Object> map) {
			Integer updateCarInfo = service.updateCarInfo(map);
			if(updateCarInfo>0)
			{
				return "{\"result\":\"更新成功\"}";
			}
			else
			{
				return "{\"result\":\"更新失败\"}";
			}
			
		}
}
