package com.cist.statistics.ensemblejob.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.statistics.ensemblejob.mapper.EnsembleJobMapper;
import com.cist.statistics.ensemblejob.model.EnsembleJob;
import com.cist.statistics.ensemblejob.model.Illegal_Behavior;
import com.cist.statistics.ensemblejob.service.EnsembleJobService;
@Service
public class EnsembleJobServiceImpl implements EnsembleJobService {
	@Autowired
	private EnsembleJobMapper mapper;
	/**
	 * 根据条件查询抓拍数量
	 */
	public List<EnsembleJob> selectzpsl(HashMap<String, Object> map) {
		return mapper.selectzpsl(map);
	}
	/**
	 * 根据条件查询审核数量
	 */
	public List<EnsembleJob> selectshsl(HashMap<String, Object> map) {
		return mapper.selectshsl(map);
	}
	public List<Illegal_Behavior> selectwfxw(Illegal_Behavior ill) {
		return mapper.selectwfxw(ill);
	}
	/**
	 * 根据条件查询审核总数
	 */
	public List<EnsembleJob> selectshzs(EnsembleJob job) {
		return mapper.selectshzs(job);
	}
	/**
	 * 根据条件查询审核通过总数
	 */
	public List<EnsembleJob> selecttgzs(EnsembleJob job) {
		return mapper.selecttgzs(job);
	}
	/**
	 * 根据条件查询抓拍总数
	 */
	public List<EnsembleJob> selectzpzs(EnsembleJob job) {
		return mapper.selectzpzs(job);
	}
	/**
	 * 违法类型统计
	 */
	public List<EnsembleJob> wfxwlxtj(EnsembleJob job) {
		return mapper.wfxwlxtj(job);
	}

}
