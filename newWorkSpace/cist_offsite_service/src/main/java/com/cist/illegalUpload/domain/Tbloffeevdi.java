package com.cist.illegalUpload.domain;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cist.core.utils.Constants;

public class Tbloffeevdi implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private long WFPK;//主键(违法表)
    private String WFBH;//数据编码（日期+序号）
    private String WFDD;//违法地点
    private String WFXW;//违法行为(参考TBL_OFFE_CATE)
    private String WFXW_NAME;
    public String getWFXW_NAME() {
    	if(WFXW!=null){
			return "";//-	 SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_OFFE_CATE+Constants.JOIN+WFXW);
		}
		return WFXW_NAME;
	}
	public void setWFXW_NAME(String wFXW_NAME) {
		WFXW_NAME = wFXW_NAME;
	}
	private String FXBH;//方向编号
    private String HPZL;//号牌种类
    private String HPZL_NAME;
    public String getHPZL_NAME() {
    /*	if(HPZL!=null){
			return  SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_PLATE_TYPE+Constants.JOIN+HPZL);
		}*/
		return HPZL_NAME;
	}
	public void setHPZL_NAME(String hPZL_NAME) {
		HPZL_NAME = hPZL_NAME;
	}
	private String HPHM;//号牌号码
    private String HPYS;//号牌颜色
    private String CLSD;//速度
    private Date WFKSSJ;//违法开始时间
    private Date WFSJ;//违法时间
    private Date WFJSSJ;//违法结束时间
    private String KKBH;//卡口编码
    private String SBBH;//设备编码
    private String WFZJ1;//违法证据1(图片路径)
    private String WFZJ2;//
    private String WFZJ3;//
    private String WFZJ4;//
    private Integer CLBZ;//处理标志(0-未处理 1-审核完毕 2-打印违法通知书和处罚决定书 3-处理完毕 4-作废 5-归档 6-删除标记 7-其它)
    private Integer SHBZ;//审核标志(0-未审核 1-已审核)
    private String SHR;//审核人
    private Date SHSJ;//审核时间
    private String ECSHR;//领导审核
    private Date ECSHSJ;//审核时间
    private String SHSM;//审核备注
    private String SJLY;//采集方式 1-闯红灯设备 2-公路卡口设备 3-测速设备 4-闭路电视 5-移动摄像 9-其它电子设备
    private String CJDW;//采集单位代码
    private String CLPP;//车辆品牌
    private String CLLX;//车辆类型
    private String CSYS;//车身颜色
    private Double BDSD;//标定限速 
    private String SYR;//所有人
    private String SYRDH;//所有人电话
    private String JSZH;//驾驶证号
    private String ZPLX;//抓拍类型,0 自动抓拍 1 手动抓拍
    private String LRR;//录入人
    private Date LRSJ;//录入时间
    private String SCSJ;//上传时间
    private Integer SCBZ;//上传标志  0 未上传  1成功 其它 上传失败
    private String SCDM;//上传代码
    private String CSBZ;//初审备注
    private String RESVE;//行政区划
    private String CDBH;//车道编号
    private String SHIJIAN;
    private String HAOPAI;
    private String HAOPAILAST;
    private String HAOPAIYANSE;//颜色
    private String WEIFAXINGWEI;
    private String XINGSHIFANGXIANG;
    private String XSFX_NAME;
    private String CJDW_NAME;
    private String CLSBDH;
    private String csbl;
    private String DCBZ;
    private String CLYT_LHY;
    private String CHAOSUBILI;
    private String SHLC;
    
    public String getSHLC() {
		return SHLC;
	}
	public void setSHLC(String sHLC) {
		SHLC = sHLC;
	}
	public String getCHAOSUBILI() {
		return CHAOSUBILI;
	}
	public void setCHAOSUBILI(String cHAOSUBILI) {
		CHAOSUBILI = cHAOSUBILI;
	}
	public String getCLYT_LHY() {
		return CLYT_LHY;
	}
	public void setCLYT_LHY(String cLYT_LHY) {
		CLYT_LHY = cLYT_LHY;
	}
	public String getDCBZ() {
		return DCBZ;
	}
	public void setDCBZ(String dCBZ) {
		DCBZ = dCBZ;
	}
	public String getCLSBDH() {
		return CLSBDH;
	}
	public void setCLSBDH(String cLSBDH) {
		CLSBDH = cLSBDH;
	}
	private String ZSXXDZ;//住所详细地址
    public String getZSXXDZ() {
		return ZSXXDZ;
	}
	public void setZSXXDZ(String zSXXDZ) {
		ZSXXDZ = zSXXDZ;
	}
	public String getSYXZ() {
		return SYXZ;
	}
	public void setSYXZ(String sYXZ) {
		SYXZ = sYXZ;
	}
	public String getFDJH() {
		return FDJH;
	}
	public void setFDJH(String fDJH) {
		FDJH = fDJH;
	}
	public String getFZJG() {
		return FZJG;
	}
	public void setFZJG(String fZJG) {
		FZJG = fZJG;
	}
	public String getCLYT() {
		return CLYT;
	}
	public void setCLYT(String cLYT) {
		CLYT = cLYT;
	}
	public String getXB() {
		return XB;
	}
	public void setXB(String xB) {
		XB = xB;
	}
	public String getCSYSNAME() {
		return CSYSNAME;
	}
	public void setCSYSNAME(String cSYSNAME) {
		CSYSNAME = cSYSNAME;
	}
	public String getCLXH() {
		return CLXH;
	}
	public void setCLXH(String cLXH) {
		CLXH = cLXH;
	}
	public String getSYXZNAME() {
		return SYXZNAME;
	}
	public void setSYXZNAME(String sYXZNAME) {
		SYXZNAME = sYXZNAME;
	}
	public String getCLZTNAME() {
		return CLZTNAME;
	}
	public void setCLZTNAME(String cLZTNAME) {
		CLZTNAME = cLZTNAME;
	}
	public String getDWBH() {
		return DWBH;
	}
	public void setDWBH(String dWBH) {
		DWBH = dWBH;
	}
	public String getDWMC() {
		return DWMC;
	}
	public void setDWMC(String dWMC) {
		DWMC = dWMC;
	}
	public String getJYYXQZ() {
		return JYYXQZ;
	}
	public void setJYYXQZ(String jYYXQZ) {
		JYYXQZ = jYYXQZ;
	}
	public String getBFRQ() {
		return BFRQ;
	}
	public void setBFRQ(String bFRQ) {
		BFRQ = bFRQ;
	}
	public String getLHYFLAG() {
		return LHYFLAG;
	}
	public void setLHYFLAG(String lHYFLAG) {
		LHYFLAG = lHYFLAG;
	}
	public String getCLLXNAME() {
		return CLLXNAME;
	}
	public void setCLLXNAME(String cLLXNAME) {
		CLLXNAME = cLLXNAME;
	}
	public String getCLPP1() {
		return CLPP1;
	}
	public void setCLPP1(String cLPP1) {
		CLPP1 = cLPP1;
	}
	public String getJDCSYR() {
		return JDCSYR;
	}
	public void setJDCSYR(String jDCSYR) {
		JDCSYR = jDCSYR;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getHpzlName() {
		/*if(HPZL!=null){
			return  SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_PLATE_TYPE+Constants.JOIN+HPZL);
		}*/
		return hpzlName;
	}
	public void setHpzlName(String hpzlName) {
		this.hpzlName = hpzlName;
	}
	private String SYXZ;//使用性质
    private String FDJH;//发动机号
    private String FZJG;//发证机关
    private String CLYT;//车辆用途
    private String XB;//性别
    private String CSYSNAME;//车身颜色
    private String CLXH;//车辆型号
    private String SYXZNAME;//使用性质名称
    private String CLZTNAME;//车辆状态名称
    private String DWBH;//单位编号
    private String DWMC;//单位名称
    private String JYYXQZ;//检验有效期止
    private String BFRQ;//报废日期
    private String LHYFLAG;//此条记录是否有六合一车辆信息0---没有   1---有
    private String CLLXNAME;//车辆类型名字
    private String CLPP1;//中文品牌
    private String JDCSYR;//机动车所有人
    private String telephone;//联系电话
    private String hpzlName;//号牌种类名称
	public String getCJDW_NAME() {
		/*if(CJDW!=null){
			return  SysTempStoreUtils.getSysBaseCodeTempState(Constants.DEPT_CODE_TYPE+Constants.JOIN+CJDW);
		}*/
		return CJDW_NAME;
	}
	public void setCJDW_NAME(String cJDW_NAME) {
		CJDW_NAME = cJDW_NAME;
	}
	public String getXSFX_NAME() {
		/*if(FXBH!=null){
			return  SysTempStoreUtils.getSysBaseCodeTempState(Constants.SYS_DIRECTION+Constants.JOIN+FXBH);
		}*/
		return XSFX_NAME;
	}
	public void setXSFX_NAME(String xSFX_NAME) {
		XSFX_NAME = xSFX_NAME;
	}
	public String getXINGSHIFANGXIANG() {
		return XINGSHIFANGXIANG;
	}
	public void setXINGSHIFANGXIANG(String xINGSHIFANGXIANG) {
		XINGSHIFANGXIANG = xINGSHIFANGXIANG;
	}
	public String getWEIFAXINGWEI() {
		return WEIFAXINGWEI;
	}
	public void setWEIFAXINGWEI(String wEIFAXINGWEI) {
		WEIFAXINGWEI = wEIFAXINGWEI;
	}
	public String getHAOPAIYANSE() {
		return HAOPAIYANSE;
	}
	public void setHAOPAIYANSE(String hAOPAIYANSE) {
		HAOPAIYANSE = hAOPAIYANSE;
	}
	public String getHAOPAI() {
		return HAOPAI;
	}
	public void setHAOPAI(String hAOPAI) {
		HAOPAI = hAOPAI;
	}
	public String getHAOPAILAST() {
		return HAOPAILAST;
	}
	public void setHAOPAILAST(String hAOPAILAST) {
		HAOPAILAST = hAOPAILAST;
	}
	public String getSHIJIAN() {
		return SHIJIAN;
	}
	public void setSHIJIAN(String sHIJIAN) {
		SHIJIAN = sHIJIAN;
	}
	public long getWFPK() {
		return WFPK;
	}
	public void setWFPK(long wFPK) {
		WFPK = wFPK;
	}
	public String getWFBH() {
		return WFBH;
	}
	public void setWFBH(String wFBH) {
		WFBH = wFBH;
	}
	public String getWFDD() {
		return WFDD;
	}
	public void setWFDD(String wFDD) {
		WFDD = wFDD;
	}
	public String getWFXW() {
		return WFXW;
	}
	public void setWFXW(String wFXW) {
		WFXW = wFXW;
	}
	public String getFXBH() {
		return FXBH;
	}
	public void setFXBH(String fXBH) {
		FXBH = fXBH;
	}
	public String getHPZL() {
		return HPZL;
	}
	public void setHPZL(String hPZL) {
		HPZL = hPZL;
	}
	public String getHPHM() {
		return HPHM;
	}
	public void setHPHM(String hPHM) {
		HPHM = hPHM;
	}
	public String getHPYS() {
		return HPYS;
	}
	public void setHPYS(String hPYS) {
		HPYS = hPYS;
	}
	public String getCLSD() {
		return CLSD;
	}
	public void setCLSD(String cLSD) {
		CLSD = cLSD;
	}
	public Date getWFKSSJ() {
		return WFKSSJ;
	}
	public void setWFKSSJ(Date wFKSSJ) {
		WFKSSJ = wFKSSJ;
	}
	public Date getWFSJ() {
		return WFSJ;
	}
	public void setWFSJ(Date wFSJ) {
		WFSJ = wFSJ;
	}
	public Date getWFJSSJ() {
		return WFJSSJ;
	}
	public void setWFJSSJ(Date wFJSSJ) {
		WFJSSJ = wFJSSJ;
	}
	public String getKKBH() {
		return KKBH;
	}
	public void setKKBH(String kKBH) {
		KKBH = kKBH;
	}
	public String getSBBH() {
		return SBBH;
	}
	public void setSBBH(String sBBH) {
		SBBH = sBBH;
	}
	public String getWFZJ1() {
		return WFZJ1;
	}
	public void setWFZJ1(String wFZJ1) {
		WFZJ1 = wFZJ1;
	}
	public String getWFZJ2() {
		return WFZJ2;
	}
	public void setWFZJ2(String wFZJ2) {
		WFZJ2 = wFZJ2;
	}
	public String getWFZJ3() {
		return WFZJ3;
	}
	public void setWFZJ3(String wFZJ3) {
		WFZJ3 = wFZJ3;
	}
	public String getWFZJ4() {
		return WFZJ4;
	}
	public void setWFZJ4(String wFZJ4) {
		WFZJ4 = wFZJ4;
	}
	public Integer getCLBZ() {
		return CLBZ;
	}
	public void setCLBZ(Integer cLBZ) {
		CLBZ = cLBZ;
	}
	public Integer getSHBZ() {
		return SHBZ;
	}
	public void setSHBZ(Integer sHBZ) {
		SHBZ = sHBZ;
	}
	public String getSHR() {
		return SHR;
	}
	public void setSHR(String sHR) {
		SHR = sHR;
	}
	public Date getSHSJ() {
		return SHSJ;
	}
	public void setSHSJ(Date sHSJ) {
		SHSJ = sHSJ;
	}
	public String getECSHR() {
		return ECSHR;
	}
	public void setECSHR(String eCSHR) {
		ECSHR = eCSHR;
	}
	public Date getECSHSJ() {
		return ECSHSJ;
	}
	public void setECSHSJ(Date eCSHSJ) {
		ECSHSJ = eCSHSJ;
	}
	public String getSHSM() {
		return SHSM;
	}
	public void setSHSM(String sHSM) {
		SHSM = sHSM;
	}
	public String getSJLY() {
		return SJLY;
	}
	public void setSJLY(String sJLY) {
		SJLY = sJLY;
	}
	public String getCJDW() {
		return CJDW;
	}
	public void setCJDW(String cJDW) {
		CJDW = cJDW;
	}
	public String getCLPP() {
		return CLPP;
	}
	public void setCLPP(String cLPP) {
		CLPP = cLPP;
	}
	public String getCLLX() {
		return CLLX;
	}
	public void setCLLX(String cLLX) {
		CLLX = cLLX;
	}
	public String getCSYS() {
		return CSYS;
	}
	public void setCSYS(String cSYS) {
		CSYS = cSYS;
	}
	public Double getBDSD() {
		return BDSD;
	}
	public void setBDSD(Double bDSD) {
		BDSD = bDSD;
	}
	public String getSYR() {
		return SYR;
	}
	public void setSYR(String sYR) {
		SYR = sYR;
	}
	public String getSYRDH() {
		return SYRDH;
	}
	public void setSYRDH(String sYRDH) {
		SYRDH = sYRDH;
	}
	public String getJSZH() {
		return JSZH;
	}
	public void setJSZH(String jSZH) {
		JSZH = jSZH;
	}
	public String getZPLX() {
		return ZPLX;
	}
	public void setZPLX(String zPLX) {
		ZPLX = zPLX;
	}
	public String getLRR() {
		return LRR;
	}
	public void setLRR(String lRR) {
		LRR = lRR;
	}
	public Date getLRSJ() {
		return LRSJ;
	}
	public void setLRSJ(Date lRSJ) {
		LRSJ = lRSJ;
	}
	public String getSCSJ() {
		return SCSJ;
	}
	public void setSCSJ(String sCSJ) {
		SCSJ = sCSJ;
	}
	public Integer getSCBZ() {
		return SCBZ;
	}
	public void setSCBZ(Integer sCBZ) {
		SCBZ = sCBZ;
	}
	public String getSCDM() {
		return SCDM;
	}
	public void setSCDM(String sCDM) {
		SCDM = sCDM;
	}
	public String getCSBZ() {
		return CSBZ;
	}
	public void setCSBZ(String cSBZ) {
		CSBZ = cSBZ;
	}
	public String getRESVE() {
		return RESVE;
	}
	public void setRESVE(String rESVE) {
		RESVE = rESVE;
	}
	public String getCDBH() {
		return CDBH;
	}
	public void setCDBH(String cDBH) {
		CDBH = cDBH;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getCsbl() {
		return CHAOSUBILI;
	}
	public void setCsbl(String csbl) {
		this.csbl = csbl;
	}
	public Tbloffeevdi(long wFPK, String wFBH, String wFDD, String wFXW,
			String fXBH, String hPZL, String hPHM, String hPYS, String cLSD,
			Date wFKSSJ, Date wFSJ, Date wFJSSJ, String kKBH, String sBBH,
			String wFZJ1, String wFZJ2, String wFZJ3, String wFZJ4,
			Integer cLBZ, Integer sHBZ, String sHR, Date sHSJ, String eCSHR,
			Date eCSHSJ, String sHSM, String sJLY, String cJDW, String cLPP,
			String cLLX, String cSYS, Double bDSD, String sYR, String sYRDH,
			String jSZH, String zPLX, String lRR, Date lRSJ, String sCSJ,
			Integer sCBZ, String sCDM, String cSBZ, String rESVE, String cDBH) {
		super();
		WFPK = wFPK;
		WFBH = wFBH;
		WFDD = wFDD;
		WFXW = wFXW;
		FXBH = fXBH;
		HPZL = hPZL;
		HPHM = hPHM;
		HPYS = hPYS;
		CLSD = cLSD;
		WFKSSJ = wFKSSJ;
		WFSJ = wFSJ;
		WFJSSJ = wFJSSJ;
		KKBH = kKBH;
		SBBH = sBBH;
		WFZJ1 = wFZJ1;
		WFZJ2 = wFZJ2;
		WFZJ3 = wFZJ3;
		WFZJ4 = wFZJ4;
		CLBZ = cLBZ;
		SHBZ = sHBZ;
		SHR = sHR;
		SHSJ = sHSJ;
		ECSHR = eCSHR;
		ECSHSJ = eCSHSJ;
		SHSM = sHSM;
		SJLY = sJLY;
		CJDW = cJDW;
		CLPP = cLPP;
		CLLX = cLLX;
		CSYS = cSYS;
		BDSD = bDSD;
		SYR = sYR;
		SYRDH = sYRDH;
		JSZH = jSZH;
		ZPLX = zPLX;
		LRR = lRR;
		LRSJ = lRSJ;
		SCSJ = sCSJ;
		SCBZ = sCBZ;
		SCDM = sCDM;
		CSBZ = cSBZ;
		RESVE = rESVE;
		CDBH = cDBH;
	}
	public Tbloffeevdi() {
		super();
	}
	@Override
	public String toString() {
		return "违法数据主键=" + WFPK + "\r\n违法地点=" + WFDD + "\r\n违法行为="
				+ WFXW + "\r\n号牌号码=" + HPHM + "\r\n违法时间=" + sdf.format(WFSJ) + "\r\n卡口编号="
				+ KKBH + "\r\n设备编号="+SBBH+"\r\n图片路径1="+WFZJ1+"\r\n图片路径2="+WFZJ2+"\r\n图片路径3="
				+WFZJ3;
	}
	
	
	
    
}