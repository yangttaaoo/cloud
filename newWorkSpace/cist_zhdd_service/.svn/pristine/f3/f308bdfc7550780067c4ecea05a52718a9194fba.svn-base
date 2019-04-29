package com.cist.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import com.cist.BaseInfo.model.BaseDataInfo;
import com.cist.BaseInfo.model.BaseDataModel;

@Component
public final class SysTempStoreUtils {
	static HashMap<String, Object> modelMap = new LinkedHashMap<String, Object>();
	@Autowired
	private RedisTemplate redisTemplate;


	public static String getFcName(String fct_code, String fc_code) {

		try {
			ValueOperations<Serializable, Object> operations = sysTempStoreUtils.redisTemplate.opsForValue();
			BaseDataModel.BASE_DATA_MAP = (Map<String, Map<String, BaseDataInfo>>) operations.get("BaseInfo");
			Map<String, BaseDataInfo> map = BaseDataModel.BASE_DATA_MAP.get(fct_code);
			BaseDataInfo baseDataInfo = map.get(fc_code);
			if (baseDataInfo.getFc_name() != null) {
				return baseDataInfo.getFc_name();
			}
			return "未知";
		} catch (Exception e) {
			return "未知";
		}

	}

	public static SysTempStoreUtils sysTempStoreUtils;

	@PostConstruct
	public void init() {
		sysTempStoreUtils = this;
	}
}
