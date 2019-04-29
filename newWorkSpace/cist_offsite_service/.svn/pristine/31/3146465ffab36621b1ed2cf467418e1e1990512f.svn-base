package com.cist.core.utils;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import javax.servlet.ServletContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.web.context.support.WebApplicationContextUtils;

public final class Format {

	private static final String STRING_NULL = "";

	public static boolean isEmpty(String s) {
		return (s == null || STRING_NULL.equals(s)) ? true : false;
	}

	public static int obj2Int(Object o, int i) {
		if (o == null || STRING_NULL.equals(o.toString().trim())) {
			return i;
		}
		try {
			return Integer.parseInt(o.toString());
		} catch (Exception en) {
			en.printStackTrace();
			return i;
		}
	}

	public static boolean obj2Boo(Object o, boolean b) {
		if (o == null || STRING_NULL.equals(o.toString().trim())) {
			return b;
		}
		try {
			return Boolean.parseBoolean(o.toString());
		} catch (Exception en) {
			en.printStackTrace();
			return b;
		}
	}

	public static long obj2Long(Object o, long l) {
		if (o == null || "".equals(o.toString().trim())) {
			return l;
		}
		try {
			return Long.parseLong(o.toString().trim());
		} catch (Exception en) {
			en.printStackTrace();
			return l;
		}
	}

	public static <T> T map2Obj(T t, Map<String, Object> mp, String[] ss) {
		BeanWrapper bw = new BeanWrapperImpl(t);
		PropertyDescriptor[] pdrs = bw.getPropertyDescriptors();
		for (PropertyDescriptor pdr : pdrs) {
			String s = pdr.getName();
			if (bw.isWritableProperty(s) && mp.containsKey(s)) {
				Object o1 = mp.get(s);
				if (o1 != null && !STRING_NULL.equals(o1.toString().trim())) {
					try {
						bw.setPropertyValue(
								s,
								!isInArray(ss, s) ? HTMLHelper
										.toHTMLEXTString(o1.toString()) : o1);
					} catch (Exception en) {
						en.printStackTrace();
					}
				}
			}
		}
		return t;
	}

	public static <T> T map2Obj(T t, Map<String, Object> mp, String[] ss0,
			String[] ss1) {
		BeanWrapper bw = new BeanWrapperImpl(t);
		PropertyDescriptor[] pdrs = bw.getPropertyDescriptors();
		for (PropertyDescriptor pdr : pdrs) {
			String s = pdr.getName();
			if (bw.isWritableProperty(s) && mp.containsKey(s)) {
				Object o1 = mp.get(s);
				if (o1 != null && !STRING_NULL.equals(o1.toString().trim())) {
					try {
						if (!isInArray(ss1, s)) {
							bw.setPropertyValue(
									s,
									!isInArray(ss0, s) ? HTMLHelper
											.toHTMLEXTString(o1.toString())
											: o1);
						}
					} catch (Exception en) {
						en.printStackTrace();
					}
				}
			}
		}
		return t;
	}

	public static String obj2USql(Object o, String[] ss) {
		BeanWrapper bw = new BeanWrapperImpl(o);
		PropertyDescriptor[] pdrs = bw.getPropertyDescriptors();
		StringBuilder sbr = new StringBuilder();
		for (PropertyDescriptor pdr : pdrs) {
			String s = pdr.getName();
			if (!isInArray(ss, s) && !"class".equals(s))
				sbr.append("o.").append(s).append("='")
						.append(bw.getPropertyValue(s)).append("',");
		}
		return getSubString(sbr.toString(), ",", false);
	}

	public static String obj2Xml(Object o0, int i, String[] ss) {
		BeanWrapper bwr = new BeanWrapperImpl(o0);
		PropertyDescriptor[] pdrs = bwr.getPropertyDescriptors();
		StringBuilder sbr = new StringBuilder();
		for (int j = 0; j < pdrs.length; j++) {
			String s = pdrs[j].getName();
			if (!isInArray(ss, s) && !"class".equals(s)) {
				Object o1 = bwr.getPropertyValue(s);
				sbr.append(s).append("=\"")
						.append(o1 == null ? STRING_NULL : o1).append("\" ");
			}
		}
		if (i == 0)
			return new StringBuilder("<node ").append(sbr)
					.append(" isopen=\"false\" ></node>").toString();
		return new StringBuilder("<node ").append(sbr)
				.append(" isopen=\"true\" ><node ").append(sbr)
				.append(" isopen=\"false\" /></node>").toString();
	}

	public static String list2Xml(List<Object> lt0, List<Integer> lt1,
			String[] ss, boolean b) {
		int i0 = lt0.size();
		if (lt1 == null || lt1.size() == 0) {
			lt1 = new ArrayList<Integer>();
			for (int i1 = 0; i1 < i0; i1++) {
				lt1.add(0);
			}
		}
		StringBuilder sbr = new StringBuilder("<root>");
		if (lt0.size() > 0 && i0 == lt1.size()) {
			sbr.append(b ? "<node isopen=\"false\" ></node>" : STRING_NULL);
			for (int i1 = 0; i1 < i0; i1++) {
				sbr.append(obj2Xml(lt0.get(i1), lt1.get(i1), ss));
			}
		}
		return sbr.append("</root>").toString();
	}

	public static String map2Hql(Map<String, Object> mp, String[] ss) {
		if (mp.size() == 0) {
			return STRING_NULL;
		}
		StringBuilder sbr = new StringBuilder();
		for (String s : mp.keySet()) {
			if (isInArray(ss, s)) {
				sbr.append("o.").append(s).append("='").append(mp.get(s))
						.append("',");
			}
		}
		return getSubString(sbr.toString(), ",", false);
	}

	/**
	 * 
	 * @param mp
	 *            所需转换的Map
	 * @param s0
	 *            Map中的排除值
	 * @param s1
	 *            所需操作分隔符(分割后 0为= 1为like 2为<= 3为>=)
	 * @return
	 */
	public static String map2Hql(Map<String, Object> mp, String s0, String s1) {
		return map2Hql(mp, s0, s1, true);
	}

	public static String map2Hql(Map<String, Object> mp, String s0, String s1,
			boolean b0, boolean b1) {
		if (mp.size() == 0) {
			return STRING_NULL;
		}
		StringBuilder sbr = new StringBuilder();
		Iterator<Entry<String, Object>> ir = mp.entrySet().iterator();
		for (; ir.hasNext();) {
			Map.Entry<String, Object> mey = ir.next();
			String s2 = mey.getValue().toString();
			if (s0.equals(s2) || STRING_NULL.equals(s2.trim())
					|| s2.substring(1, 2).indexOf(STRING_NULL) == -1) {
				continue;
			}
			String s3 = s2.substring(0, 1);
			String s4 = s2.substring(2);
			if (STRING_NULL.equals(s4.trim()) || s0.equals(s4)) {
				continue;
			}
			if ("0".equals(s3))
				sbr.append("AND " + (b1 ? "o." : "")
						+ getSubString(mey.getKey(), s1, true) + "='" + s4
						+ "' ");
			else if ("1".equals(s3))
				sbr.append("AND INSTR(" + (b1 ? "o." : "")
						+ getSubString(mey.getKey(), s1, true) + ", '" + s4
						+ "')>0 ");
			else if ("2".equals(s3))
				sbr.append("AND " + (b1 ? "o." : "")
						+ getSubString(mey.getKey(), s1, true)
						+ (b0 ? (" <= '" + s4 + "' ") : ("<= " + s4 + " ")));
			else if ("3".equals(s3))
				sbr.append("AND " + (b1 ? "o." : "")
						+ getSubString(mey.getKey(), s1, true)
						+ (b0 ? (" >= '" + s4 + "' ") : (">= " + s4 + " ")));
		}
		return sbr.toString();
	}

	public static String map2Hql(Map<String, Object> mp, String s0, String s1,
			boolean b) {
		return map2Hql(mp, s0, s1, b, true);
	}

	public static String joinArray(Object[] os, String s0, String s1) {
		return joinArray(os, s0, s0, s1);
	}

	public static String joinArray(Object[] os, String s0, String s1, String s2) {
		StringBuilder sbr = new StringBuilder();
		for (Object o : os) {
			sbr.append(s0).append(o).append(s1).append(s2);
		}
		return getSubString(sbr.toString(), s2, false);
	}

	public static String joinList(List<?> lt, String s0, String s1) {
		return joinList(lt, s0, s0, s1);
	}

	public static String joinList(List<?> lt, String s0, String s1, String s2) {
		StringBuilder sbr = new StringBuilder();
		for (Object o : lt) {
			sbr.append(s0).append(o.toString()).append(s1).append(s2);
		}
		return getSubString(sbr.toString(), s2, false);
	}

	public static String getSubString(String s0, String s1, boolean b) {
		if (b) {
			if (s0.indexOf(s1) != -1) {
				s0 = s0.substring(s0.indexOf(s1) + s1.length());
			}
		} else {
			if (s0.lastIndexOf(s1) != -1) {
				s0 = s0.substring(0, s0.lastIndexOf(s1));
			}
		}
		return s0;
	}

	public static boolean isInArray(String[] ss, String s0) {
		if (ss == null || ss.length == 0) {
			return false;
		}
		for (String s1 : ss) {
			if (s1.equals(s0)) {
				return true;
			}
		}
		return false;
	}

	public static Object[] concatArray(Object[] os0, Object[] os1) {
		List<Object> lt = new LinkedList<Object>();
		for (Object o : os0) {
			lt.add(o);
		}
		for (Object o : os1) {
			lt.add(o);
		}
		return lt.toArray();
	}

	public static Object[] concatArrayExcept(Object[] os0, Object[] os1) {
		Map<Object, Byte> mp = new HashMap<Object, Byte>();
		for (Object o : os0) {
			mp.put(o, (byte) 0);
		}
		for (Object o : os1) {
			mp.put(o, (byte) 0);
		}
		return mp.keySet().toArray();
	}

	public static Object[] eliminateArray(Object[] os0, Object o0) {
		List<Object> lt = new LinkedList<Object>();
		for (Object o1 : os0) {
			if (!o1.equals(o0)) {
				lt.add(o1);
			}
		}
		return lt.toArray();
	}

	public static List<Object> concatListExcept(List<?> lt0, List<?> lt1) {
		Map<Object, Byte> mp = new TreeMap<Object, Byte>();
		for (Object o : lt0) {
			mp.put(o, (byte) 0);
		}
		for (Object o : lt1) {
			mp.put(o, (byte) 0);
		}
		return new ArrayList<Object>(mp.keySet());
	}

	public static List<Object> asListAnn2Obj(List<?> lt0) {
		List<Object> lt1 = new ArrayList<Object>();
		for (Object o : lt0) {
			lt1.add(o);
		}
		return lt1;
	}

	public static Object getBean(String s, ServletContext sct) {
		return WebApplicationContextUtils.getWebApplicationContext(sct)
				.getBean(s);
	}

	public static Object class2Object(Class<?> c) {
		try {
			return c.getConstructor(new Class[] {})
					.newInstance(new Object[] {});
		} catch (Exception en) {
			throw new RuntimeException("Class2Object Error");
		}
	}

	public static <T> T copyObject(T source, T copy, String[] except) {
		BeanWrapper bw0 = new BeanWrapperImpl(source);
		BeanWrapper bw1 = new BeanWrapperImpl(copy);
		for (PropertyDescriptor pdr : bw0.getPropertyDescriptors()) {
			String s = pdr.getName();
			if (!isInArray(except, s) && !"class".equals(s)
					&& bw1.isWritableProperty(s)) {
				Object o0 = bw0.getPropertyValue(s);
				bw1.setPropertyValue(s, o0);
			}
		}
		return copy;
	}

	
}