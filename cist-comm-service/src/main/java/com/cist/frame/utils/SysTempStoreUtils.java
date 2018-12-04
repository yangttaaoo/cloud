package com.cist.frame.utils;

import java.io.Serializable;
import java.util.Map;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.model.BaseDataModel;
import com.cist.frame.springContext.SpringContextUtil;

public final class SysTempStoreUtils {
	@SuppressWarnings("unchecked")
	public static String getFcName(String fct_code,String fc_code){
		try 
		{
			ValueOperations<Serializable, Object> operations = SpringContextUtil.getBeanByName("ObjectredisTemplate",RedisTemplate.class).opsForValue();
			BaseDataModel.BASE_DATA_MAP = (Map<String, Map<String, BaseDataInfo>>) operations.get("BaseInfo");
			Map<String, BaseDataInfo> map = BaseDataModel.BASE_DATA_MAP.get(fct_code);
			if(map!=null) {
				BaseDataInfo baseDataInfo = map.get(fc_code);
				if(baseDataInfo!=null&&baseDataInfo.getFc_name()!=null&&!("".equals(baseDataInfo.getFc_name())))
				{
					return baseDataInfo.getFc_name();
				}	
			}
			
			return "未知";
		} 
		catch (Exception e) {
			e.printStackTrace();
			return "未知";
		}
		
	}
}

