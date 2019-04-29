package com.cist.eventmanagement.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.configUrl.model.FileUtil;
import com.cist.eventmanagement.model.DeptInfo;
import com.cist.eventmanagement.model.VW_EVENT_INFO;
import com.cist.eventmanagement.model.Zhdd_event_attachment;
import com.cist.eventmanagement.model.Zhdd_event_flow;
import com.cist.eventmanagement.model.Zhdd_event_result;
import com.cist.eventmanagement.service.EventManagementService;
import com.cist.frame.page.PageInfo;
import com.cist.home.model.EventFlowInfo;
import com.cist.home.service.HomeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/event")
public class EventManagementController {
	@Autowired
	private EventManagementService service;
	
	@Autowired
	private HomeService hService;
	
	/**
	 * 分页查询事件详细信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("queryevent")
	public PageInfo<VW_EVENT_INFO> queryevent(@RequestBody HashMap<String, Object> map,HttpServletRequest request){
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<VW_EVENT_INFO> pageinfo = (PageInfo<VW_EVENT_INFO>)service.queryeventinfopageList(map, info);
		return pageinfo;
	}
	/**
	 * 删除事件信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteevent(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		try {
			service.deleteeventinfo(map);
			service.delZhdd_event_acceptance(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
		
	}
	
	/**
	 * 更新事件信息
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping("update")
	public Integer updateevent(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		try {
			service.updateeventinfo(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
		
	}
	/**
	 * 部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk());
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

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}
	/**
	 * 添加页面加载时查询事件类型和事件来源信息
	 * @param map
	 * @return
	 */
	@RequestMapping("addindex")
	public HashMap<String,Object> addindex(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("sjly", service.querysjly(null));
		ModelMap.put("sjtype", service.querysjtype(null));
		ModelMap.put("yxx", service.queryyxx(null));
		return ModelMap;
		}
	/**
	 * 事件添加
	 * @param map
	 * @return
	 */
	@RequestMapping("add")
	public Integer addsj(@RequestBody HashMap<String,Object> map){
		try {
			map.put("event_current_status", 4);
			map.put("event_status", 0);
			service.addsj(map);
			service.addslinfo(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
	/**
	 * 查询事件详细信息
	 */
	@RequestMapping("querysjinfo")
	public HashMap<String,Object> querysjinfo(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		HashMap<String,Object> ModelMap1 = new HashMap<String,Object>();
		ModelMap.put("ddinfo", service.queryddinfo(map));//根据事件id查询调度信息
		ModelMap.put("slinfo", service.queryslinfo(map));//根据事件id查询受理信息
		List<Zhdd_event_flow> flow = service.querylcinfo(map);
		ModelMap.put("lcinfo", flow);//根据事件id查询事件处置流程信息
		List<Zhdd_event_attachment> fkattachment=null;
		if(flow!=null&&flow.size()>0){
			ModelMap1.put("fk_event_id", flow.get(flow.size()-1).getPk_id());
			fkattachment = service.queryZhdd_event_attachment(ModelMap1);
		}
		ModelMap.put("fkfiles", fkattachment);//反馈附件信息
		
		List<Zhdd_event_attachment> resultattachment=null;
		Zhdd_event_result result = service.querysjjg(map);
		ModelMap.put("hfjg", result);//根据事件id查询事件处置结果
		if(result!=null){
			ModelMap1.put("fk_event_id", result.getPk_id());
			resultattachment = service.queryZhdd_event_attachment(ModelMap1);
		}
		ModelMap.put("resultfiles", resultattachment);//反馈附件信息
		return ModelMap;
	}
	
	/**
	 * 根据事件id查询受理信息
	 * @param map
	 * @return
	 */
	@RequestMapping("queryslinfobysjid")
	public HashMap<String,Object> queryslinfobysjid(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> ModelMap = new HashMap<String,Object>();
		ModelMap.put("slinfo", service.queryslinfo(map));//根据事件id查询受理信息
		return ModelMap;
	}

	/**
	 * 更新事件信息
	 * @param map
	 * @return
	 */
	@RequestMapping("updateevent")
	public Integer updateeventinfo(@RequestBody HashMap<String,Object> map){
		try {
			service.updateZhdd_event_information(map);
			service.updateZhdd_event_acceptance(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
		
	}
	
	
	/**
	 * 下载
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("download")
	public void downloadFiles(@RequestBody HashMap<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, String> urlByLoanid= new HashMap<String,String>();
		try {
			String attachment_source = map.get("attachment_source").toString();//附件路径
			String fileName=map.get("attachment_name").toString();//附件名称
			URL url = new URL(attachment_source);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			//设置超时间为3秒  
			conn.setConnectTimeout(3*1000);
			//防止屏蔽程序抓取而返回403错误  
			conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			//得到输入流  
			InputStream inputStream = conn.getInputStream();
			//获取自己数组  
			byte[] bs = readInputStream(inputStream); 
			response.setContentType("application/octet-stream;charset=ISO8859-1");
			BufferedOutputStream output = null;
			BufferedInputStream input = null;
			try {
				output = new BufferedOutputStream(response.getOutputStream());
				// 中文文件名必须转码为 ISO8859-1,否则为乱码
				String fileNameDown = new String(fileName.getBytes(), "ISO8859-1");
				// 作为附件下载
				response.setHeader("Content-Disposition", "attachment;filename=" + fileNameDown);
				output.write(bs);
				response.flushBuffer();
				
			} catch (Exception e) {
				System.err.println("Download log file error"+"----"+e.getMessage());// 用户可能取消了下载
			}finally{
				if (input != null)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				if (output != null)
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
			
		} catch (Exception e) {
			
		}
	}


	/**
	 * 从输入流中获取字节数组
	 * @param inputstream
	 * @return
	 * @throws IOException
	 */
	public static byte[] readInputStream(InputStream inputstream) throws IOException{
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while((len = inputstream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
			}
		bos.close();
		return bos.toByteArray();
		}
	/**
	 * 更新事件处置结果
	 * @param map
	 * @return
	 */
	@RequestMapping("updateresult")
	public Integer updateZhdd_event_result(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			HashMap<String, Object> map1=new HashMap<String,Object>();
			map1.put("fk_event_id", map.get("pk_id"));
			service.delZhdd_event_attachment(map1);//删除流程附件
			 Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
			 for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String a=System.currentTimeMillis()+""+(int)(Math.random() * 99999);
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
					 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
					 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
					 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
					 zhdd_event_attachment.setRemarks("事件管理操作");
					 zhdd_event_attachment.setFk_event_id(map.get("pk_id").toString());
					 zhdd_event_attachment.setPk_id(a);
					 service.addZhdd_event_attachment(zhdd_event_attachment);//新增事件附件
				 }
			 }
			
			service.updateZhdd_event_result(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
	
	/**
	 * 更新事件处置流程
	 * @param map
	 * @return
	 */
	@RequestMapping("updateflow")
	public Integer updateZhdd_event_flow(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			HashMap<String, Object> map1=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
//			 String liuc=System.currentTimeMillis()+""+(int)(Math.random() * 99999);//流程唯一id
//			 map.put("pk_id", liuc);
			//根据流程id删除流程附件
			map1.put("fk_event_id", map.get("pk_id"));
			service.delZhdd_event_attachment(map1);//删除流程附件
			 Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
			 for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String a=System.currentTimeMillis()+""+(int)(Math.random() * 99999);
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
					 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
					 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
					 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
					 zhdd_event_attachment.setRemarks("事件管理操作");
					 zhdd_event_attachment.setFk_event_id(map.get("pk_id").toString());
					 zhdd_event_attachment.setPk_id(a);
					 service.addZhdd_event_attachment(zhdd_event_attachment);//新增事件附件
				 }
			 }
			
			service.updateZhdd_event_flow(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
	
	/**
	 * 添加事件处置流程
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/addflow")
	public Integer addflow(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			 String liuc=System.currentTimeMillis()+""+(int)(Math.random() * 99999);//流程唯一id
			 map.put("pk_id", liuc);
			 Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
			 for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String a=System.currentTimeMillis()+""+(int)(Math.random() * 99999);
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
					 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
					 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
					 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
					 zhdd_event_attachment.setRemarks("事件管理操作");
					 zhdd_event_attachment.setFk_event_id(liuc);
					 zhdd_event_attachment.setPk_id(a);
					 service.addZhdd_event_attachment(zhdd_event_attachment);//新增事件附件
				 }
			 }
			return service.addflow(map);
		} catch (Exception e) {
			return 2;
		}
	}
	/**
	 * 添加事件处置结果
	 * @param map
	 * @return
	 */
	@RequestMapping("addresult")
	public Integer addresult(List<MultipartFile> files,String data){
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Map<String, Object> map=new HashMap<String,Object>();
			map = objectMapper.readValue(data, Map.class); //JSON转Map
			 String liuc=System.currentTimeMillis()+""+(int)(Math.random() * 99999);//流程唯一id
			 map.put("pk_id", liuc);
			 Zhdd_event_attachment zhdd_event_attachment=new Zhdd_event_attachment();
			 for (MultipartFile multipartFile : files) {
				 if (!multipartFile.isEmpty()){
					 System.err.println(multipartFile.getOriginalFilename());
					 String uploadService = FileUtil.FileUploadService(multipartFile);
					 System.err.println(uploadService);
					 int index = multipartFile.getOriginalFilename().lastIndexOf(".");
					 String a=System.currentTimeMillis()+""+(int)(Math.random() * 99999);
					 String	suffix=multipartFile.getOriginalFilename().substring(index+1, multipartFile.getOriginalFilename().length());
					 zhdd_event_attachment.setAttachment_name(multipartFile.getOriginalFilename());//附件名称
					 zhdd_event_attachment.setAttachment_suffix(suffix);//附件后缀名
					 zhdd_event_attachment.setAttachment_size(String.valueOf(multipartFile.getSize()));//附件大小
					 zhdd_event_attachment.setAttachment_source(uploadService);//附件路径
					 zhdd_event_attachment.setRemarks("事件管理操作");
					 zhdd_event_attachment.setFk_event_id(liuc);
					 zhdd_event_attachment.setPk_id(a);
					 service.addZhdd_event_attachment(zhdd_event_attachment);//新增事件附件
				 }
			 }
			service.addresult(map);
			return 1;
		} catch (Exception e) {
			return 2;
		}
	}
	
	/**
	 * 更新事件处置结果
	 * @param map
	 * @return
	 */
	@RequestMapping("updateResult")
	public Integer updateResult(@RequestBody HashMap<String,Object> map){
		try {
			
			Integer updateResult = service.updateResult(map);
			if(updateResult>0) {
				return 1;//成功
			}else {
				return 2;//失败
			}
			
		} catch (Exception e) {
			return 2;
		}
	}
	
}