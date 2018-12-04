package com.cist.xxtj.sjwxyytj.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.xxtj.sjwxyytj.mapper.SjwxyytjMapper;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_FAIL_STAT;
import com.cist.xxtj.sjwxyytj.model.TBL_WFXW_INVALID_STAT;
import com.cist.xxtj.sjwxyytj.model.WfxwtjByDept;
import com.cist.xxtj.sjwxyytj.service.SjwxyytjService;
@Service
public class SjwxyytjServiceImpl implements SjwxyytjService {
	@Autowired
	private SjwxyytjMapper mapper;

	@Override
	public List<TBL_WFXW_INVALID_STAT> querywxyytj(HashMap<String,Object> map) {
		return mapper.querywxyytj(map);
	}

	@Override
	public List<TBL_WFXW_FAIL_STAT> queryscsbyytj(HashMap<String, Object> map) {
		return mapper.queryscsbyytj(map);
	}

	@Override
	public List<WfxwtjByDept> wfxwttjbydept(HashMap<String, Object> map) {
		return mapper.wfxwttjbydept(map);
	}

	@Override
	public List<WfxwtjByDept> wxxwhj(HashMap<String, Object> map) {
		return mapper.wxxwhj(map);
	}

	@Override
	public List<WfxwtjByDept> scsbyytjbydept(HashMap<String, Object> map) {
		return mapper.scsbyytjbydept(map);
	}

	@Override
	public List<WfxwtjByDept> scsbhj(HashMap<String, Object> map) {
		return mapper.scsbhj(map);
	}
}
