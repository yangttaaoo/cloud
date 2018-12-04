package com.cist.statistics.stataction.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author hy
 *
 */
public class EnsembleJob implements Serializable{
		/**
	 * 
	 */
	private static final long serialVersionUID = -3560822869525054492L;
		private Date sj;//时间
		private String wfxw;//违法行为
		private Integer zpsl;//抓拍数量
		private Integer shsl;//审核数量
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date kssj;//开始时间
		@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
		private Date jssj;//结束时间
		public Date getSj() {
			return sj;
		}
		public void setSj(Date sj) {
			this.sj = sj;
		}
		public String getWfxw() {
			return wfxw;
		}
		public void setWfxw(String wfxw) {
			this.wfxw = wfxw;
		}
		public Integer getZpsl() {
			return zpsl;
		}
		public void setZpsl(Integer zpsl) {
			this.zpsl = zpsl;
		}
		public Integer getShsl() {
			return shsl;
		}
		public void setShsl(Integer shsl) {
			this.shsl = shsl;
		}
		public Date getKssj() {
			return kssj;
		}
		public void setKssj(Date kssj) {
			this.kssj = kssj;
		}
		public Date getJssj() {
			return jssj;
		}
		public void setJssj(Date jssj) {
			this.jssj = jssj;
		}
		
}
