package com.cist.illegalbehavior.util;

import java.lang.reflect.Field;
import java.util.HashMap;

public class MapUtil {
	//对象转换成map
	public static HashMap<String, Object> convertToMap(Object obj) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0, len = fields.length; i < len; i++) {
				String varName = fields[i].getName();
				boolean accessFlag = fields[i].isAccessible();
				fields[i].setAccessible(true);
				Object o = fields[i].get(obj);
				if (o != null)
					map.put(varName, o.toString());

				fields[i].setAccessible(accessFlag);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return map;
	}
}
