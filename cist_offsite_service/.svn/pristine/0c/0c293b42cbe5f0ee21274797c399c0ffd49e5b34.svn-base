package com.cist.core.utils;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public enum PropertyUtils implements Serializable
{
	INSTANCE;
	
	/**
	INSTANCE{

		@Override
		protected void init() {
			// TODO Auto-generated method stub
		}
		
	};
	
	protected abstract void init();
	*/
	
	private Properties systemConfig=null;
	
	private final String SYSTEMCONFIG_PATH="system.properties";
  
	private  Logger log=LoggerFactory.getLogger(PropertyUtils.class.getName());
	
	/* 默认是私有构造器*/
	PropertyUtils(){
		try{
			systemConfig=ResourcesUtils.getResourceAsProperties(SYSTEMCONFIG_PATH);
		}catch (Exception e) {
			// TODO: handle exception
			log.error("加载system.properties文件出错:",e);
		}
	}
	
 public int getPropertyAsInteger(String propName)
  {
    return Integer.parseInt(getProperty(systemConfig, propName,"0"));
  }

  public String getProperty(Properties props, String name,String defaultValue)
  {
    return props.getProperty(name,defaultValue).trim();
  }

  public  boolean getPropertyAsBoolean(String name)
  {
    return Boolean.valueOf(getProperty(systemConfig, name,"false")).booleanValue();
  }

  public  long getPropertyAsLong(String name,String defualtValue)
  {
    return Long.parseLong(getProperty(systemConfig, name,defualtValue));
  }

  public  short getPropertyAsShort(String name)
  {
    return Short.parseShort(getProperty(systemConfig, name,"0"));
  }

  public  byte getPropertyAsByte(String name)
  {
    return Byte.parseByte(getProperty(systemConfig, name,"0"));
  }
  
  
  public  InetSocketAddress getInetSocketAddress(String ip,String port){
	return new InetSocketAddress(systemConfig.getProperty(ip), Integer.parseInt(systemConfig.getProperty(port)));
  }
	
	public  int getPropertyAsInteger(String key,String defaultValue){
		return Integer.parseInt(systemConfig.getProperty(key,defaultValue));
	}
	
	public String getProperty(String name,String defaultValue){
		
		return getProperty(systemConfig, name,defaultValue);
	}
	
	public String getVersion(){
		return getProperty("com.cist.system.server.version","0830");
	}
}