package com.cist.dept.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dept.model.Depart_info;
import com.cist.dept.model.Sysdepttype;
import com.cist.dept.model.Sysmoduleinfo;
import com.cist.dept.service.DeptService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/***
 * 
 * @Title:  PictureController.java   
 * @Package com.cist.offsite.controller.firsttrial.picture   
 * @Description:    部门
 * @author: 王涛    
 * @date:   2018年5月10日 下午4:27:35 
 * @version V1.0
 */
@RestController
@RequestMapping("department")
public class DeptController{
    
	@Value("${server.port}")
	private String port;
	
	@Autowired
	private DeptService deptService;
	/***
	 * 部门分页查询
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("querylist")
	public PageInfo<Sysmoduleinfo> querylist(@RequestBody HashMap<String,Object> modelMap ){
		Integer pageSize= Integer.parseInt(modelMap.get("pageSize").toString());//每页有显示多少条
		//获取分页数据位置,每页显示16条数据
 		PageHelper.startPage(Integer.valueOf(modelMap.get("currentPage").toString()),pageSize, true);
		List<Sysmoduleinfo> list= deptService.querylistpageList(modelMap);
		PageInfo<Sysmoduleinfo> pageinfo=new PageInfo<Sysmoduleinfo>(list,5);
		 return pageinfo;
	}
	/***
	 * 机构类型关联
	 * @return
	 */
	@RequestMapping("sysdepttype")
	public List<Sysdepttype> sysdepttype(){
		 return  deptService.sysdepttype();
	}
	/***
	 * 删除部门
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("delSysmoduleinfo")
	public Integer delSysmoduleinfo(@RequestBody HashMap<String,Object> modelMap ){
	String 	dept_pk=modelMap.get("dept_pk").toString();
	modelMap.put("dept_pk", dept_pk.split(","));
		 return  deptService.delSysmoduleinfo(modelMap);
	}
	@RequestMapping("addDepart_info")
	public Integer addDepart_info(@RequestBody HashMap<String,Object> modelMap ){
		if(deptService.selectdept_code(modelMap)>0) {
			 return 2;
		}else {
			 return  deptService.addDepart_info(modelMap);
		}
		
	}
	/***
	 * 更新
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("updateDepart_info")
	public Integer updateDepart_info(@RequestBody HashMap<String,Object> modelMap ){
		if(deptService.selectdept_code(modelMap)>0) {
			 return 2;
		}else {
			 return  deptService.updateDepart_info(modelMap);
		}
		
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
	@RequestMapping("departinfo")
	public String departinfo() throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=deptService.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodg(departinfo); 
	String json=mapper.writeValueAsString(getdiwfdidian(list));
	return json.substring(1, json.length()-1);
	}	
	public List<HashMap<String, Object>> getdiwfdidian(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
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
			List<Depart_info> list= deptService.depart_infolist(depart_info.getDept_pk());
			depart_info.setChildren(list);
			if(null!=list){
				departinfodg(list);
			}
		}
		return departinfo;
	}
	/***
	 * 已经选择的部门
	 * @return
	 * @throws JsonProcessingException
	 */
	private List<String> deptpk=null;
	@RequestMapping("choicedepartinfo")
	public String choicedepartinfo(@RequestBody HashMap<String,Object> modelMap ) throws JsonProcessingException{
		deptpk=new ArrayList<String>();
		//已选中的树
		List<HashMap<String,Object>> listmap=new ArrayList<HashMap<String,Object>>();
		String info=modelMap.get("dept_pk").toString();
		String jie[]=info.substring(1,info.length()-1).split(",");
		Integer level=-1;//树结构位置
		for (String string : jie) {
			HashMap<String,Object> map =new HashMap<String, Object>();
			String pkleve[]=string.split("_");
			map.put("dept_pk", pkleve[0].trim());
			map.put("dept_level", pkleve[1].trim());
			deptpk.add(pkleve[0].trim());
			listmap.add(map);
			if(level==-1) {//初始值
				level=Integer.valueOf(pkleve[1].trim());
			}else {
				if(level>Integer.valueOf(pkleve[1].trim())) {
					level=Integer.valueOf(pkleve[1].trim());
				}
			}
		}
		//选中的顶级菜单
		List<String>  deptdev=new ArrayList<String>();
		//已选中的上级结构
		for (HashMap<String, Object> hashMap : listmap) {
			isshangji(hashMap.get("dept_pk").toString(),listmap);
			if(!lost) {
				deptdev.add(hashMap.get("dept_pk").toString());//顶级菜单
			}
		}
	//上级的下级
	List<Depart_info> depart_info=deptService.departinfolistpk(deptdev);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=xiaji(depart_info); 
	String json=mapper.writeValueAsString(getdepartchoiceinfo(list));
	//json=json.substring(1, json.length()-1);
	return json;
	}	
	public List<HashMap<String, Object>> getdepartchoiceinfo(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			map.put("checked",true);
			
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdepartchoiceinfo(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	//查询下级菜单
	public List<Depart_info> xiaji(List<Depart_info> depart_info){//父节点
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		for (Depart_info depart : depart_info) {//父节点
			modelMap.put("dept_superior",depart.getDept_pk());
			List<Depart_info> list= deptService.departcho(modelMap);//查询当前部门的下级部门
			xiaji(xiajiwhil(list,depart));
			
		}
		return depart_info;
	}
	public List<Depart_info> xiajiwhil(List<Depart_info> depart_info,Depart_info a){//下级部门
		HashMap<String,Object> modelMap=new HashMap<String, Object>();
		for (Depart_info depart_info2 : depart_info) {//下级部门
			Iterator<String> it = deptpk.iterator();//用户选中的部门
			Boolean istr=true;
			while(it.hasNext()){
			    String x = it.next();
			    if(depart_info2.getDept_pk().toString().equals(x)){
			        it.remove();
			        a.getChildren().add(depart_info2);
			        modelMap.put("dept_superior",depart_info2.getDept_pk());
			        List<Depart_info> list= deptService.departcho(modelMap);
			        xiajiwhil(list,depart_info2);
			        istr=false;
			        break;//退出while循环
			    }
			}
			if(istr) {
				modelMap.put("dept_superior",depart_info2.getDept_pk());
				List<Depart_info> list= deptService.departcho(modelMap);
				xiajiwhil(list,a);
			}
		}
		return depart_info;
	}
	/***
	 * 判断上前树是否有上级  有true
	 * @return
	 */
    private Boolean lost=true;
   public Boolean isshangji(String pk,List<HashMap<String,Object>> map) {
	  String pks=deptService.shangji(pk);//当前树的上级
	  if(null==pks||pks.equals("")) {//顶级菜单支队
		  lost=false;
		  return lost;
	  }
	   for (HashMap<String, Object> hashMap : map) {
		   if(hashMap.get("dept_pk").toString().equals(pks.toString())) {
			   //当前已经有上级菜单
			   lost=true;
			   break;
		   }
		   lost=false;
	   }
	   if(!lost) {//层层叠加上级树
		   isshangji(pks,map);
	   }
	   return lost;
   }	
	
	public List<Depart_info> departchoice(List<Depart_info> departinfo,HashMap<String,Object> modelMap){
		for (Depart_info depart_info : departinfo) {
			modelMap.put("dept_superior", depart_info.getDept_pk());
			List<Depart_info> list= deptService.departcho(modelMap);
			depart_info.setChildren(list);
			if(null!=list){
				departchoice(list,modelMap);
			}
		}
		return departinfo;
	}
	public List<HashMap<String, Object>> getdepartchoice(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("isLeaf", depart_info.getIsLeaf());
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdepartchoice(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
	/***
	 * 用户数据权限已选用户
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("departinfoAlready")
	public String departinfoAlready(@RequestBody HashMap<String,Object> modelMap) throws JsonProcessingException{
    //顶级部门 null
	List<Depart_info>	departinfo=deptService.depart_infolist(null);
	ObjectMapper mapper = new ObjectMapper();	
	List<Depart_info> list=departinfodgAlready(departinfo,modelMap); 
	String json=mapper.writeValueAsString(getdiwfdidianAlready(list));
	return json.substring(1, json.length()-1);
	}	
	public List<Depart_info> departinfodgAlready(List<Depart_info> departinfo,HashMap<String,Object> modelMap){
		for (Depart_info depart_info : departinfo) {
			//查询是否有用户信息
			modelMap.put("sypi_dept", depart_info.getDept_pk());
			depart_info.setChildren(deptService.selectdepuser(modelMap));//部门下的用户
			modelMap.put("Dept_pk", depart_info.getDept_pk());
			List<Depart_info> list= deptService.sDepartinfo(modelMap);
			if(depart_info.getChildren().size()>0) {
				depart_info.getChildren().addAll(list);
			}else {
				depart_info.setChildren(list);
			}
			if(null!=list){
				departinfodgAlready(list,modelMap);
			}
		}
		return departinfo;
	}
	public List<HashMap<String, Object>> getdiwfdidianAlready(List<Depart_info> list){
		List<HashMap<String, Object>> listmap=new ArrayList<HashMap<String, Object>>();
		for (Depart_info depart_info : list) {
			HashMap<String, Object> map=new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_pk().toString());
			map.put("checked",true);
			if(null!=depart_info.getChildren()) {//下级
				map.put("children", getdiwfdidianAlready(depart_info.getChildren()));
				listmap.add(map);
			}else {
				listmap.add(map);
			}
		}
		return listmap;
	}
}
