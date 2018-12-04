package com.cist.qwgl.qwpb.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cist.frame.page.PageInfo;
import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.qwpb.mapper.QwpbMapper;
import com.cist.qwgl.qwpb.model.DEPT;
import com.cist.qwgl.qwpb.model.QWGL_PBGL_PBINFO;
import com.cist.qwgl.qwpb.model.QWGL_POLICE_CAR;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_QWQY;
import com.cist.qwgl.qwpb.model.QWGL_ZB_INFO;
import com.cist.qwgl.qwpb.model.SYS_POLICE_INFO;
import com.cist.qwgl.qwpb.model.VW_QWGL_PB_INFO;
import com.cist.qwgl.qwpb.model.ZB_Police;
import com.cist.qwgl.qwpb.service.QwpbService;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;
@Service
public class QwpbServiceImpl implements QwpbService {
	@Autowired
	private QwpbMapper mapper;
	public List<QWGL_PBGL_PBINFO> querypb(HashMap<String, Object> map) {
		return mapper.querypb(map);
	}

	public Object querypbpageList(HashMap<String, Object> map, PageInfo info) {
		return mapper.querypb(map);
	}

	public Integer addpb(HashMap<String, Object> map) {
		return mapper.addpb(map);
	}
	public List<Qwgl_bc_info> querysj(String bc_pk) {
		return mapper.querysj(bc_pk);
	}

	public List<Integer> queryzbld() {
		return mapper.queryzbld();
	}

	public List<ZB_Police> queryld(List<Integer> list) {
		return mapper.queryld(list);
	}

	public List<ZB_Police> queryzbkz() {
		return mapper.queryzbkz();
	}

	public List<ZB_Police> queryzbmj() {
		return mapper.queryzbmj();
	}

	public List<ZB_Police> queryzbxj() {
		return mapper.queryzbxj();
	}

	public List<QWGL_POLICE_CAR> querypolicecar(HashMap<String, Object> map) {
		return mapper.querypolicecar(map);
	}

	public List<QWGL_POLICE_CAR> queryhphm(HashMap<String, Object> map) {
		return mapper.queryhphm(map);
	}

	public List<ZB_Police> queryfzr() {
		return mapper.queryfzr();
	}


	public Integer addcx(HashMap<String, Object> map) {
		return mapper.addcx(map);
	}

	public List<SYS_POLICE_INFO> queryhh() {
		return mapper.queryhh();
	}

	public List<QWGL_ZB_INFO> queryzbinfo(HashMap<String, Object> map) {
		return mapper.queryzbinfo(map);
	}

	public List<QWGL_ZB_INFO> queryzb(HashMap<String, Object> map) {
		return mapper.queryzb(map);
	}

	public Integer addzbbb(HashMap<String, Object> map) {
		return mapper.addzbbb(map);
	}

	public List<VW_QWGL_PB_INFO> querytj(HashMap<String, Object> map) {
		return mapper.querytj(map);
	}

	public Date querymaxsj(HashMap<String,Object> map) {
		return mapper.querymaxsj(map);
	}

	public Date queryminsj(HashMap<String,Object> map) {
		return mapper.queryminsj(map);
	}

	public List<DEPT> querydeptname(HashMap<String, Object> map) {
		return mapper.querydeptname(map);
	}

	public List<QWGL_QWPB_QWQY> queryqwqy(HashMap<String, Object> map) {
		return mapper.queryqwqy(map);
	}

	public String querypolice(HashMap<String, Object> map) {
		return mapper.querypolice(map);
	}

	public String querycxmj(HashMap<String, Object> map) {
		return mapper.querycxmj(map);
	}

	public String querycxxj(HashMap<String, Object> map) {
		return mapper.querycxxj(map);
	}

	public String querycxhphm(HashMap<String, Object> map) {
		return mapper.querycxhphm(map);
	}

	@Override
	public List<QWGL_XQGL_INFO> queryqy(HashMap<String, Object> map) {
		return mapper.queryqy(map);
	}
}
