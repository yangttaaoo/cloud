package com.cist.fieid.controller;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import com.cist.fieid.model.C_direction;
import com.cist.fieid.model.TblOffeEvdiInfo;
import com.cist.fieid.service.FieidService;
import com.cist.frame.page.PageInfo;
import com.cist.offsite.invalidtrial.service.InvalidTrialService;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.service.PictureService;

@RequestMapping("fieid")
@RestController
public class FieidController {

	@Autowired
	private FieidService fieidService;
	@Autowired
	private InvalidTrialService invalidTrialService;
	@Autowired
	PictureService pService;

	@RequestMapping("allist")
	@SuppressWarnings("unchecked")
	public PageInfo<TblOffeEvdiInfo> indexAll(@RequestBody HashMap<String, Object> map) {
		PageInfo pInfo = new PageInfo();
		if(map.get("sbbh")!=null)
		{
			String sbbh = map.get("sbbh").toString();
			if (null != sbbh && sbbh != "") {
				sbbh = sbbh.substring(0, sbbh.length() - 1);
				String sbb[] = sbbh.split(",");
				map.put("sbbh", sbb);
			}
		}
		
		pInfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pInfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TblOffeEvdiInfo> pageInfo = (PageInfo<TblOffeEvdiInfo>) fieidService.selectAllpageList(map, pInfo);
		return pageInfo;
	}

	/**
	 * 查询行驶方向
	 * 
	 * @return
	 */
	@RequestMapping("runDirection")
	public List<C_direction> runDirection() {
		return fieidService.runDirection(new C_direction());
	}

	/**
	 * 查询上一条数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("predata")
	public List<TblOffeEvdiInfo> getPreDate(@RequestBody HashMap<String, Object> map) {
		String sbbh = map.get("sbbh").toString();
		if (null != sbbh && sbbh != "") {
			sbbh = sbbh.substring(0, sbbh.length() - 1);
			String sbb[] = sbbh.split(",");
			map.put("sbbh", sbb);
		}
		List<TblOffeEvdiInfo> list = fieidService.getPreData(map);
		if (list.size()<=0) {
			Long wfpk = Long.parseLong(map.get("wfpk").toString());
			TblOffeEvdiInfo tblOffeEvdiInfo = fieidService.getBywfpk(wfpk);
			tblOffeEvdiInfo.setIsFirst(0);
			list.add(tblOffeEvdiInfo);
		} else {
			list.get(0).setIsFirst(1);
		}
		return list;
	}

	/**
	 * 查询下一条数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("nextdata")
	public List<TblOffeEvdiInfo> getNextDate(@RequestBody HashMap<String, Object> map) {
		String sbbh = map.get("sbbh").toString();
		if (null != sbbh && sbbh != "") {
			sbbh = sbbh.substring(0, sbbh.length() - 1);
			String sbb[] = sbbh.split(",");
			map.put("sbbh", sbb);
		}
		List<TblOffeEvdiInfo> list = fieidService.getNextData(map);
		if (list.size()<=0) {
			Long wfpk = Long.parseLong(map.get("wfpk").toString());
			TblOffeEvdiInfo tblOffeEvdiInfo = fieidService.getBywfpk(wfpk);
			tblOffeEvdiInfo.setIsLast(0);
			list.add(tblOffeEvdiInfo);
		} else {
			list.get(0).setIsLast(1);
		}
		return list;
	}

	/**
	 * 查询除‘川’以外的号牌详情
	 * 
	 * @return
	 */
	/*
	 * @RequestMapping("selectHphm") public List<TblOffeEvdiInfo> selectHphm(){
	 * return fieidService.selectHphm(); }
	 */

	/**
	 * 更新无效数据信息状态
	 * 
	 * @param info
	 * @return
	 */
	@RequestMapping("updatestate")
	public String updateState(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		//判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
		TblOffeEvdiInfo selectStatus = fieidService.selectStatus(map);
		if(selectStatus==null)
		{
			return "{\"result\":\"已审核\"}";
		}
		//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废
		if(map.get("shbz")=="1")//1外地车审核有效
		{
			if(fieidService.selectValid(map)!=null)
			{
				map.put("shbz", "0");//若数据库存在有效数据时自动作废当前数据
			}
		
			
		}
		//限行违法数据同一天相同车辆只允许存在一条有效限行违法数据，如果已存则数据自动作废；
		if(map.get("shbz")=="1"&&map.get("wfxw").equals("1344"))//1344限行违法代码
		{
			
			if(fieidService.selectRestriction(map)!=null)
			{
				map.put("shbz", "3");//若数据库存在有效数据时自动作废当前数据
			}
		}
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
		Integer isupdate = fieidService.updateState(map);
		if(isupdate>0)
		{
			return "{\"result\":\"审核成功\"}";
		}
		else
		{
			return "{\"result\":\"审核失败\"}";
		}
		
	}

	/**
	 * 获取违法行为实体
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("gettboffecate")
	public Tbl_offe_cate geTbl_offe_cate(@RequestBody HashMap<String, Object> map) {
		Tbl_offe_cate tbl_offe_cate = invalidTrialService.selectByWfxw(map);
		return tbl_offe_cate;
	}

	/**
	 * 无效数据单条数据查看
	 * 
	 * @return
	 */
	@RequestMapping(value = "showedit")
	public Map<String, Object> showEdit() {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("cPlateTypeList", invalidTrialService.selectSysFrmCode("C001"));// 号牌种类
		modelMap.put("cPlateColorList", invalidTrialService.selectSysFrmCode("C007"));// 号牌颜色
		modelMap.put("tblOffeCateList", pService.tblOffeCateList());// 违法行为
		modelMap.put("cPlateKerisList", invalidTrialService.selectSysFrmCode("C009"));// 号牌前两位
		modelMap.put("cReasonList", invalidTrialService.selectSysFrmCode("S001"));//违法原因
		modelMap.put("bkqxList", invalidTrialService.selectSysFrmCode("W002"));//布控期限
		modelMap.put("caruse",invalidTrialService.selectSysFrmCode("C008"));// 车辆用途
		return modelMap;
	}

	/**
	 * 获取周一凌晨到今天最后一刻的时间
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("gettime")
	public String[] gettime() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		Date first = cal.getTime();

		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);

		Date second = cal.getTime();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String[] strings = new String[2];
		strings[0] = formater.format(first);
		strings[1] = formater.format(second);
		return strings;
	}

	/**
	 * 下载图片
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("downloadImage")
	public Boolean downloadImage(@RequestParam HashMap<String, Object> map, HttpServletResponse response,
			HttpServletRequest request) {
		boolean result = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			Date date = new Date();
			int rd = (int) (Math.random() * 1000);// 第一层文件夹名的末尾的随机数
			String format = sdf.format(date) + "_" + rd;// 时间文件名结尾加三位随机数

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

			// 违法证据图片装入到数组
			String[] files = new String[3];
			for (int i = 1; i <= files.length; i++) {
				String fileName = (String) map.get("wfzj" + i);
				files[i - 1] = fileName;
			}

			// 违法地点名称（卡口编号）\设备编号\违法代码\号牌号码\违法图片
			String file = "" + map.get("wfdd") + "\\" + map.get("sbbh") + "\\" + map.get("wfxw1") + "\\"
					+ map.get("hphm") + "\\";
			// 存储的地址
			DataOutputStream os = null;
			UrlFilesToZip s = new UrlFilesToZip();
			ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].substring(files[i].lastIndexOf("/"));
				zip.putNextEntry(
						new ZipEntry(file + sdf.format(date) + i + fileName.substring(fileName.lastIndexOf("."))));
				byte[] bytes = s.getImageFromURL(files[i]);
				os = new DataOutputStream(zip);
				os.write(bytes, 0, bytes.length);
				zip.closeEntry();
				
			}
			zip.close();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 保存车辆标记
	 * @return
	 */
	@RequestMapping("saveVehBus")
	public Integer saveVehBus(@RequestBody HashMap<String, Object> paramMap) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		paramMap.put("sxrq", sdf.format(new Date()));
		paramMap.put("yxqz", sdf.format(new Date()));
		for (Map.Entry<String, Object> element : paramMap.entrySet()) {
		if (element.getValue() == null || element.getValue() == "" || "null".equals(element.getValue())) {
				paramMap.put(element.getKey(), "1");
			}
		}
		paramMap.put("clms", "1");
		Integer isSave = fieidService.saveVehBus(paramMap);
		if (isSave!=0) {
			return 1;
		}else return 0;
	}
	/***
	 * 已选择 0 项 12日内未审核数：0条 今日审核总计：0 条
	 * @return
	 */
	@RequestMapping("sycivalue")
	public HashMap<String,Object> sycivalue(){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		int sycivalue=fieidService.sycivalue(modelMap);
		modelMap.put("sycivalue", sycivalue);//违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue));//开始时间
		modelMap.put("wfjssj",gettime(0));//结束时间
		modelMap.put("auditnumber", fieidService.auditnumber(modelMap));//违法数据有效期内多少违法数据
		modelMap.put("getjintiri",fieidService.getjintiri(modelMap));//今日审核总计
		
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
}
