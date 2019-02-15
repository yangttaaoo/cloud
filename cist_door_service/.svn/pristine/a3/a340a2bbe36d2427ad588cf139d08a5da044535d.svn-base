package com.cist.kreis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.frame.page.PageInfo;
import com.cist.kreis.model.KreisInfo;
import com.cist.kreis.model.KreisLevelInfo;
import com.cist.kreis.model.TbekInfo;
import com.cist.kreis.service.KreisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



/***
 * 
 * @Title:  KerisController.java   
 * @Package com.cist.kreis.controller
 * @Description:    行政区划管理
 * @author: 田隽杭    
 * @date:   2018年6月25日 下午3:12:35 
 * @version V1.0
 */
@RestController
@RequestMapping("/keris")
public class KreisController {
	@Autowired
	private KreisService service;
	/**
	 * 行政区划首页查询
	 * @param map
	 */
	@RequestMapping("kerisInfoList")
    public PageInfo<KreisInfo> redInfopageList(@RequestBody HashMap<String,Object> modelMap ){
    	PageInfo pinfo = new PageInfo();
	    pinfo.setPageNum(Integer.parseInt(modelMap.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(modelMap.get("pageSize").toString()));
    	PageInfo<KreisInfo> list= (PageInfo<KreisInfo>)service.kerisInfopageList(modelMap,pinfo);
    	for (int i = 0; i < list.getList().size(); i++) {
    		if(list.getList().get(i).getTbek_parent()==null){
    			list.getList().get(i).setTbek_parent_name("最上级行政区划");
    		}else {
    			KreisInfo plate = service.getTbekname(list.getList().get(i).getTbek_parent());
    			list.getList().get(i).setTbek_parent_name(plate.getTbek_name());
			}
		}
		return list;
	}
	/**
	 * 行政区划删除
	 * @param map
	 */
	@RequestMapping("delKreis")
	public int  delRedInfo(@RequestBody HashMap<String,Object> modelMap){
		String 	dept_pk=modelMap.get("tbek_pk").toString();
		modelMap.put("tbek_pk", dept_pk.split(","));
		int status = service.delKreis(modelMap);
		return status;
	}
	/**
	 * 行政区划等级查询
	 */
	@RequestMapping("kreisLevel")
	public  HashMap<String,Object>  kreisLevelList(){
		HashMap<String, Object> modelMap=new HashMap<String, Object>();	
		modelMap.put("kreisLevelList", service.kreisLevelList());
		return modelMap;
	}
	/**
	 * 行政区划管理新增
	 * @param map
	 */
	@RequestMapping("addKreis")
	public int  addKreis(@RequestBody HashMap<String,Object> modelMap){
		modelMap.put("tbek_simp_spell",ToFirstChar(modelMap.get("tbek_name").toString()).toUpperCase());
		modelMap.put("tbek_first_letter",modelMap.get("tbek_simp_spell").toString().substring(0,1));
		int status = service.addKreis(modelMap);
		return status;
	}
	/**
	 * 行政区划管理修改
	 * @param map
	 */
	@RequestMapping("editKreis")
	public int  editKreis(@RequestBody HashMap<String,Object> modelMap){
		modelMap.put("tbek_simp_spell",ToFirstChar(modelMap.get("tbek_name").toString()).toUpperCase());
		modelMap.put("tbek_first_letter",modelMap.get("tbek_simp_spell").toString().substring(0,1));
		int status = service.editKreis(modelMap);
		return status;
	}
		/**
	      * 获取字符串拼音的第一个字母
	      * @param chinese
	      * @return
	      */
	     public static String ToFirstChar(String chinese){         
	         String pinyinStr = "";  
	         char[] newChar = chinese.toCharArray();  //转为单个字符
	         HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat(); 
	         defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
	         defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
	         for (int i = 0; i < newChar.length; i++) {  
	             if (newChar[i] > 128) {  
	                 try {  
	                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0].charAt(0);  
	                 } catch (BadHanyuPinyinOutputFormatCombination e) {  
	                     e.printStackTrace();  
	                }  
	            }else{  
	                 pinyinStr += newChar[i];  
	             }  
	         }  
	        return pinyinStr;  
	     }  
	     @RequestMapping("tbekparent")
			public String deptinfo()throws JsonProcessingException{
		    //顶级行政区划
			List<TbekInfo>	departinfo=service.tbek_infolist(null);
			ObjectMapper mapper = new ObjectMapper();
			List<TbekInfo> list=departinfodg(departinfo);
			String json=mapper.writeValueAsString(getdiwfdidian(list));
			return json.substring(1, json.length()-1);
			}
			public List<HashMap<String, Object>> getdiwfdidian(List<TbekInfo> list){
				List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
				for (TbekInfo depart_info : list) {
					HashMap<String, Object> map=new HashMap<String, Object>();
					map.put("title", depart_info.getTbek_name());
					map.put("key", depart_info.getTbek_pk());
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
			public List<TbekInfo> departinfodg(List<TbekInfo> departinfo){
			for (TbekInfo depart_info : departinfo) {
			//部门
			List<TbekInfo> list= service.tbek_infolist(depart_info.getTbek_pk());
				if(list.size()!=0){
					depart_info.setChildren(list);
					departinfodg(list);
				}
			  }
		     return departinfo;
			}
}
