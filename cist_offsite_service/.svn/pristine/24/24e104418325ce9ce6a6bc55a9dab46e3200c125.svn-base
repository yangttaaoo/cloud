package com.cist.recheck.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dataexport.util.UrlFilesToZip;
import com.cist.frame.page.PageInfo;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.cist.picture.service.PictureService;
import com.cist.recheck.model.TblOffeCateInfo;
import com.cist.recheck.model.TblOffeEvdiInfo;
import com.cist.recheck.model.VwDevInfo;
import com.cist.recheck.model.Vw_dev_info;
import com.cist.recheck.service.RecheckService;
import com.fasterxml.jackson.core.JsonProcessingException;




@RestController
@RequestMapping("goto")
public class RecheckController {


	@Autowired
	private RecheckService recheckService;
	@Autowired
	private PictureService pService;

	@Autowired
	private InvalidTrialService service;


	/**
	 * 审核无效数据信息
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping("updatebywfpk")
	public String updateByWfpk(@RequestBody HashMap<String,Object> map,HttpServletRequest request) {
		try {
			//审核结果为“有效”时，保存审核结果时需判断违法信息中的“号牌号码”、“号牌种类”、“车身颜色”与车辆信息中的“号牌号码”、“号牌种类”、“车身颜色”一致
			if(map.get("shbz")=="2"&&map.get("dataList")!=null)//2为复审通过
			{
				Map object = (Map) map.get("dataList");
				if(!map.get("hphm").equals(object.get("hphm"))||!map.get("hpzl").equals(object.get("hpzl"))||((String)object.get("csys")).indexOf((String)map.get("csys"))!=-1)
				{
					return "{\"result\":\"信息不一致\"}";
				}
			}
			//判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
			TblOffeEvdiInfo selectStatus = recheckService.selectStatus(map);
			if(selectStatus==null)
			{
				return "{\"result\":\"已审核\"}";
				
			}
			//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废
			if(map.get("shbz")=="2")//2 为复审通过
			{
				if(recheckService.selectValid(map)!=null)
				{
					map.put("shbz", "4");//若数据库存在有效数据时自动作废当前数据4为复审作废
				}
			}
			//限行违法数据同一天相同车辆只允许存在一条有效限行违法数据，如果已存则数据自动作废；
			if(map.get("shbz")=="2"&&map.get("wfxw").equals("1344"))//2 为复审通过 1344为限行数据
			{
				if(service.selectRestriction(map)!=null)
				{
					map.put("shbz", "4");//若数据库存在有效数据时自动作废当前数据4为复审作废
				}
			}
			//复审人
			
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
			map.put("fsr", userPk+"");
			Integer updateByWfpk = recheckService.updateByWfpk(map);
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

	@RequestMapping("saveVehBus")
	public Integer inserCl(@RequestBody HashMap<String,Object> map){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		map.put("sxrq", sdf.format(new Date()));
		for (Map.Entry<String, Object> element : map.entrySet()) {
			if (element.getValue() == null || element.getValue() == "" || "null".equals(element.getValue())) {
				map.put(element.getKey(), "1");
			}
		}
		map.put("clms", "1");
		Integer isSave = recheckService.addInsert(map);
		if (isSave!=0) {
			return isSave;
		}else {
			return 0;
		}

	}

	/**
	 * 号牌种类
	 * @return
	 */
	@RequestMapping("plateTypeList")
	public Map<String, Object> plateTypeList(){
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("hpzllist",recheckService.plateTypeList("C001"));//号牌种类 
		return modelMap;
	}
	
	/**
	 * 违法数据复审的多条件查询
	 * @param request 请求
	 */
	@RequestMapping(value="selectbycondition")
	public PageInfo<TblOffeEvdiInfo> selectByCondition(@RequestBody HashMap<String,Object> map ,HttpServletRequest request) {
		//获取 ‘审核标准’
		/*if(!"".equals(map.get("sbbh")))
		{
			String sbbh=map.get("sbbh").toString();
			if(null!=sbbh&&sbbh!="") {
				sbbh=sbbh.substring(0, sbbh.length()-1);
				String sbb[]=sbbh.split(",");
				map.put	("sbbh", sbb);
			}
		}*/
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = recheckService.querywfxwqxbysypi(userPk);
		if(vglist.size()>0) {
			//判断违法行为权限
			if(map.get("wfxw")==null||"".equals(map.get("wfxw"))) {
				if(vglist.get(0).getTbvg_wfxw()!=null) {
					map.put("wfxw", vglist.get(0).getTbvg_wfxw().split(","));
				}
			}else {
				String[] str = new String[1];
				str[0]=map.get("wfxw").toString();
				map.put("wfxw", str);
			}
			//判断设备权限


		}else {
			if(map.get("wfxw")!=null) {
				String[] str = new String[1];
				str[0]=map.get("wfxw").toString();
				map.put("wfxw", str);
			}
		}
		String sbbh=map.get("sbbh").toString();
		if(null!=sbbh&&sbbh!="") {
			sbbh=sbbh.substring(1, sbbh.length()-1);

			if(!sbbh.equals("")) {
				String sbb[]=sbbh.split(",");
				map.put("sbbh", sbb);
			}else {
				map.put("sbbh", null);
			}
		}
		PageInfo pinfo = new PageInfo();
		pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		if("1".equals(map.get("tqFlag"))) {
			Integer tiqu = recheckService.tiqu(map);	
		}
		PageInfo<TblOffeEvdiInfo> pageinfo = (PageInfo<TblOffeEvdiInfo>)recheckService.selectByConditionpageList(map,pinfo);
		return pageinfo;
	}

	/**
	 * 查询下一条审核信息审核
	 * @param tblOffeEvdiInfo 查询条件
	 * @return TblOffeEvdiInfo
	 */
	@RequestMapping(value="selectnextbywfpk")
	public TblOffeEvdiInfo selectNextByWfpk(@RequestBody TblOffeEvdiInfo tblOffeEvdiInfo) {
		return recheckService.selectNextByWfpk(tblOffeEvdiInfo);
	}
//	/**
//	 * 查询采集设备信息
//	 * @return  List<VwDevInfo>
//	 */
//	@RequestMapping(value="selectbyvwdevinfo")
//	public List<VwDevInfo> selectByVwDevInfo() {
//		return recheckService.selectByVwDevInfo();
//	}

	/**
	 * 查询违法内容
	 * @param map
	 * @return
	 */
	@RequestMapping("tblbyshort")
	public TblOffeCateInfo tblByShort(@RequestBody HashMap<String, Object> map){
		return recheckService.tblByShort(map);
	}
	
	@RequestMapping("params")
	public Map<String,Object> paramsList(@RequestParam String[] dataParams,
			String[] pageParams,
			String[] countParams,
			HttpServletRequest request){
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		String[] dataParam = request.getParameterValues("dataParams");
		String[] pageParam = request.getParameterValues("pageParams");
		String[] countParam = request.getParameterValues("countParams");
		
		
		modelMap.put("dataParams", dataParam);
		modelMap.put("pageParams", pageParam);
		modelMap.put("countParams", countParam);
		return modelMap;
	}
	
	@RequestMapping("paramt")
	public Map<String, Object> paramsGoto(String[] dataParams,
			String[] pageParams,
			String[] countParams,
			HttpServletRequest request){
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("listParam",paramsList(dataParams, pageParams, countParams, request));
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
		PageInfo<TblOffeEvdiInfo> selectByCondition = selectByCondition(map, request);
//		modelMap.put("tboc_name",selectByCondition.getList().get(0).getWfxwcd());//根据违法行为违法记分等信息
//		modelMap.put("tblOffeCate", service.selectByWfxw(modelMap));//违法记分信息
		modelMap.put("list",selectByCondition);
		modelMap.put("cPlateTypeList",service.selectSysFrmCode("C001"));//号牌种类
		modelMap.put("tblOffeCateList", pService.tblOffeCateList());//违法行为
		modelMap.put("cPlateColorList", service.selectSysFrmCode("C007"));//号牌颜色
		modelMap.put("cReason", service.selectSysFrmCode("S001"));//作废原因
		modelMap.put("cPlateKerisList",  service.selectSysFrmCode("C009"));//号牌前两位
		modelMap.put("term", service.selectSysFrmCode("W002"));//布控车辆期限
		modelMap.put("caruse", service.selectSysFrmCode("C008"));//布控车辆期限 
		//modelMap.put("newList", paramsList(dataParams, pageParams, countParams, request))
		return modelMap;
	}




	@RequestMapping("kreis")

	public List<HashMap<String, Object>> treeRoad(@RequestBody HashMap<String,Object> map) throws JsonProcessingException {
		// 根据行政区划代码查询道路树
		List<Vw_dev_info> roadList = recheckService.treeSb(map);
		List<HashMap<String, Object>> road = getRoad(roadList);
		return road;
	}

	public List<HashMap<String, Object>> getRoad(List<Vw_dev_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Vw_dev_info roadList : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", roadList.getTbei_name());
			map.put("key", roadList.getTbei_code());
			map.put("selectable", true);
			map.put("isLeaf", false);
			map.put("expanded", true);

			listmap.add(map);
		}
		return listmap;
	}


	/*	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<Vw_dev_info> departinfo = recheckService.treeSbList(null);
		ObjectMapper mapper = new ObjectMapper();
		List<Vw_dev_info> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<Vw_dev_info> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (Vw_dev_info depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getTbei_name());
			map.put("key", depart_info.getTbei_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级

				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<Vw_dev_info> departinfodg(List<Vw_dev_info> departinfo) {
		for (Vw_dev_info depart_info : departinfo) {
			// 部门
			List<Vw_dev_info> list = recheckService.treeSbList(depart_info.getTbei_code());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}*/

	/**
	 * 查询将要导出到excle的数据
	 * 
	 * @param request
	 *            请求
	 */
	@RequestMapping(value="exportexclelist")
	public List<TblOffeEvdiInfo> exportExcleList(@RequestParam HashMap<String,Object> map) {
		try{	
			List<TblOffeEvdiInfo> exportExcleList = recheckService.exportZipList(map);
			return exportExcleList;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
//		TblOffeEvdiInfo selectExport = service.selectExport(map);
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
								new ZipEntry(format + "/" + map.get("wfdz")==null?"未知":map.get("wfdz") + "(" +map.get("kkbh")==null?"未知":map.get("kkbh")
										+ ")" + "/" + map.get("sbbh")==null?"未知":map.get("sbbh")+ "/" +  map.get("wfxw")==null?"未知":map.get("wfxw")
										+ "/" + map.get("hphm")==null?"未知":map.get("hphm") + "/" + oneFile.substring(21)));

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
	 * （复审）
	 * @return
	 */
	/**
	 * 页面审核统计（初审）
	 * 
	 * @return
	 */
	@RequestMapping("sycivalue")
	public HashMap<String, Object> sycivalue(HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = recheckService.querywfxwqxbysypi(userPk);
		if (vglist.size() > 0) {
			if (vglist.get(0).getTbvg_wfxw() != null) {
				modelMap.put("tboc_code", vglist.get(0).getTbvg_wfxw().split(","));
			}
		}
		//设备权限
		modelMap.put("sbbh",new ArrayList<String>());
		if(vglist.size()>0) {
			String dev = recheckService.querydevbysypi(vglist.get(0).getTbvg_pk());
			if(dev!=null) {
				String[] str = dev.split(",");
				if(Arrays.asList(str).contains("0")) {
					modelMap.put("zplx", "1");
				}else {
					modelMap.put("sb_pk", dev.split(","));
					String sb_bh = recheckService.querysbbhbysbpk(modelMap);
					if(sb_bh!=null) {
						String[] split = sb_bh.split(",");
						List<String> sbbhlist=new ArrayList<String>();
						for (int i = 0; i < split.length; i++) {
							sbbhlist.add(split[i]);
						}
						modelMap.put("sbbh",sbbhlist);	
					}
				}
			}
		}
		int sycivalue = service.sycivalue(modelMap);
		modelMap.put("sycivalue", sycivalue);// 违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue));// 开始时间
		modelMap.put("wfjssj", gettime(0));// 结束时间
		modelMap.put("auditnumber", service.auditnumber(modelMap));// 违法数据有效期内多少违法数据
		Integer queryjrgzl = recheckService.queryjrgzl(userPk);
		modelMap.put("jrshl", queryjrgzl==null?0:queryjrgzl);// 今日已审核量
		List<TBL_VERIFY_GROUP> querywfxwqxbysypi = recheckService.querywfxwqxbysypi(userPk);
		if(querywfxwqxbysypi.get(0).getTbvg_job()!=null)
		{
			modelMap.put("jrgzl", querywfxwqxbysypi.get(0).getTbvg_job());// 今日工作量	
		}
		else
		{
			modelMap.put("jrgzl", 0);// 今日工作量
		}
		 
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

	/**
	 * 根据权限查询违法行为
	 * @param map
	 * @return
	 */
	@RequestMapping("querywfxw")
	public List<TBL_OFFE_CATE> querywfxw(@RequestBody HashMap<String,Object> map,HttpServletRequest request){
		List<TBL_OFFE_CATE> list = null;
		
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = recheckService.querywfxwqxbysypi(userPk);
		
		if(vglist.size()>0) {
			if(vglist.get(0).getTbvg_wfxw()!=null) {
				map.put("tboc_code", vglist.get(0).getTbvg_wfxw().split(","));
				list = recheckService.querywfxw(map);
			}else {
				list = recheckService.querywfxw(null);
			}
		}else {
			list = recheckService.querywfxw(null);
		}
		return list;
	}	
	
	/**
	 * 更新六合一数据
	 * @param map
	 * @return
	 */
	@RequestMapping("updateCarInfo")
	public String updateCarInfo(@RequestBody HashMap<String,Object> map) {
		Integer updateCarInfo = recheckService.updateCarInfo(map);
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
