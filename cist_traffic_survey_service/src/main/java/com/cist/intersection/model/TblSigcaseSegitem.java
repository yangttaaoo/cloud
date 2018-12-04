package com.cist.intersection.model;


public class TblSigcaseSegitem {
    private Long xkfa;//路口信控方案ID（参考TBL_SEGITEM_SIGNAL表中PK字段）

    private Long lkxx;//路口信息ID（参考C_ROAD_SEGITEM表中PK字段）
    
    private String xtlkname;//协调路口名称

    public Long getXkfa() {
        return xkfa;
    }

    public void setXkfa(Long xkfa) {
        this.xkfa = xkfa;
    }

    public Long getLkxx() {
        return lkxx;
    }

    public void setLkxx(Long lkxx) {
        this.lkxx = lkxx;
    }

	public String getXtlkname() {
		return xtlkname;
	}

	public void setXtlkname(String xtlkname) {
		this.xtlkname = xtlkname;
	}
}