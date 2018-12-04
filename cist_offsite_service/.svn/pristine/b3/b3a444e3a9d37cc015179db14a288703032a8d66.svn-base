package com.cist.xxtj.sjwxyytj.service;

import java.util.HashMap;
import java.util.List;

import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_FAIL_STAT;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_INVALID_STAT;
import com.cist.xxtj.sjwxyytj.model.WfxwtjByDept;

public interface SjwxyytjService {
	/**
	 * 查询无效原因统计
	 * @return
	 */
	public List<TBL_WFXW_INVALID_STAT> querywxyytj(HashMap<String,Object> map);
	/**
	 * 查询上传失败原因统计
	 * @param map
	 * @return
	 */
	public List<TBL_WFXW_FAIL_STAT> queryscsbyytj(HashMap<String,Object> map);
	/**
	 * 根据单位查询违法行为统计
	 * @param map
	 * @return
	 */
	public List<WfxwtjByDept> wfxwttjbydept(HashMap<String,Object> map);
	/**
	 * 违法行为合计
	 * @param map
	 * @return
	 */
	public List<WfxwtjByDept> wxxwhj(HashMap<String,Object> map);
	/**
	 * 根据单位分组查询上传失败原因统计
	 * @param map
	 * @return
	 */
	public List<WfxwtjByDept> scsbyytjbydept(HashMap<String,Object> map);
	/**
	 * 上传失败合计
	 * @param map
	 * @return
	 */
	public List<WfxwtjByDept> scsbhj(HashMap<String,Object> map);
}
