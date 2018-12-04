package com.cist.core.utils;

import java.math.BigDecimal;

public interface Constants {

	public static final String ZERO = "未知";
	
	public static final String JOIN = ",";

	/**
	 * 警员类型
	 */
	public static final String SYS_KIND_TYPE = "1";

	/**
	 * 警员职务
	 */
	public static final String SYS_POST_TYPE = "2";
	
	/**
	 * 警员状态
	 */
	public static final String SYS_STATUS = "3";
	/**
	 * 管理部门
	 */
	public static final String SYS_DEPT = "4";
	
	/**
	 * 机构类别
	 */
	public static final String SYS_DEPT_TYPE = "5";
	
	/**
	 * 号牌种类
	 */
	public static final String SYS_PLATE_TYPE = "6";
	
	/**
	 * 违法行为
	 */
	public static final String SYS_OFFE_CATE = "7";
	
	/**
	 * 行驶方向
	 */
	public static final String SYS_DIRECTION = "8";
	
	/**
	 * 车辆类型
	 */
	public static final String SYS_CAR_TYPE = "10";
	
	/**
	 * 车身颜色
	 */
	public static final String SYS_CAR_COLOR = "11";
	/**
	 * 车辆品牌 
	 */
	public static final String SYS_CAR_LOGO_TYPE = "12";
	/**
	 * 号牌颜色
	 */
	public static final String SYS_PLATE_COLOR = "9";
	
	/**
	 * 安装点编号
	 */
	public static final String MONIT_TYPE = "13";
	
	/**
	 * 部门编码type
	 */
	public static final String DEPT_CODE_TYPE = "19";
	
	
	/**
	 * 使用性质
	 */
	public static final String CAR_USE_TYPE = "25";
	
	/**
	 * 车辆用途
	 */
	public static final String CAR_USE_AGE = "30";
	
	/**
	 * 车辆状态
	 */
	public static final String C_CAR_STATUS = "31";
	
	/**
	 * 限行车辆类型
	 */
	public static final String C_LIMIT_CAR_TYPE = "32";
	
	
	public static final BigDecimal PERCENT = new BigDecimal(100);
	
	public static final String ILLEGAL_OUT_PATH = "27,com.cist.illega.exp.path";
	
	public static final String APP_VERSIONS = "28,com.cist.app.version";
}
