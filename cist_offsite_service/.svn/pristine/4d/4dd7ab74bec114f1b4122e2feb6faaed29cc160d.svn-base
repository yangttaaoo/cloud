package com.cist.picture.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.offsite.invalidtrial.model.TblOffeEvdiInfo;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.picture.service.PictureService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/***
 * 
 * @Title:  PictureController.java   
 * @Package com.cist.offsite.controller.firsttrial.picture   
 * @Description:    非现场执法图片筛选功能
 * @author: 王涛    
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("firsttrial")
public class PictureController {
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private PictureService service;
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.offsite.controller.firsttrial.picture   
	 * @Description:    图片筛选列表页面
	 * @author: 王涛    
	 * @date:   2018年5月10日 下午4:27:35 
	 * @param: @param request
	 * @param: @param offeecdi
	 * @param: @return      
	 * @return: ModelAndView      
	 * @throws 
	 * @version V1.0
	 */
	@RequestMapping("querylist")
	public PageInfo<Tbl_offe_evdi> querylist(@RequestBody HashMap<String,Object> modelMap ){
		//获取分页数据位置,每页显示16条数据
		if(modelMap.get("hphm")!=null&&!"".equals(modelMap.get("hphm").toString())) {
			modelMap.put("hphm", modelMap.get("hphm").toString().toUpperCase());
		}
		String pageSize=modelMap.get("pageSize").toString();
		if(modelMap.get("sbbh")!=null&&!"".equals(modelMap.get("sbbh").toString())) {
			String sbbh=modelMap.get("sbbh").toString();
			if(null!=sbbh&&sbbh!="") {
				sbbh=sbbh.substring(1, sbbh.length()-1);
				if(!sbbh.equals("")) {
					String sbb[]=sbbh.split(",");
					modelMap.put("sbbh", sbb);
				}else {
					modelMap.put("sbbh", null);
				}
			}	
		}
		if("1".equals(modelMap.get("tqFlag"))) {
			Integer tiqu = service.tiqu(modelMap);
		}
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()), Integer.valueOf(pageSize), true);
    	
		List<Tbl_offe_evdi> list= service.querylistpageList(modelMap);
		PageInfo<Tbl_offe_evdi> pageinfo=new PageInfo<Tbl_offe_evdi>(list,10);
		 return pageinfo;
	}
	/***
	 * 已选择 0 项 12日内未审核数：0条 今日审核总计：0 条
	 * @return
	 */
	@RequestMapping("sycivalue")
	public HashMap<String,Object> sycivalue(){
		HashMap<String,Object> modelMap=new HashMap<String,Object>();
		int sycivalue=service.sycivalue(modelMap);
		modelMap.put("sycivalue", sycivalue);//违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue)+" 00:00:00");//开始时间
//		modelMap.put("wfjssj",gettime(0));//结束时间
		modelMap.put("auditnumber", service.auditnumber(modelMap));//违法数据有效期内多少违法数据
		modelMap.put("getjintiri",service.getjintiri(modelMap));//今日审核总计
		
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
	@RequestMapping("authority")
	public List<MenuDetails> authority(){
		 return service.queryAccountAuthorityForList(2020);
	}
	/***
	 * 图片初筛总数
	 * @return
	 */
	@RequestMapping("quantity")
	public Integer quantity(){
		 return service.quantity();
	}
	
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.offsite.controller.firsttrial.picture   
	 * @Description:    图片筛选保存操作，数据作废，处理标志 4
	 * @author: 王涛    
	 * @date:   2018年5月10日 下午4:29:19 
	 * @param: @param modelMap
	 * @param: @param request
	 * @param: @return      
	 * @return: Integer      
	 * @throws 
	 * @version V1.0
	 */
	@RequestMapping("updateevdi")
	public Integer updateevdi(@RequestBody HashMap<String,Object> modelMap ,HttpServletRequest request){
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
			List<String> wfpk=new ArrayList<>();
			String tovoid=modelMap.get("tovoid").toString();
			tovoid=tovoid.substring(1, tovoid.length()-1);
			String h[]=tovoid.split(",");
			for (String string : h) {
				wfpk.add(string.trim());
			}
			modelMap.put("wfpk", wfpk);
			modelMap.put("SXR", userPk);
			modelMap.put("SXSJ",new Date());
		 return service.updateTbloffeevdi(modelMap);
	}
	/***
	 * 号牌种类下拉框
	 * @return
	 */
	@RequestMapping("plateTypeList")
	public List<C_plate_type> plateTypeList(){
		 return service.plateTypeList();
	}
    /***
     * 违法行为下拉框
     * @return
     */
	@RequestMapping("tblOffeCateList")
	public List<Tbl_offe_cate> tblOffeCateList(){
		 return service.tblOffeCateList();
	}
	@RequestMapping("tblOffeCate")
	public Tbl_offe_cate tblOffeCate(@RequestBody HashMap<String,Object> modelMap){
		 return service.tblOffeCate(modelMap);
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    违法地点部门树
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0
	 */
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
			HashMap<String, Object> map=new HashMap<>();
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
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:   采集设备部门树
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0
	 */
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
			HashMap<String, Object> map=new HashMap<>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getTbmp_azdz());
			map.put("isLeaf", depart_info.getIsLeaf());
			map.put("selectable", depart_info.getIsLeaf());
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
			depart_info.setChildren(service.acquisition(depart_info.getDept_code()));
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
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    部门树
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0  
	 */
	@RequestMapping("mendepartinfo")
	public String mendepartinfo() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=service.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodgmen(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidianmen(list));
	return json.substring(1, json.length()-1);
	}	
	public List<HashMap<String, Object>> getdiwfdidianmen(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianmen(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	public List<Depart_info> departinfodgmen(List<Depart_info> departinfo){
		for (Depart_info depart_info : departinfo) {
			List<Depart_info> list= service.depart_infolist(depart_info.getDept_pk());
			depart_info.setChildren(list);
			if(null!=list){
				departinfodgmen(list);
			}
		}
		return departinfo;
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    点击部门树获取设备列表
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0  
	 */
	@RequestMapping("clickdepartinfo")
	public String clickdepartinfo(@RequestBody HashMap<String,Object> modelMap,HttpServletRequest request) throws JsonProcessingException{
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
	List<Depart_info>	departinfo=service.clickdepartinfo(modelMap.get("dept_pk").toString());
	ObjectMapper mapper = new ObjectMapper();	
	String  tbvg_btype=null==modelMap.get("tbvg_btype")?null:modelMap.get("tbvg_btype").toString();
	List<Depart_info> list=clickdepartinfodg(departinfo,userPk,tbvg_btype); 
	String json=mapper.writeValueAsString(getdiwfdidianckick(list));
	return json;
	}	
	public List<HashMap<String, Object>> getdiwfdidianckick(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getTbei_name());
			map.put("key", depart_info.getTbec_kkbh());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianckick(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	/***
	 * 获取采集设备 权限控制
	 * @param departinfo
	 * @return
	 */
	public List<Depart_info> clickdepartinfodg(List<Depart_info> departinfo,String userPk,String tbvg_btype){
		for (Depart_info depart_info : departinfo) {
			HashMap<String, Object> map=new HashMap<>();
			map.put("tbec_kkbh", depart_info.getTbec_kkbh());
			map.put("sypi_pk", userPk);
			map.put("tbvg_btype", tbvg_btype);
			List<Depart_info> list= service.kakou(map);//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	/***
	 * 
	 * @Title:  PictureController.java   
	 * @Package com.cist.picture.controller   
	 * @Description:    点击部门树获取设备列表
	 * @author: 王涛    
	 * @date:   2018年5月16日 上午9:13:10 
	 * @param: @return      
	 * @return: List<Depart_info>      
	 * @throws JsonProcessingException 
	 * @throws 
	 * @version V1.0   
	 */
	@RequestMapping("yijickdepartinfo")
	public String yijickdepartinfo(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{
		List<Depart_info>	departinfo=service.yijicdepartinfo(modelMap);
		ObjectMapper mapper = new ObjectMapper();	
		modelMap.put("departinfo", departinfo);
		List<Depart_info> list=clickdeparckd(modelMap); 
		String json=mapper.writeValueAsString(getdiwfdidianckick(list));
		return json;
	}
	public List<Depart_info> clickdeparckd(HashMap<String,Object> modelMap){
		@SuppressWarnings("unchecked")
		List<Depart_info>	departinfo= (List<Depart_info>) modelMap.get("departinfo");
		for (Depart_info depart_info : departinfo) {
			modelMap.put("tbec_kkbh", depart_info.getTbec_kkbh());
			List<Depart_info> list= service.kakouxiabu(modelMap);//卡口编码
			depart_info.setChildren(list);
		}
		return departinfo;
	}
	
	/***
	 * 查询未审核并且已提取数据的数量
	 * @return
	 */
	@RequestMapping("selectExtract")
	public Integer selectExtract(@RequestBody HashMap<String,Object> map){
		Integer selectExtract = service.selectExtract(map);
		
		return selectExtract;
	}
	
	/***
	 * 提取固定数量的数据
	 * @return
	 */
	@RequestMapping("tiqu")
	public com.cist.frame.page.PageInfo<Tbl_offe_evdi> selectAllExtract(@RequestBody HashMap<String,Object> map){
		com.cist.frame.page.PageInfo pinfo = new com.cist.frame.page.PageInfo();
	    pinfo.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		pinfo.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		
		com.cist.frame.page.PageInfo<Tbl_offe_evdi> pageinfo = (com.cist.frame.page.PageInfo<Tbl_offe_evdi>)service.selectAllExtractpageList(map,pinfo);
		return pageinfo;
		
	}
}
