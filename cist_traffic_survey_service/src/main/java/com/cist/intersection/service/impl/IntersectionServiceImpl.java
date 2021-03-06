package com.cist.intersection.service.impl;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cist.frame.page.PageInfo;
import com.cist.intersection.mapper.IntersectionMapper;
import com.cist.intersection.model.CRoadSegitemInfo;
import com.cist.intersection.model.C_road_item;
import com.cist.intersection.model.Depart_info;
import com.cist.intersection.model.TblSegitemSignal;
import com.cist.intersection.model.TblSigcaseSegitem;
import com.cist.intersection.model.TblTimplanPhase;
import com.cist.intersection.model.TblTimplanSegitem;
import com.cist.intersection.service.IntersectionService;
import com.cist.roadsection.mapper.RoadSectionMapper;
import com.cist.roadsection.model.CKreisCode;
import com.cist.roadsection.model.CRoadItemInfo;
import com.cist.roadsection.model.DeptInfo;
import com.cist.roadsection.model.SysDepartInfo;
import com.cist.roadsection.model.Sys_frm_code;
import com.cist.roadsection.util.FileUtil;
import net.sf.json.JSONObject;

@Service
public class IntersectionServiceImpl implements IntersectionService {
	@Autowired
	private IntersectionMapper mapper;

	@Override
	public Object listpageList(HashMap<String, Object> map, PageInfo p) {
		return mapper.list(map);
	}


	@Override
	public List<TblSegitemSignal> selectSignal(HashMap<String, Object> map) {
		return mapper.selectSignal(map);
	}
	

	@Override
	public List<C_road_item> roadList(HashMap<String, Object> map) {
		return mapper.roadList(map);
	}
	
	@Override
	public List<CKreisCode> kreis(Map<String, Object> map) {
		return mapper.kreis(map);
	}
	
	@Override
	public List<Depart_info> clickdepartinfo(String dept_superior) {
		return mapper.clickdepartinfo(dept_superior);
	}
	
	@Override
	public List<Depart_info> selectRoad(String dept_code) {
		return mapper.selectRoad(dept_code);
	}
	

	@Override
	public List<Depart_info> Monitorpoint(String dept_code) {
		return mapper.Monitorpoint(dept_code);
	}
	
	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		return mapper.depart_infolist(dept_superior);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer delete(HashMap<String, Object> map) {
		return mapper.delete(map);
	}



	@Override
	public List<Sys_frm_code> selectSysFrmCode(String fct_code) {
		return mapper.selectSysFrmCode(fct_code);
	}

	@Override
	public List<CKreisCode> kreisList(Integer bigDecimal) {
		return mapper.kreisList(bigDecimal);
	}

	@Override
	public List<Depart_info> kakou(String tbec_kkbh) {
		return mapper.kakou(tbec_kkbh);
	}
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer save(Map<String, Object> map) {
		
		//新增路口信息
		Integer save = mapper.save(map);
		
		if(save>0)
		{
			//新增信控方案
			Integer saveSignal = saveSignal(map);
		}
		return save;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer saveSignal(Map<String, Object> map) {
		List<MultipartFile> files = (List<MultipartFile>) map.get("files");
		int i=0;//标识循环次数
		Integer saveSignal =null;
		for (MultipartFile multipartFile : files) {
			String fileUploadService = FileUtil.FileUploadService(multipartFile);
			ArrayList list = (ArrayList) map.get("list");
			Map<String,Object> object = (Map<String,Object>)list.get(i++);
			object.put("filePath", fileUploadService);
			object.put("pk", (Integer)map.get("pk"));
			//保存信控方案
			saveSignal= mapper.saveSignal(object);
			if(object.get("lkxx")!=null&&object.get("lkxx").toString().length()>2)
			{
				//信控方案下协调路口关系保存
				mapper.saveXtlk(object);
			}
//			if(map.get("xtlk")!=null&&map.get("xtlk")!="")
//			{
//				saveXtlk(map);
//			}
			Integer xkid = (Integer) object.get("xkid");
			
			ArrayList<HashMap<String,Object>> pslist = (ArrayList<HashMap<String,Object>>) object.get("psxx");
			for (HashMap<String, Object> map2 : pslist) {
				map2.put("xkid", xkid);
				insertSegitem(map2);
				ArrayList xwxxlist= (ArrayList)map2.get("xwxxlist");
				if(xwxxlist.size()>0)
				{
					map2.put("list", xwxxlist);
					//批量新增相位关系信息
					insertXwxx(map2);
				}
				
			}
		}
		
		
		return 	saveSignal;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer deleteXkfa(HashMap<String, Object> map) {
		return mapper.deleteXkfa(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer deletePsxx(HashMap<String, Object> map) {
		return mapper.deletePsxx(map);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer saveSegitem(HashMap<String,Object> map) {
		
		return mapper.saveSegitem(map);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer update(Map<String, Object> map) {
		Integer update = mapper.update(map);
		//信控方案已经单独更新
//		if(update>0)
//		{
//			updateSignal(map);
//		}
		return update;
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer updateSignal(Map<String, Object> map) {
		//更新信控方案
		Integer updateSignal = mapper.updateSignal(map);
		//更新协调路口
		Integer updateXtlk = updateXtlk(map);
		if(updateSignal>0)
		{
			List<HashMap<String,Object>> list=(List<HashMap<String,Object>>)map.get("list");
			HashMap<String,Object> upmap=new HashMap<String,Object>();
			//存储需要批量更新的数据
			List<HashMap<String,Object>> lmap=new ArrayList<HashMap<String,Object>>();
			List<HashMap<String,Object>> ilist=new ArrayList<HashMap<String,Object>>();
			HashMap<String,Object> insertmap=new HashMap<String,Object>();
            for (HashMap<String, Object> hashMap : list) {
            	//根据PK判断数据是更新还是插入
            	if(hashMap.get("pk")!=null)
            {
            		
            		lmap.add(hashMap);
            		//配时信息下面的相位信息批量更新 获取当前配时信息的相位信息并更新
            		ArrayList xwxxlist=(ArrayList)hashMap.get("xwxx");
            		hashMap.put("list", xwxxlist);
            		updateXwxx(hashMap);
            	
            		
            }
            	else{
            		ilist.add(hashMap);
            	}
            	
               }
            //如果有更新的数据就执行更新操作
            if(lmap.size()>0)
            {
            	 upmap.put("list", lmap);
             	insertPsxx(upmap);	
            }
           
        	for (HashMap<String, Object> hashMap : ilist) {
        		//配时信息下面的相位信息批量插入
        		ArrayList xwxxlist=(ArrayList)hashMap.get("xwxx");
        		insertSegitem(hashMap);
        		hashMap.put("list", xwxxlist);
        		insertXwxx(hashMap);
			}
		}
		
		return updateSignal;
	}
	
	@Override
	public Integer saveXtlk(Map<String, Object> map) {
		return mapper.saveXtlk(map);
	}
	
	@Override
	public List<TblTimplanSegitem> selectPsxx(HashMap<String, Object> map) {
		List<TblTimplanSegitem> selectPsxx = mapper.selectPsxx(map);
		for (TblTimplanSegitem tblTimplanSegitem : selectPsxx) {
			List<TblTimplanPhase> selectXwxx = selectXwxx(tblTimplanSegitem.getPk());
			tblTimplanSegitem.setXwxx(selectXwxx);
		}
		return selectPsxx;
	}
	
	@Override
	public Integer insertPsxx(HashMap<String,Object> map) {
		return mapper.insertPsxx(map);
	}
	

	@Override
	public List<C_road_item> road_infolist(HashMap<String, Object> map) {
		return mapper.road_infolist(map);
	}
	

	@Override
	public List<C_road_item> road_point(String m_road_code) {
		return mapper.road_point(m_road_code);
	}

	
	
	
	@Override
	public CKreisCode selectKreis(HashMap<String, Object> map) {
		return mapper.selectKreis(map);
	}

	@Override
	public SysDepartInfo selectDept(HashMap<String, Object> map) {
		return mapper.selectDept(map);
	}

	@Override
	public Sys_frm_code selectLjlx(HashMap<String, Object> map) {
		return mapper.selectLjlx(map);
	}


	@Override
	public List<Depart_info> yijicdepartinfo(HashMap<String, Object> map) {
		return mapper.yijicdepartinfo(map);
	}


	@Override
	public List<Depart_info> kakouxiabu(HashMap<String, Object> map) {
		return mapper.kakouxiabu(map);
	}


	@Override
	public List<C_road_item> selectRoadTree(String dept_superior) {
		return mapper.selectRoadTree(dept_superior);
	}


	@Override
	public List<C_road_item> lukou(String roim_code) {
		return mapper.lukou(roim_code);
	}


	@Override
	public List<C_road_item> checkLukou(HashMap<String, Object> map) {
		return mapper.checkLukou(map);
	}


	@Override
	public List<C_road_item> lukoudm(HashMap<String, Object> map) {
		return mapper.lukoudm(map);
	}


	@Override
	public C_road_item selectRoadName(HashMap<String,Object> map) {
		return mapper.selectRoadName(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer insertSignal(Map<String, Object> map) {
		//新增信控方案
		 Integer insertSignal = mapper.insertSignal(map);
		 if(map.get("lkxx")!=null)
		 {
			 ArrayList<?> object = (ArrayList<?>) map.get("lkxx");
			 if(object.size()>0)
			 {
				 //信控方案下协调路口
					Integer saveXtlk = mapper.saveXtlk(map); 
			 } 
		 }
		
		
		if(insertSignal>0)
		{
			List<HashMap<String,Object>> list=	(List<HashMap<String,Object>>)map.get("list");
			for (HashMap<String,Object> obj : list) {
				obj.put("xkid", map.get("xkid"));
				//新增配时信息
				Integer insertSegitem = insertSegitem(obj);
				ArrayList xwxxlist= (ArrayList)obj.get("xwxxlist");
				if(xwxxlist.size()>0)
				{
					obj.put("list", xwxxlist);
					//批量新增相位关系信息
					insertXwxx(obj);
				}
				
				
		        }  
			}
		return insertSignal;
	}


	@Override
	public Integer insertSegitem(Map<String, Object> map) {
		return mapper.insertSegitem(map);
	}


	@Override
	public Integer insertXwxx(HashMap<String, Object> map) {
		return mapper.insertXwxx(map);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor={Exception.class})
	@Override
	public Integer updateXtlk(Map<String, Object> map) {
		Integer deleteXtlk = mapper.deleteXtlk(map);
			//保存协调路口
		if(((ArrayList)map.get("lkxx")).size()>0)
		{
			Integer updateXtlk = mapper.saveXtlk(map);
			return updateXtlk;
		}
			
			return deleteXtlk;
		
	}


	@Override
	public List<TblTimplanPhase> selectXwxx(Long psfa) {
		return mapper.selectXwxx(psfa);
	}


	@Override
	public List<TblSigcaseSegitem> selectXtlk(HashMap<String, Object> map) {
		return mapper.selectXtlk(map);
	}


	@Override
	public Integer updateXwxx(HashMap<String, Object> map) {
		return mapper.updateXwxx(map);
	}


	@Override
	public TblSegitemSignal selectXksbName(HashMap<String, Object> map) {
		return mapper.selectXksbName(map);
	}


	@Override
	public CRoadSegitemInfo selectXtlkName(HashMap<String, Object> map) {
		return mapper.selectXtlkName(map);
	}


	@Override
	public List<C_road_item> selectXtlkDept(HashMap<String, Object> map) {
		return mapper.selectXtlkDept(map);
	}


	@Override
	public Integer deleteXtlk(Map<String, Object> map) {
		return mapper.deleteXtlk(map);
	}


	@Override
	public C_road_item selectXksbDept(HashMap<String, Object> map) {
		return mapper.selectXksbDept(map);
	}


	@Override
	public Integer getroimcode(HashMap<String, Object> map) {
		return mapper.getroimcode(map);
	}

}
