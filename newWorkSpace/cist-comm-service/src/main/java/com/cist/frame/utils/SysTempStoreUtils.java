package com.cist.frame.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.frame.springContext.SpringContextUtil;

public final class SysTempStoreUtils {
	@SuppressWarnings("unchecked")
	public static String getFcName(String fct_code,String fc_code){
		try 
		{
			ValueOperations<Serializable, Object> operations = SpringContextUtil.getBeanByName("ObjectredisTemplate",RedisTemplate.class).opsForValue();
			BaseDataInfo result = (BaseDataInfo)operations.get("key_"+fct_code+"_"+fc_code);
			if(result!=null) {
				String fc_name = result.getFc_name();
				if(fc_name!=null && !"".equals(fc_name)) {
					return fc_name;
				}else {
					return "未知";
				}
			}else {
				return "未知";
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "未知";
		}	
	}
	
	@SuppressWarnings("unchecked")
	public static String getFcAttr(String fct_code,String fc_code){
		try 
		{
			ValueOperations<Serializable, Object> operations = SpringContextUtil.getBeanByName("ObjectredisTemplate",RedisTemplate.class).opsForValue();
			BaseDataInfo result = (BaseDataInfo)operations.get("key_"+fct_code+"_"+fc_code);
			if(result!=null) {
				String attr = result.getFc_attr();
				if(attr!=null&&!("".equals(attr)))
				{
					return attr;
				}else {
					return "未知";
				}	
				
			}else {
				return "未知";
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "未知";
		}	
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,BaseDataInfo> getSysConfig(String fct_code){
		Map<String,BaseDataInfo> map = new HashMap<String,BaseDataInfo>();
		try {
			RedisTemplate<String, String> strtpl = SpringContextUtil.getBeanByName("stringRedisTemplate",RedisTemplate.class);
			RedisTemplate<Object, Object> objtpl = SpringContextUtil.getBeanByName("ObjectredisTemplate",RedisTemplate.class);
			Set<String> keys = strtpl.keys("key_"+fct_code+"_*");
			for (String key : keys) {  
				BaseDataInfo base = (BaseDataInfo)objtpl.opsForValue().get(key); 
				map.put(base.getFc_code(), base);
			}  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}

