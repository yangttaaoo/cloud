package com.cist.warningmanagement.model;

import java.math.BigDecimal;
import java.util.Date;

import com.cist.BaseInfo.model.SysBaseDataCode;
import com.cist.frame.utils.SysTempStoreUtils;
import com.fasterxml.jackson.annotation.JsonFormat;

/***
 * 
 * @Title:SssbEquipmentWarning.java
 * @Package:com.cist.devmanagement.model
 * @Description:设施设备预警
 * @author:YT
 * @date:2019年2月26日
 * @version V1.0
 */
public class SssbEquipmentWarning {
    private BigDecimal pk_id;//ID

    private String warning_type;//预警信息，(参考SYS_FRM_CODE表 FCT_CODE=ZDYJ)

    private String source_ip;//源IP

    private String source_mac;//源MAC

    private String source_prot;//源端口号

    private String dest_ip;//目的IP

    private String dest_port;//目的端口号

    private String dac_ip;//DAC设备IP

    private String ifname_inside;//DAC设备入接口

    private String protocol;//协议(参考SYS_FRM_CODE表 FCT_CODE=TXXY)

    private String terminal_type;//终端类型，(参考SYS_FRM_CODE表 FCT_CODE=ZDLX)

    private String terminal_name;//终端名称

    private String terminal_locationt;//终端地理位置

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date warning_time;//预警时间
    
    private String terminal_type_name;//终端类型名称，(参考SYS_FRM_CODE表 FCT_CODE=ZDLX)

    private String protocol_name;//协议名称    
    
    private String warning_type_name;//预警信息名称
    
    
	public BigDecimal getPk_id() {
		return pk_id;
	}

	public void setPk_id(BigDecimal pk_id) {
		this.pk_id = pk_id;
	}

	public String getWarning_type() {
		return warning_type;
	}

	public void setWarning_type(String warning_type) {
		this.warning_type = warning_type;
	}

	public String getSource_ip() {
		return source_ip;
	}

	public void setSource_ip(String source_ip) {
		this.source_ip = source_ip;
	}

	public String getSource_mac() {
		return source_mac;
	}

	public void setSource_mac(String source_mac) {
		this.source_mac = source_mac;
	}

	public String getSource_prot() {
		return source_prot;
	}

	public void setSource_prot(String source_prot) {
		this.source_prot = source_prot;
	}

	public String getDest_ip() {
		return dest_ip;
	}

	public void setDest_ip(String dest_ip) {
		this.dest_ip = dest_ip;
	}

	public String getDest_port() {
		return dest_port;
	}

	public void setDest_port(String dest_port) {
		this.dest_port = dest_port;
	}

	public String getDac_ip() {
		return dac_ip;
	}

	public void setDac_ip(String dac_ip) {
		this.dac_ip = dac_ip;
	}

	public String getIfname_inside() {
		return ifname_inside;
	}

	public void setIfname_inside(String ifname_inside) {
		this.ifname_inside = ifname_inside;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getTerminal_type() {
		return terminal_type;
	}

	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	public String getTerminal_name() {
		return terminal_name;
	}

	public void setTerminal_name(String terminal_name) {
		this.terminal_name = terminal_name;
	}

	public String getTerminal_locationt() {
		return terminal_locationt;
	}

	public void setTerminal_locationt(String terminal_locationt) {
		this.terminal_locationt = terminal_locationt;
	}

	public Date getWarning_time() {
		return warning_time;
	}

	public void setWarning_time(Date warning_time) {
		this.warning_time = warning_time;
	}

	public String getTerminal_type_name() {
		if(terminal_type!=null) {
			terminal_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_ZDLX, terminal_type);
		}
		return terminal_type_name;
	}

	public void setTerminal_type_name(String terminal_type_name) {
		this.terminal_type_name = terminal_type_name;
	}

	public String getProtocol_name() {
		if(protocol!=null) {
			protocol_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_XY, protocol);
		}
		return protocol_name;
	}

	public void setProtocol_name(String protocol_name) {
		this.protocol_name = protocol_name;
	}

	public String getWarning_type_name() {
		if(warning_type != null) {
			warning_type_name = SysTempStoreUtils.getFcName(SysBaseDataCode.SYS_YJXX, warning_type);
		}
		return warning_type_name;
	}

	public void setWarning_type_name(String warning_type_name) {
		this.warning_type_name = warning_type_name;
	}

}