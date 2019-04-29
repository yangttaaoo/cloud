package com.cist.trafficSign.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.devRegister.service.DevRegisterService;
import com.cist.frame.page.PageInfo;
import com.cist.trafficSign.model.TrafficSign;
import com.cist.trafficSign.service.TrafficSignService;

/**
 * 交通标志
 * 
 * @author 57150
 *
 */
@RestController
@RequestMapping("trafficSign")
public class TrafficSignController {
	@Autowired
	private TrafficSignService service;
	@Autowired
	private DevRegisterService devService;

	/**
	 * 初始化编辑页需要的展示数据
	 * 
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("initTabData")
	public HashMap<String, Object> initTabData(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("deptTreeNodes", devService.initDeptTree(request));// 部门Tree
		resultMap.put("kireTreeNodes", devService.initAdministrativeAreasTree());// 行政区划Tree
		resultMap.put("BZLX", devService.queryDevFunType("BZLX"));// 标志类型
		resultMap.put("ZCFS", devService.queryDevFunType("ZCFS"));// 支撑方式
		resultMap.put("BZXZ", devService.queryDevFunType("BZXZ"));// 形状
		resultMap.put("BZFX", devService.queryDevFunType("BZFX"));// 方向名称
		resultMap.put("GXTX", devService.queryDevFunType("GXTX"));// 光学特性
		resultMap.put("XSWZ", devService.queryDevFunType("XSWZ"));// 显示位置
		resultMap.put("BMXS", devService.queryDevFunType("BMXS"));// 版面显示方式
		resultMap.put("LYLX", devService.queryDevFunType("LYLX"));// 能源类型
		resultMap.put("R007", devService.queryDevFunType("R007"));// 道路类型
		resultMap.put("road", devService.queryRoadList1(paramMap));// 道路List	
		return resultMap;

	}
	/**
	 * 初始化卡口备案Index页面查询表单参数值
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/initIndexQueryConditions")
	public HashMap<String, Object> initIndexQueryConditions(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) throws Exception {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("administrativeAreas", devService.initAdministrativeAreasTree());// 行政区划
		resultMap.put("dept", devService.initDeptTree(request));// 管理部门
		resultMap.put("roadSegite", devService.initAreaRoadTree(paramMap));// 所属道路
		resultMap.put("BZLX", devService.queryDevFunType("BZLX"));// 标志类型
		return resultMap;
	}

	/**
	 * 分页查询交通标志
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("queryList")
	public PageInfo<TrafficSign> queryDeviceList(@RequestBody HashMap<String, Object> paramMap,HttpServletRequest request) {
		// 当前用户的部门 用于部门权限设置
		HttpSession session = request.getSession();
		Map<String,Object> map1 = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String deptCode = map1.get("sypi_dept_code")==null?null:map1.get("sypi_dept_code").toString();
		paramMap.put("dept", deptCode);//当前用户部门code 用于部门权限 
		@SuppressWarnings("rawtypes")
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(Integer.parseInt(paramMap.get("pageSize").toString()));
		pageInfo.setPageNum(Integer.parseInt(paramMap.get("currentPage").toString()));
		@SuppressWarnings("unchecked")
		PageInfo<TrafficSign> list = (PageInfo<TrafficSign>) service.querypageList(paramMap, pageInfo);
		return list;
	}
	/**
	 * 新增一条交通标志记录
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("insert")
	public String insert(@RequestParam HashMap<String, Object> paramMap,List<MultipartFile> bzlxtp_pic,List<MultipartFile> bzsjtp_pic,HttpServletRequest request) {
		try {
			for (MultipartFile multipartFile : bzsjtp_pic) {
				String bzlxtp_pic_path = FileUtil.FileUploadService(multipartFile);
				 paramMap.put("bzlxtp", bzlxtp_pic_path);
			}
			for (MultipartFile multipartFile : bzsjtp_pic) {
				String bzsjtp_pic_path = FileUtil.FileUploadService(multipartFile);
				 paramMap.put("bzsjtp", bzsjtp_pic_path);
			}
		} catch (Exception e) {
			return "{\"flag\":\"500\",\"msg\":\"上传文件异常!\"}";
		}	
		
		int size =service.addTrafficSign(paramMap);
		return "{\"flag\":\""+(size>0?200:401)+"\",\"msg\":\""+(size>0?"新增交通标志成功！":"新增交通标志失败！")+"\"}";
	}
	/**
	 * 更新一条交通标志记录
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("update")
	public String update(@RequestParam HashMap<String, Object> paramMap,List<MultipartFile> bzlxtp_pic,List<MultipartFile> bzsjtp_pic,HttpServletRequest request) {
		
		try {
			for (MultipartFile multipartFile : bzsjtp_pic) {
				String bzlxtp_pic_path = FileUtil.FileUploadService(multipartFile);
				 paramMap.put("bzlxtp", bzlxtp_pic_path);
			}
			for (MultipartFile multipartFile : bzsjtp_pic) {
				String bzsjtp_pic_path = FileUtil.FileUploadService(multipartFile);
				 paramMap.put("bzsjtp", bzsjtp_pic_path);
			}
			
		} catch (Exception e) {
			return "{\"flag\":\"500\",\"msg\":\"上传文件异常!\"}";
		}	
		int size =service.updateTrafficSignById(paramMap);
		return "{\"flag\":\""+(size>0?200:401)+"\",\"msg\":\""+(size>0?"修改交通标志成功！":"修改交通标志失败！")+"\"}";
	}
	/**
	 * 删除交通标志
	 * 
	 * @param paramMap
	 * @return
	 */
	@RequestMapping("delete")
	public String delete(@RequestBody HashMap<String, Object> paramMap) {
		try {
			service.deleteById(paramMap);
		} catch (Exception e) {
			return "{\"flag\":\"500\",\"msg\":\"删除失败!\"}";
		}
		return "{\"flag\":\"200\",\"msg\":\"删除成功\"}";
	}
}
