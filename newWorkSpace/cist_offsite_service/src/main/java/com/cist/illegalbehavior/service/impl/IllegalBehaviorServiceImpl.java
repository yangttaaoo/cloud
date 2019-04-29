package com.cist.illegalbehavior.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.illegalbehavior.mapper.IllegalBehaviorMapper;
import com.cist.illegalbehavior.model.Sys_frm_code;
import com.cist.illegalbehavior.model.TblOffeVioWfxwStat;
import com.cist.illegalbehavior.model.TblWfxwClflStat;
import com.cist.illegalbehavior.model.TblWfxwWfddStat;
import com.cist.illegalbehavior.model.TblWfxwXwStat;
import com.cist.illegalbehavior.model.TblWfxwZdcllStat;
import com.cist.illegalbehavior.service.IllegalBehaviorService;
import com.cist.illegalbehavior.util.MapUtil;

import net.sf.json.JSONObject;


@Service
public class IllegalBehaviorServiceImpl implements IllegalBehaviorService  {

	@Autowired
	private IllegalBehaviorMapper mapper;

	@Override
	public List<TblWfxwXwStat> selectWfxw(HashMap<String, Object> map) {
		return mapper.selectWfxw(map);
	}

	@Override
	public List<TblWfxwClflStat> selectCar(HashMap<String, Object> map) {
		return mapper.selectCar(map);
	}

	@Override
	public List<TblWfxwZdcllStat> selectKeyVehicles(HashMap<String, Object> map) {
		return mapper.selectKeyVehicles(map);
	}

	@Override
	public List<TblOffeVioWfxwStat> selectByWfxw(HashMap<String, Object> map) {
		return mapper.selectByWfxw(map);
	}

	@Override
	public List<TblWfxwWfddStat> selectByWfdd(HashMap<String, Object> map) {
		return mapper.selectByWfdd(map);
	}

	@Override
	public List<Sys_frm_code> selectSysfrmCode(String fct_code) {
		return mapper.selectSysfrmCode(fct_code);
	}

	@Override
	public List<HashMap<String,Object>> selectList(HashMap<String, Object> map) {
		List<TblOffeVioWfxwStat> list = mapper.selectList(map);//统计结果List
		List<HashMap<String, Object>> lMap = new ArrayList<HashMap<String, Object>>();//最终返回的List
		if(list.size()<1)
		{
			return lMap;
		}
		HashMap<String, Object> modelMap = new HashMap<String, Object>();//合计行统计map
		modelMap.put("glbm", "合计");//合计行名称单元格
		
		for (TblOffeVioWfxwStat ps : list) {
			
			HashMap<String, Object> convertToMap = MapUtil.convertToMap(ps);// 对象转map
			if(ps.getWfxwtj()!=null)
			{			
				String[] split = ps.getWfxwtj().split("@");//分隔JSON串，数据库查出来为@分隔的多个
			for (String string : split) {
				JSONObject jsStr = JSONObject.fromObject(string);//将JSON字符串转换成对象
				Iterator<String> iterator1 = jsStr.keys();//获取JSON对象的所有key
				while (iterator1.hasNext()) {
					String key1 = iterator1.next();
					String value1 = jsStr.getString(key1);
						if (convertToMap.get(key1) == null) {
							convertToMap.put(key1, value1);
						} else {
							convertToMap.put(key1, Integer.valueOf(convertToMap.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
						if (modelMap.get(key1) == null) {
							modelMap.put(key1, value1);
						} else {
							modelMap.put(key1, Integer.valueOf(modelMap.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
					
				}
			}
			}
			lMap.add(convertToMap);
		}
		lMap.add(0,modelMap);
		return lMap;
	}

	@Override
	public List<HashMap<String, Object>> selectWfddList(HashMap<String, Object> map) {
		List<TblWfxwWfddStat> list = mapper.selectByWfdd(map);
		HashMap<String, Object> modelMap1 = new HashMap<String, Object>();
		List<HashMap<String, Object>> lMap = new ArrayList<HashMap<String, Object>>();
		modelMap1.put("wfddmc", "合计");
		for (TblWfxwWfddStat ps : list) {
			//累加合计行
			if (modelMap1.get("cjzs") != null) {
				modelMap1.put("cjzs",
						Integer.parseInt(modelMap1.get("cjzs").toString()) + ps.getCjzs());

			} else {
				modelMap1.put("cjzs", ps.getCjzs());
			}
			if (modelMap1.get("yxs") != null) {
				modelMap1.put("yxs",
						Integer.parseInt(modelMap1.get("yxs").toString()) +ps.getYxs());

			} else {
				modelMap1.put("yxs", ps.getYxs());
			}
			if (modelMap1.get("wxs") != null) {
				modelMap1.put("wxs",
						Integer.parseInt(modelMap1.get("wxs").toString()) +ps.getWxs());

			} else {
				modelMap1.put("wxs", ps.getWxs());
			}
			HashMap<String, Object> convertToMap = MapUtil.convertToMap(ps);// 对象转map
			if(ps.getWfxwtj()!=null)
			{			
				String[] split = ps.getWfxwtj().split("@");
			for (String string : split) {
				JSONObject jsStr = JSONObject.fromObject(string);//将JSON字符串转换成对象
				Iterator<String> iterator1 = jsStr.keys();
				while (iterator1.hasNext()) {
					String key1 = iterator1.next();
					String value1 = jsStr.getString(key1);
						if (convertToMap.get(key1) == null) {
							convertToMap.put(key1, value1);
						} else {
							convertToMap.put(key1, Integer.valueOf(convertToMap.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
						if (modelMap1.get(key1) == null) {
							modelMap1.put(key1, value1);
						} else {
							modelMap1.put(key1, Integer.valueOf(modelMap1.get(key1).toString()).intValue()
									+ Integer.parseInt(value1));
						}
					
				}
			}
			}
			if (convertToMap != null && convertToMap.get("yxs") != null) {
				if (Integer.valueOf(convertToMap.get("yxs").toString()).intValue() != 0) {
					int efficiency = (int) (Math
							.ceil((float) Integer.valueOf(convertToMap.get("yxs").toString()).intValue()
									/ (float) Integer.valueOf(convertToMap.get("cjzs").toString()).intValue() * 100));
					convertToMap.put("yxl", efficiency + "%");
				} else {
					convertToMap.put("yxl", "0%");
				}
			} else {
				convertToMap.put("yxl", "0%");
			}
			lMap.add(convertToMap);
		}
		if (modelMap1 != null && modelMap1.get("yxs") != null) {
			if (Integer.valueOf(modelMap1.get("yxs").toString()).intValue() != 0) {
				int efficiency = (int) (Math.ceil((float) Integer.valueOf(modelMap1.get("yxs").toString()).intValue()
						/ (float) Integer.valueOf(modelMap1.get("cjzs").toString()).intValue() * 100));
				modelMap1.put("yxl", efficiency + "%");
			} else {
				modelMap1.put("yxl", "0%");
			}
		} else {
			modelMap1.put("yxl", "0%");
		}
		lMap.add(0,modelMap1);//将合计行加入集合的第一行
		return lMap;
	}

	
}
