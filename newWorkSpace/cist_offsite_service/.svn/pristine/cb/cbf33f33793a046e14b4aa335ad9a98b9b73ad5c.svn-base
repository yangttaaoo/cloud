package com.cist.personalstats.model;

import java.text.NumberFormat;

public class PersonalStats {

	 
	private String fzsj;//分组时间
	
	private int shzs;//审核总数
	 
	private int cstg;//初审通过
	
    private int cszf;//作废数量
    
    private int fstg;//复审通过
    
    private int fszf;//复审作废数量
    
    private String yxbl;//有效比例
    
    private String wfxw;//违法行为
    
   
	public int getShzs() {
		
		return shzs;
	}

	public void setShzs(int shzs) {
		this.shzs = shzs;
	}

	public int getCstg() {
		return cstg;
	}

	public void setCstg(int cstg) {
		this.cstg = cstg;
	}

	public int getFstg() {
		if(fstg==0)
		{
			return 0;
		}
		return fstg;
	}

	public void setFstg(int fstg) {
		this.fstg = fstg;
	}

	public String getWfxw() {
		return wfxw;
	}

	public void setWfxw(String wfxw) {
		this.wfxw = wfxw;
	}

	public String getYxbl() {
		if(shzs!=0&&cstg+fstg!=0)
		{
			// 创建一个数值格式化对象  
	        NumberFormat numberFormat = NumberFormat.getInstance();  
	        // 设置精确到小数点后0位  
	        numberFormat.setMaximumFractionDigits(0); 
	      String result=numberFormat.format(((float)cstg+(float)fstg) / (float) shzs * 100);
	        return result+"%";
		}
		return "0%";
	}

	public void setYxbl(String yxbl) {
		this.yxbl = yxbl;
	}

	public int getCszf() {
		return cszf;
	}

	public void setCszf(int cszf) {
		this.cszf = cszf;
	}

	public int getFszf() {
		return fszf;
	}

	public void setFszf(int fszf) {
		this.fszf = fszf;
	}

	public String getFzsj() {
		return fzsj;
	}

	public void setFzsj(String fzsj) {
		this.fzsj = fzsj;
	}
	
}
