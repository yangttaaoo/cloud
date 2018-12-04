package com.cist.depttestin.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cist.depttestin.model.Attachment;
import com.cist.depttestin.model.DeptInfo;
import com.cist.depttestin.model.Testin;
import com.cist.depttestin.service.TestinService;
import com.cist.frame.page.PageInfo;
import com.cist.utils.FileUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("depttest")
public class TestinController {
  @Autowired
  private TestinService service;
  /**
   * 查询所有
   * @param map
   * @return
   */
  @RequestMapping("all")
  public PageInfo<Testin> selectData(@RequestBody HashMap<String, Object> map){
		try {
			PageInfo page = new PageInfo();
			page.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
			page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
			PageInfo<Testin> info = (PageInfo<Testin>) service.selectDatapageList(map, page);
			return info;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	  
  }
  /**
	 * 增加数据
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/add")
	public Integer addData(List<MultipartFile> file,String data){
		String fileUploadService = null;
		   ObjectMapper objectMapper = new ObjectMapper();
			HashMap<String,Object> map1=new HashMap<String,Object>();
			HashMap<String,Object> map2=new HashMap<String,Object>();
			HashMap<String,Object> map3=new HashMap<String,Object>();
			try {
				map1 = objectMapper.readValue(data, HashMap.class); //JSON转Map
				//data为前台传递的参数JSON参数字符串	
			} catch (JsonParseException e) {	
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			map1.put("fk_dept_id",map1.get("fk_dept_id").toString());
			map1.put("data_sources_type",map1.get("data_sources_type").toString());
			map1.put("assessment_type",1);
			map1.put("start_date",map1.get("start_time").toString());
			map1.put("end_date",map1.get("end_time").toString());
			map1.put("explain",map1.get("explain").toString());
			map1.put("input_person",map1.get("input_person").toString());
			map1.put("input_time", map1.get("input_time").toString());
		 	Integer in=service.addData(map1);
			List<Integer> fk_topic_id= (List<Integer>) map1.get("fk_topic_id");
			List<Integer> arr=(List<Integer>) map1.get("arr");
			for(int i=0;i<fk_topic_id.size();i++){
				Integer pk=service.selectPk();//查询增加的PK关联到下一张表中
			 	map2.put("fk_comp_assessment_id", pk);
			 	map2.put("fk_topic_id",fk_topic_id.get(i));
				for(int j=0+i;j<arr.size();j++){
					map2.put("metrics_num",arr.get(j) );
					Integer zhibiao=service.addTarget(map2);
					break;
				}
			}
		 	if(file!=null){
		 	for (int i = 0; i < file.size(); i++) {
		 	   MultipartFile file1 = file.get(i);
			   fileUploadService = FileUtil.FileUploadService(file1);
			String   fileup= fileUploadService.substring(fileUploadService.lastIndexOf("/")+1,fileUploadService.length());
		 	   Integer pk=service.selectPk();//查询增加的PK关联到下一张表中
			   map3.put("fk_relation_id", pk);
		 	   map3.put("attachment_name", fileup.substring(0,fileup.indexOf(".")));
		 	   map3.put("attachment_suffix", fileup.substring(fileup.indexOf(".")+1,fileup.length()));
	           map3.put("attachment_size", file1.getSize()/1024);
	           map3.put("attachment_source", fileUploadService);
		 	   map3.put("fk_commit_person_id", map1.get("input_person").toString());
	           Integer fujian=service.addBag(map3);
		 	}
	      }
			return 1;	
	}
	/**
	 * 所属部门
	 */
			@RequestMapping("deptinfo")
			public String deptinfo()throws JsonProcessingException{
		    //顶级部门
			List<DeptInfo>	departinfo=service.depart_infolist(null);
			ObjectMapper mapper = new ObjectMapper();
			List<DeptInfo> list=departinfodg(departinfo);
			String json=mapper.writeValueAsString(getdiwfdidian(list));
			return json.substring(1, json.length()-1);
			}
			public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list){
				List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
				for (DeptInfo depart_info : list) {
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("title", depart_info.getName());
					map.put("key", depart_info.getDept_pk());
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
			public List<DeptInfo> departinfodg(List<DeptInfo> departinfo){
			for (DeptInfo depart_info : departinfo) {
			//部门
			List<DeptInfo> list= service.depart_infolist(depart_info.getDept_pk());
				if(list.size()!=0){
					depart_info.setChildren(list);
					departinfodg(list);
				}
			  }
		     return departinfo;
			}
	/**
	 * 查询附件名
	 */
	@RequestMapping("attachment")
	public List<Attachment> selectAttach(@RequestBody HashMap<String,Object> map){
		List<Attachment> att=service.selectAttach(map);
		return  att;
	}
	/**
	 * 增加数据
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/update")
	public Integer updateData(List<MultipartFile> file,String data){
		String fileUploadService = null;
	 	String ip="";
		   ObjectMapper objectMapper = new ObjectMapper();
		    HashMap<String,Object> map=new HashMap<String,Object>();
			HashMap<String,Object> map1=new HashMap<String,Object>();
			HashMap<String,Object> map2=new HashMap<String,Object>();
			HashMap<String,Object> map3=new HashMap<String,Object>();
			HashMap<String,Object> map4=new HashMap<String,Object>();
			//获取本机IP地址
			InetAddress addr;
			try {
				addr = InetAddress.getLocalHost();
				ip=addr.getHostAddress();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
			try {
				map = objectMapper.readValue(data, HashMap.class); //JSON转Map
				//data为前台传递的参数JSON参数字符串	
			} catch (JsonParseException e) {	
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//修改单位
			map1.put("start_date",map.get("start_time").toString());
			map1.put("end_date",map.get("end_time").toString());
			map1.put("explain",map.get("explain").toString());
			map1.put("pk_id",map.get("pk_id").toString());
		 	Integer in=service.updateData(map1);
		 	//修改指标
			map2.put("fk_comp_assessment_id", map.get("pk_id"));
			map2.put("fk_topic_id",map.get("fk_topic_id"));
			map2.put("metrics_num",map.get("metrics_num"));
			Integer zhibiao=service.updateTarget(map2);
		    //修改文件
		 	if(file!=null){
		 	for (int i = 0; i < file.size(); i++) {
		 	   MultipartFile file1 = file.get(i);
			   fileUploadService = FileUtil.FileUploadService(file1);
				String   fileup= fileUploadService.substring(fileUploadService.lastIndexOf("/")+1,fileUploadService.length());
		 	   map3.put("attachment_name", fileup.substring(0,fileup.indexOf(".")));
		 	   map3.put("attachment_suffix", fileup.substring(fileup.indexOf(".")+1,fileUploadService.length()));
	           map3.put("attachment_size", file1.getSize()/1024);
	           map3.put("attachment_source", fileUploadService);
	           Integer fujian=service.updateBag(map3);
		 	}
	      }
		 	//增加日志
		 	if(map.get("edit_reason").toString()!=""){
		 		map4.put("edit_reason", map.get("edit_reason").toString());
		 		map4.put("fk_relation_id", map.get("pk_id").toString());
		 		map4.put("data_before", map.get("data_before").toString());
		 		map4.put("data_after", map.get("data_after").toString());
		 		map4.put("edit_time", map.get("edit_time").toString());
		 		map4.put("fk_edit_user_id", map.get("fk_edit_user_id").toString());
		 		map4.put("ip_address", ip);
		 		Integer log=service.addLog(map4);
		 	}
			return in;	
	}
	/**
	 * 删除数据
	 * @param map
	 * @return
	 */
	@RequestMapping("delete")
	public Integer deleteData(@RequestBody HashMap<String,Object> map){
		if(map.get("pk_id").toString()!=null || map.get("pk_id").toString()!=""){
			 Integer in1=service.deleteData(map);
			 return in1;
		}
		if(map.get("pk_id").toString()!=""){
			 Integer in2=service.deleteBag(map);
			 return in2;
		}
		if(map.get("pk_id").toString()!=""){
			 Integer in3=service.deleteTarget(map);
			 return in3;
		}	
		return 0;
	}
	/**
	 * 审核
	 * @param map
	 * @return
	 */
	@RequestMapping("check")
	public Integer  addCheck(@RequestBody HashMap<String,Object> map){
		HashMap<String,Object> has= new HashMap<String,Object>();
		if(map.get("pk_id").toString()!=""){
		has.put("verify_status", map.get("verify_status"));
		has.put("record_invalid_reason", map.get("record_invalid_reason").toString());
		has.put("verify_not_pass_reason", map.get("verify_not_pass_reason").toString());
		has.put("fk_verify_person_id", map.get("fk_verify_person_id").toString());
		has.put("pk_id", map.get("pk_id").toString());
		}
		Integer  ch=service.addCheck(has);
		return ch;	
	}
	
}
