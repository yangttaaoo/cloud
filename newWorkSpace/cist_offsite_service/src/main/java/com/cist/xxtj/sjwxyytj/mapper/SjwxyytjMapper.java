package com.cist.xxtj.sjwxyytj.mapper;

import java.util.HashMap;
import java.util.List;

import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_FAIL_STAT;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_INVALID_STAT;
import com.cist.xxtj.sjwxyytj.model.WfxwtjByDept;

public interface SjwxyytjMapper {
	public List<TBL_WFXW_INVALID_STAT> querywxyytj(HashMap<String,Object> map);
	public List<TBL_WFXW_FAIL_STAT> queryscsbyytj(HashMap<String,Object> map);
	public List<WfxwtjByDept> wfxwttjbydept(HashMap<String,Object> map);
	public List<WfxwtjByDept> wxxwhj(HashMap<String,Object> map);
	public List<WfxwtjByDept> scsbyytjbydept(HashMap<String,Object> map);
	public List<WfxwtjByDept> scsbhj(HashMap<String,Object> map);
}
