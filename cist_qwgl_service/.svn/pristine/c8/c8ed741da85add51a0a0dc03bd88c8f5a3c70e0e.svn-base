package com.cist.utils;
/***
 * 目前已知Java提供两种方法获取文件路径分割符：
 *File.separator
 *System.getProperty("file.separator")
 * @author Administrator
 *
 */
public class FilePathUtil {
	  public static final String FILE_SEPARATOR = System.getProperty("file.separator");  
	    //public static final String FILE_SEPARATOR = File.separator;  
	  
	    public static String getRealFilePath(String path) {  
	        return path.replace("/", FILE_SEPARATOR).replace("\\", FILE_SEPARATOR);  
	    }  
	  
	    public static String getHttpURLPath(String path) {  
	        return path.replace("\\", "/");  
	    } 
}
