package com.cist.qwgl.qwpb.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cist.qwgl.bcgl.model.Qwgl_bc_info;
import com.cist.qwgl.qwpb.model.DEPT;
import com.cist.qwgl.qwpb.model.QWGL_PBGL_PBINFO;
import com.cist.qwgl.qwpb.model.QWGL_POLICE_CAR;
import com.cist.qwgl.qwpb.model.QWGL_QWPB_QWQY;
import com.cist.qwgl.qwpb.model.QWGL_ZB_INFO;
import com.cist.qwgl.qwpb.model.SYS_POLICE_INFO;
import com.cist.qwgl.qwpb.model.VW_QWGL_PB_INFO;
import com.cist.qwgl.qwpb.model.ZB_Police;
import com.cist.qwgl.xqgl.model.QWGL_XQGL_INFO;

public interface QwpbMapper {
	public List<QWGL_PBGL_PBINFO> querypb(HashMap<String,Object> map);
	public Integer addpb(HashMap<String,Object> map);
	public List<Qwgl_bc_info> querysj(String bc_pk);
	public List<Integer> queryzbld();
	public List<ZB_Police> queryld(List<Integer> list);
	public List<ZB_Police> queryzbkz();
	public List<ZB_Police> queryzbmj();
	public List<ZB_Police> queryzbxj();
	public List<QWGL_POLICE_CAR> querypolicecar(HashMap<String,Object> map);
	public List<QWGL_POLICE_CAR> queryhphm(HashMap<String,Object> map);
	public List<ZB_Police> queryfzr();
	public Integer addcx(HashMap<String,Object> map);
	public List<SYS_POLICE_INFO> queryhh();
	public List<QWGL_ZB_INFO> queryzbinfo(HashMap<String,Object> map);
	public List<QWGL_ZB_INFO> queryzb(HashMap<String,Object> map);
	public Integer addzbbb(HashMap<String,Object> map);
	public List<VW_QWGL_PB_INFO> querytj(HashMap<String,Object> map);
	public Date querymaxsj(HashMap<String,Object> map);
	public Date queryminsj(HashMap<String,Object> map);
	public List<DEPT> querydeptname(HashMap<String,Object> map);
	public List<QWGL_QWPB_QWQY> queryqwqy(HashMap<String,Object> map);
	public String querypolice(HashMap<String,Object> map);
	public String querycxmj(HashMap<String,Object> map);
	public String querycxxj(HashMap<String,Object> map);
	public String querycxhphm(HashMap<String,Object> map);
	public List<QWGL_XQGL_INFO> queryqy(HashMap<String,Object> map);
}
