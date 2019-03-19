package com.cist.messagetemplateconfig.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.messagetemplateconfig.model.Jcbk_sms_template;
import com.cist.messagetemplateconfig.model.Sys_frm_code;

public interface MessageConfigMapper {

	/**
	 * 查询短信模板信息
	 * @param map
	 * @return
	 */
	public List<Jcbk_sms_template> selectData(HashMap<String,Object> map);
	/**
	 * 更新短信模板信息
	 * @param map
	 * @return
	 */
	public Integer updateData(HashMap<String,Object> map);
	/**
	 * 添加短信模板信息
	 * @param map
	 * @return
	 */
	public Integer addData(HashMap<String,Object> map);
	/**
	 * 查询可选项
	 * @param map
	 * @return
	 */
	public List<Sys_frm_code> selectKxx(HashMap<String,Object> map);
	/**
	 * 删除短信模板
	 * @param map
	 * @return
	 */
	public Integer deleteData(HashMap<String,Object> map);
}
