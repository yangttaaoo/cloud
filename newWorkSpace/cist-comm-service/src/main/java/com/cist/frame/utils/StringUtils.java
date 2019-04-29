package com.cist.frame.utils;

public class StringUtils {

	public static String addZeroForFiled(String str,int strLength) {  
		  int strLen =str.length();  
		  if (strLen <strLength) {  
		   while (strLen< strLength) {  
		    StringBuffer sb = new StringBuffer();  
		    sb.append("0").append(str);//左补0  
		    str= sb.toString();  
		    strLen= str.length();  
		   }  
		  }  
		  return str;  
		 }  
}
