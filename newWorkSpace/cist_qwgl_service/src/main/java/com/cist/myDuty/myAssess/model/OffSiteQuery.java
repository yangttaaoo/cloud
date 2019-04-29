package com.cist.myDuty.myAssess.model;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OffSiteQuery {
	private HashMap<String, String> auditState=this.initAuditState();
	// 号牌颜色
	private String hphm;
	// 号牌种类(参考SYS_FRM_CODE表 FCT_CODE=C001)
	private String hpzl;
	// 违法行为(参考TBL_OFFE_CATE)
	private String wfxw;
	// 实际的中文地址
	private String wfdz;
	// 采集单位代码
	private String cjdw;
	// 违法时间
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date wfsj;
	// 审核标志(0-未审核1-初审通过 2-复审通过3-初审作废 4-复审作废 5-作废数据有效7-上传成功
	// 8-上传失败9-上传其它标志10-删除标志11-其它13-上传队列 14-导出 15-初筛通过 16-初筛作废)
	private String shbz;

	public OffSiteQuery() {

	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getHpzl() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_HPZL, hpzl);
	}

	public void setHpzl(String hpzl) {
		this.hpzl = hpzl;
	}

	public String getWfxw() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_WFXW, wfxw);
	}

	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}

	public String getWfdz() {
		return wfdz;
	}

	public void setWfdz(String wfdz) {
		this.wfdz = wfdz;
	}

	public String getCjdw() {
		return SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_DEPT, cjdw);
	}

	public void setCjdw(String cjdw) {
		this.cjdw = cjdw;
	}

	public Date getWfsj() {
		return wfsj;
	}

	public void setWfsj(Date wfsj) {
		this.wfsj = wfsj;
	}

	public String getShbz() {

		return this.auditState.get(shbz);
	}

	public void setShbz(String shbz) {

		this.shbz = shbz;
	}

	public HashMap<String, String> initAuditState() {
		HashMap<String, String> map = new HashMap<String, String>();
		String[] obj = new String[] { "未审核", "初审通过", "复审通过", "初审作废", "复审作废", "作废数据有效", "", "上传成功", "上传失败", "上传其它标志",
				"删除标志", "其它", "", "上传队列", "导出 ", "初筛通过", "初筛作废" };
		List<String> list = Arrays.asList(obj);
		this.auditState = new HashMap<String, String>();
		for (int i = 0; i < list.size(); i++) {
			map.put(String.valueOf(i), list.get(i));
		}
		return map;
	}
}
