package com.cist.evidencemanage.util;

import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletResponse;

import sun.net.www.URLConnection;

/**
 * @ClassName: UrlFilesToZip
 * @Description: TODO(Url地址下载图片转换流)
 * @author yt
 * @date 2018年5月28日
 * 
 */
public class UrlFilesToZip {
	
	public static HashMap<String,Object> map=new HashMap<String,Object>();
	//GZIP压缩
	public static byte[] gzip(byte[] data) throws Exception{  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        GZIPOutputStream gzip = new GZIPOutputStream(bos);  
        gzip.write(data);  
        gzip.finish();  
        gzip.close();  
        byte[] ret = bos.toByteArray();  
        bos.close();  
        return ret;  
    } 
    //根据文件链接把文件下载下来并且转成字节码
    public byte[] getImageFromURL(String urlPath,String pk_id){
    	
        byte[] data = null;
        InputStream is = null;
        HttpURLConnection conn = null;
        try {
        	URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            // conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            is = conn.getInputStream();
            if (conn.getResponseCode() == 200) {
                data = readInputStream(is,conn.getContentLength(),pk_id);
            } else {
                data = null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        	  e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            	  e.printStackTrace();
            }
            conn.disconnect();
        }
			return data;
		
    }
    //根据文件链接把文件下载下来并且转成字节码
    public String getImage(String urlPath,String pk_id,HttpServletResponse response,String fileName,String  watermark){
    	
        byte[] data = null;
        String filePath="";
        InputStream is = null;
        HttpURLConnection conn = null;
        File file = null;
        try {
        	URL url = new URL(urlPath);
            conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            // conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(6000);
            is = conn.getInputStream();
            if (conn.getResponseCode() == 200) {

            	file=File.createTempFile("temp",".jpg");
            	filePath=file.getCanonicalPath();
            	int total = conn.getContentLength(); 
            	int n = 1024;  
            	int a = 0;
            	int len;
	            byte buffer[] = new byte[n];  
	            FileOutputStream os = new FileOutputStream(filePath);  
	            while((len=is.read(buffer))>0)
	            {
	            	
	            	 os.write(buffer, 0, len); 
	            	 a+=len;//累计下载文件大小	            	            	 
	            	 DecimalFormat df = new DecimalFormat("0");
	                 String format = df.format(((float)a/(float)total)*100);
	                 map.put(pk_id,Integer.valueOf(format));//获取当前的进度
	                 
	            }
	            os.close();
            	Font font = new Font("宋体", Font.PLAIN, 14);
        		// 增加图片水印
                Color color=new Color(255,255,255,128);               
        		new WaterMarkUtils().mark(file.getCanonicalPath(), file.getCanonicalPath(), watermark, font, color, 0, 0,response,fileName,file);    
        		
            } else {
                data = null;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
        	  e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
            	  e.printStackTrace();
            }
            conn.disconnect();
        }
		return filePath;
		
    }

    public byte[] readInputStream(InputStream is,int total,String pk_id){
		try {
	    	  while (total == 0) { 
	    		  total = is.available(); 
	    	  } 
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = -1;
        try {
            while ((length = is.read(buffer)) != -1) {
            	
                baos.write(buffer, 0, length);
                int a=baos.size();
                DecimalFormat df = new DecimalFormat("0");
                String format = df.format(((float)a/(float)total)*100);
                map.put(pk_id,Integer.valueOf(format));//获取当前的进度
            }
            baos.flush();
        } catch (IOException e) {
        	e.printStackTrace();
        }
        byte[] data = baos.toByteArray();
        try {
            is.close();
            baos.close();
        } catch (IOException e) {
        	e.printStackTrace();
        }
			return data;
    }
}
