package com.cist.xxtj.wfsjlztj.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.xxtj.wfsjlztj.mapper.WfsjlztjMapper;
import com.cist.xxtj.wfsjlztj.model.Sjlztj;
import com.cist.xxtj.wfsjlztj.model.TBL_FLOW_CARD_STAT;
import com.cist.xxtj.wfsjlztj.model.TBL_OFFE_VIO_FLOW_STAT;
import com.cist.xxtj.wfsjlztj.model.Wfzppm;
import com.cist.xxtj.wfsjlztj.service.WfsjlztjService;
@Service
public class WfsjlztjServiceImpl implements WfsjlztjService {
	@Autowired
	private WfsjlztjMapper mapper;

	@Override
	public List<TBL_FLOW_CARD_STAT> querycard(HashMap<String, Object> map) {
		return mapper.querycard(map);
	}

	@Override
	public List<Sjlztj> queryjrsjlztj(HashMap<String, Object> map) {
		return mapper.queryjrsjlztj(map);
	}

	@Override
	public List<Sjlztj> querybzsjlztj(HashMap<String, Object> map) {
		return mapper.querybzsjlztj(map);
	}

	@Override
	public List<Sjlztj> querybysjlztj(HashMap<String, Object> map) {
		return mapper.querybysjlztj(map);
	}

	@Override
	public List<Sjlztj> queryqnsjlztj(HashMap<String, Object> map) {
		return mapper.queryqnsjlztj(map);
	}

	@Override
	public List<TBL_OFFE_VIO_FLOW_STAT> querysjlztjlist(HashMap<String, Object> map) {
		return mapper.querysjlztjlist(map);
	}

	@Override
	public List<Wfzppm> querywfzppm(HashMap<String, Object> map) {
		return mapper.querywfzppm(map);
	}

	@Override
	public List<TBL_OFFE_VIO_FLOW_STAT> queryjrwflzinfo() {
		return mapper.queryjrwflzinfo();
	}
}
