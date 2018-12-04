package com.cist.offsite.invalidtrial.utils;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.jdbc.SQL;

import oracle.net.aso.a;

import java.util.regex.*;

public class DynaSqlProvider {
	public String selectByConditions(final HashMap<String, Object> map) {
		 return new SQL() {
			{ 
				SELECT("*");
				FROM("OEUSER.TBL_OFFE_EVDI");
				if (map.get("wfpk") != null && map.get("wfpk") != "") {
					WHERE("WFPk=#{wfpk}");
				}
				if (map.get("hphm") != null && map.get("hphm") != "") {
					String str = (String) map.get("hphm");// 获取查询条件hphm
					// 判断车牌号码中是否有中文 有则有模糊查询
					String regEx = "[\u4e00-\u9fa5]";
					// 编译正则表达式
					Pattern pattern = Pattern.compile(regEx);
					// 忽略大小写的写法
					// Pattern pat = Pattern.compile(regEx,
					// Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(str);
					// 字符串是否与正则表达式相匹配
					boolean rs = false;
					if (matcher.find()) {
						rs = true;
					}
					if (str.length() == 7 || str.length() == 8)// 车牌号长度是7或8使用全匹配查询
					{
						WHERE("lower(HPHM)= lower(#{hphm})");
					}
					if (rs && (str.length() != 7 && str.length() != 8))// 车牌号包括中文但长度不是7或8使用右模糊查询
					{
						WHERE("lower(HPHM) like lower(#{hphm}||'%')");
					}
					if (!rs && (str.length() != 7 && str.length() != 8))// 车牌号不包括中文且长度不是7或8使用全模糊查询
					{
						WHERE("lower(HPHM) like lower('%'||#{hphm}||'%')");
					}
				}
				if (map.get("hpzl") != null && map.get("hpzl") != "") {
					WHERE("HPZL=#{hpzl}");
				}
				if (map.get("wfdd") != null && map.get("wfdd") != "") {
					/*WHERE("WFDD like '%'||#{wfdd}||'%'");*/
					WHERE("KKBH =#{wfdd}");
				}
				if (map.get("wfxw") != null && map.get("wfxw") != "") {
					WHERE("WFXW=#{wfxw}");
				}
				if (map.get("wfkssj") != null && map.get("wfkssj") != "") {
					WHERE("WFKSSJ >=to_date(#{wfkssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if (map.get("wfjssj") != null && map.get("wfjssj") != "") {
					WHERE("WFJSSJ <= to_date(#{wfjssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if (((ArrayList)map.get("sbbh")).size()>0) {
					ArrayList arr=(ArrayList)map.get("sbbh");
					String sbbh="";
					for(int a=0;a<arr.size();a++)
					{
						if(arr.size()-1==a)
						{
							sbbh+=arr.get(a).toString();
						}
						else
						{
							sbbh+=arr.get(a).toString()+',';
						}
						
					}
					WHERE("SBBH in ("
							+sbbh
							+")");
//							+ "<foreach item='item'  collection='sbbh'"
//			                + "open='(' separator=',' close=')'>"
//			                + "#{item}"
//			                + "</foreach>");
				}
			
				WHERE("SHBZ IN('3','4')");
				ORDER_BY("wfsj desc");
			}
			
		}.toString();	
	}

	public String dataExportList(final HashMap<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("OEUSER.TBL_OFFE_EVDI");
				if (map.get("wfpk") != null && map.get("wfpk") != "") {
					WHERE("WFPk=#{wfpk}");
				}
				if (map.get("hphm") != null && map.get("hphm") != "") {
					String str = (String) map.get("hphm");// 获取查询条件hphm
					// 判断车牌号码中是否有中文 有则有模糊查询
					String regEx = "[\u4e00-\u9fa5]";
					// 编译正则表达式
					Pattern pattern = Pattern.compile(regEx);
					// 忽略大小写的写法
					// Pattern pat = Pattern.compile(regEx,
					// Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(str);
					// 字符串是否与正则表达式相匹配
					boolean rs = false;
					if (matcher.find()) {
						rs = true;
					}
					if (str.length() == 7 || str.length() == 8)// 车牌号长度是7或8使用全匹配查询
					{
						WHERE("HPHM = #{hphm}");
					}
					if (rs && (str.length() != 7 && str.length() != 8))// 车牌号包括中文但长度不是7或8使用右模糊查询
					{
						WHERE("HPHM like #{hphm}||'%'");
					}
					if (!rs && (str.length() != 7 && str.length() != 8))// 车牌号不包括中文且长度不是7或8使用全模糊查询
					{
						WHERE("HPHM like '%'||#{hphm}||'%'");
					}
				}
				if (map.get("hpzl") != null && map.get("hpzl") != "") {
					WHERE("HPZL=#{hpzl}");
				}
				if (map.get("wfdd") != null && map.get("wfdd") != "") {
					WHERE("WFDD like '%'||#{wfdd}||'%'");
				}
				if (map.get("wfxw") != null && map.get("wfxw") != "") {
					WHERE("WFXW=#{wfxw}");
				}
				if (map.get("wfkssj") != null && map.get("wfkssj") != "") {
					WHERE("WFKSSJ >=to_date(#{wfkssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if (map.get("wfjssj") != null && map.get("wfjssj") != "") {
					WHERE("WFJSSJ <= to_date(#{wfjssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if (map.get("sbbh") != null && map.get("sbbh") != "") {
					WHERE("SBBH=#{sbbh}");
				}
				/*if (map.get("shbz") == null || map.get("shbz") == "") {
					WHERE("SHBZ='1'");
				}*/
				if (map.get("shbz") != null && map.get("shbz") != "") {
					WHERE("SHBZ=#{shbz}");
				}
				if (map.get("fxbh") != null && map.get("fxbh") != "") {
					WHERE("FXBH=#{fxbh}");
				}
				WHERE("HPHM not like '川'||'%'");
				ORDER_BY("wfsj desc");
			}
		}.toString();
	}

	public String exportZipList(final HashMap<String, Object> map) {
		return new SQL() {
			{
				SELECT("*");
				FROM("OEUSER.TBL_OFFE_EVDI");
				if (map.get("wfpk") != null && map.get("wfpk") != "") {
					WHERE("WFPk=#{wfpk}");
				}
				if (map.get("hphm") != null && map.get("hphm") != "") {
					String str = (String) map.get("hphm");// 获取查询条件hphm
					// 判断车牌号码中是否有中文 有则有模糊查询
					String regEx = "[\u4e00-\u9fa5]";
					// 编译正则表达式
					Pattern pattern = Pattern.compile(regEx);
					// 忽略大小写的写法
					// Pattern pat = Pattern.compile(regEx,
					// Pattern.CASE_INSENSITIVE);
					Matcher matcher = pattern.matcher(str);
					// 字符串是否与正则表达式相匹配
					boolean rs = false;
					if (matcher.find()) {
						rs = true;
					}
					if (str.length() == 7 || str.length() == 8)// 车牌号长度是7或8使用全匹配查询
					{
						WHERE("HPHM = #{hphm}");
					}
					if (rs && (str.length() != 7 && str.length() != 8))// 车牌号包括中文但长度不是7或8使用右模糊查询
					{
						WHERE("HPHM like #{hphm}||'%'");
					}
					if (!rs && (str.length() != 7 && str.length() != 8))// 车牌号不包括中文且长度不是7或8使用全模糊查询
					{
						WHERE("HPHM like '%'||#{hphm}||'%'");
					}
				}
				if (map.get("hpzl") != null && map.get("hpzl") != "") {
					WHERE("HPZL=#{hpzl}");
				}
				if (map.get("wfdd") != null && map.get("wfdd") != "") {
					WHERE("WFDD like '%'||#{wfdd}||'%'");
				}
				if (map.get("wfxw") != null && map.get("wfxw") != "") {
					WHERE("WFXW=#{wfxw}");
				}
				if (map.get("wfkssj") != null && map.get("wfkssj") != "") {
					WHERE("WFKSSJ >=to_date(#{wfkssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if (map.get("wfjssj") != null && map.get("wfjssj") != "") {
					WHERE("WFJSSJ <= to_date(#{wfjssj},'yyyy-mm-dd HH24:mi:ss')");
				}
				if(map.get("sbbh")!=null){
					if (((ArrayList)map.get("sbbh")).size()>0) {
						ArrayList arr=(ArrayList)map.get("sbbh");
						String sbbh="";
						for(int a=0;a<arr.size();a++)
						{
							if(arr.size()-1==a)
							{
								sbbh+=arr.get(a).toString();
							}
							else
							{
								sbbh+=arr.get(a).toString()+',';
							}
							
						}
						WHERE("SBBH in ("
								+sbbh
								+")");
					}	
				}
		
//				if (map.get("sbbh") != null && map.get("sbbh") != "") {
//					WHERE("SBBH=#{sbbh}");
//				}
				if (map.get("shbz") != null && map.get("shbz") != "") {
					WHERE("SHBZ=#{shbz}");
				}
				if (map.get("fxbh") != null && map.get("fxbh") != "") {
					WHERE("FXBH=#{fxbh}");
				}
				WHERE("HPHM not like '川'||'%' and rownum < 101");
				ORDER_BY("wfsj desc");
			}
		}.toString();
	}
}