package com.cist.picture.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.picture.mapper.PictureMapper;
import com.cist.picture.model.C_plate_type;
import com.cist.picture.model.Depart_info;
import com.cist.picture.model.MenuDetails;
import com.cist.picture.model.Monitorpoint;
import com.cist.picture.model.Tbl_offe_cate;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.picture.service.PictureService;


@Service
public class PictureServiceImpl implements PictureService  {

	@Autowired
	private PictureMapper mapper;
	@Override
	public List<Tbl_offe_evdi> querylistpageList(HashMap<String,Object> map) {
		return mapper.querylistpageList(map);
	}
	@Override
	public Integer updateTbloffeevdi(HashMap<String, Object> map) {
		return mapper.updateTbloffeevdi(map);
	}
	@Override
	public List<C_plate_type> plateTypeList() {
		
		return mapper.plateTypeList();
	}
	@Override
	public List<Tbl_offe_cate> tblOffeCateList() {
		return mapper.tblOffeCateList();
	}

	@Override
	public Tbl_offe_cate tblOffeCate(HashMap<String, Object> map) {
		return mapper.tblOffeCate(map);
	}
	@Override
	public List<Depart_info> depart_infolist(Integer dept_superior) {
		
		return mapper.depart_infolist(dept_superior);
	}
	@Override
	public List<Depart_info> Monitorpoint(String tbmp_dept_code) {
		return mapper.Monitorpoint(tbmp_dept_code);
	}
	@Override
	public List<Depart_info> acquisition(String tbmp_dept_code) {
		return mapper.acquisition(tbmp_dept_code);
	}
	private MenuDetails listAsTree(List<MenuDetails> list,Map<Long,MenuDetails> mapCopy)
	{
	
		Iterator<MenuDetails> iterator = list.iterator();
		MenuDetails au = null;
		MenuDetails root = null;
		while(iterator.hasNext())
		{
			au = iterator.next();
			if(au.getFUN_PARENT() != null)
			{
				root = mapCopy.get(au.getFUN_PARENT());
				if(root != null)
				{
					root.getChildren(false).add(au);
					iterator.remove();
				}
				
			}
		}
		return list.iterator().next();
	}
	  private String [] toAuthority(Map<Long,MenuDetails> map,List<MenuDetails> list){
		  List<String> attribtes = new ArrayList<String>();
		  
		  String attribute = null;
		  
		  Iterator<MenuDetails> iterator = list.iterator();
		  MenuDetails menuDatails = null;
		  while(iterator.hasNext())
		  {
				menuDatails = iterator.next();
				attribute = menuDatails.getFUN_TUG();
				if(attribute!=null && !"".equals(attribute))
				{
					attribtes.add(menuDatails.getFUN_NAME());
					iterator.remove();
				}
				else
				{
					map.put(menuDatails.getFUN_ID(), menuDatails);
				}
		  }
		  String values [] = new String [attribtes.size()];
		  return attribtes.toArray(values);
	  }
	@Override
	 public List<MenuDetails> queryAccountAuthorityForList(Integer police_code){
		  try
		  {
			  List<MenuDetails> list = mapper.queryAccountAuthorityForList(police_code);
			  if(list != null && list.get(0) != null)
			  {
				  Map<Long,MenuDetails>  map = new ConcurrentHashMap<Long,MenuDetails>();
				  String [] attribtes = toAuthority(map,list);
				  MenuDetails  menuDetails = listAsTree(list,map);
				  menuDetails.setAttributes(attribtes);
				 // return menuDetails;
				  return list;
			  }
		  }
		  catch(Exception e)
		  {
			 System.err.println(e.getLocalizedMessage());
		  }
		  return null;
	  }
	@Override
	public List<Depart_info> clickdepartinfo(String dept_superior) {
		return mapper.clickdepartinfo(dept_superior);

}
	@Override
	public List<Depart_info> kakou(HashMap<String,Object> map) {
		return mapper.kakou(map);
	}
	@Override
	public List<Depart_info> yijicdepartinfo(HashMap<String,Object> map) {
		return mapper.yijicdepartinfo(map);
	}
	@Override
	public List<Depart_info> kakouxiabu(HashMap<String, Object> map) {
		return mapper.kakouxiabu(map);
	}
	@Override
	public Integer auditnumber(HashMap<String, Object> map) {
		return mapper.auditnumber(map);
	}
	@Override
	public Integer sycivalue(HashMap<String, Object> map) {
		return mapper.sycivalue(map);
	}
	@Override
	public Integer getjintiri(HashMap<String, Object> map) {
		return mapper.getjintiri(map);
	}
	@Override
	public Integer quantity() {
		return mapper.quantity();
	}
	@Override
	public Integer selectExtract(HashMap<String,Object> map) {
		return mapper.selectExtract(map);
	}
	@Override
	public Object selectAllExtractpageList(HashMap<String, Object> map, PageInfo p) {
		
			return mapper.selectAllExtract(map);
		
	}
	@Override
	public Integer tiqu(HashMap<String, Object> map) {
		return mapper.tiqu(map);
	}
}