package com.cist.illegalUpload.service;

import java.util.Iterator;
import java.util.Map;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class VehicleUtil {
	private static Service service = new Service();
	private static Call call = null;
	/**
	 *写入六合一系统数据
	 *@param dywf 调用的方法
	 *@Param xtlb 系统类别       接口提供者的业务类别代码，如机动车登记业务：01，驾驶证管理业务：02，违法处理：03，事故处理：04，交警队平台：10，剧毒品业务：06
	 *@Param jkxlh 接口序列号 
	 *@param jkid  接口标识  
	 *@param WriteXmlDoc  查询条件  封装查询条件的XML格式文档
	 *@return 
	 */
	public static String writeObjectOut_zhijie(String dywf,String xtlb,String jkxlh,String jkid,StringBuffer WriteXmlDoc){
		try {
			 String webserviceUrl="http://51.56.81.194:9080/zjxtService/services/TmriOutAccess?wsdl";
			call = (Call) service.createCall();//http://10.64.16.45:9080/zjxtService/services/TmriOutAccess?wsdl
			call.removeAllParameters();
			call.setTargetEndpointAddress(webserviceUrl);
			call.setOperationName(dywf);
			call.addParameter("xtlb",
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.addParameter("jkxlh",
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.addParameter("jkid",
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.addParameter("QueryXmlDoc",
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
			call.setUseSOAPAction(true);
			String s = (String) call.invoke(new Object[] {xtlb,jkxlh,jkid,WriteXmlDoc.toString()});
			return s;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("-----写入六合一系统出错------");
		}
		return null;
	}
	/**
	 *生成WriteXmlDoc文档格式
	 *@Param vio 节点标签       
	 *@Param map 写入数据的字段和对应的值
	 *@return 
	 */
	public static StringBuffer WriteXmlDoc(String vio,Map<String, String> map){
		try {
			StringBuffer writexml = new StringBuffer();
			if(vio.equals("") || vio == null || map == null){
				return null;
			}else{
				writexml.append("<?xml version=\"1.0\" encoding=\"GBK\"?>");
				writexml.append("<root>");
				writexml.append("<"+vio+">");
				
				Iterator<String> iter = map.keySet().iterator();
				while (iter.hasNext()) {
					String key = iter.next();
					String value = map.get(key);
				    writexml.append("<"+key+">"+value+"</"+key+">");
				}
				
				writexml.append("</"+vio+">");
				writexml.append("</root>");
			}
			return writexml;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("------生成WriteXmlDoc文档格式出错------");
		}
		return null;
	}
	
	
	/**
	 *电子监控录入（未审核）
	 *@Param vio 节点标签       
	 *@Param map 写入数据的字段和对应的值
	 *@return 
	 *接口标识 04C53
	 *节点标签 viosurveil
	 *接口序列号 S18AB817D4009DFD6526E6CB6A4D6N
	 *系统类别 
	 */
	public String Uploadillage_wsh(String vio,Map<String, String> map){
		try {
			StringBuffer wxml = WriteXmlDoc(vio,map);
			if(wxml != null && !"".equals(wxml)){
				String restr = writeObjectOut_zhijie("writeObjectOut","04","46858161CDA7C2FEBF434494C5D547","04C52",wxml);

				return restr;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("------调用出错-----");
		}
		return null;
	}
	/**
	 *查询车辆
	 *@Param vio 节点标签       
	 *@Param map 写入数据的字段和对应的值
	 *@return 
	 *接口标识 01C48
	 *节点标签 QueryCondition
	 *接口序列号 S18AB817D4009DFD6526E6CB6A4D6N
	 *系统类别 
	 */
	public static String search_car(String vio,Map<String, String> map){
		try {
			if(map != null && (map.get("hphm").toString().indexOf("学") != -1 || map.get("hphm").toString().indexOf("挂") != -1)){
				map.put("hphm", map.get("hphm").toString().substring(0, map.get("hphm").toString().length()-1));
			}
			StringBuffer wxml = WriteXmlDoc(vio,map);// 01C48  E5C5F6B60U72D9YC55029791A3KF33   E5C5F6B60U72D9YC55029791A3KF33
			if(wxml != null && !"".equals(wxml)){
				return writeObjectOut_zhijie("queryObjectOut", "A0", "46858161CDA7C2FEBF434494C5D547", "A0A99", wxml);//查
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("------调用出错-----");
		}
		return null;
	}
}
