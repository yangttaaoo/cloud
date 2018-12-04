package com.cist.evidencemanage.util;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FilesUtil {

    /**
     * 上传文件
     * @param filePath 上传文件目录
     * @param fileName 保存的文件名称 
     * @param file 文件流类
     * @param request 请求
     * @throws IOException IO异常
     */
    public static void updoadFile(String filePath,String fileName, MultipartFile file,
            HttpServletRequest request) throws IOException{
        //如果文件夹不存在，则创建文件夹
        File dirPath = new File(filePath);
        if(!dirPath.exists()){
            dirPath.mkdir();   
        }
        
        File uploadFile = new File(dirPath +"/"+ fileName);
        FileCopyUtils.copy(file.getBytes(), uploadFile);    
    }
    
    /**
     * 复制文件
     * @param localFileName 原文件地址和文件名
     * @param tmpFileName 目标文件地址和文件名
     * @throws IOException
     */
    public static void copyFile(String localFileName,String tmpFilePath,String tmpFileName) throws IOException{
        File localFile = new File(localFileName);
        File tmpFile = new File(tmpFilePath,tmpFileName);
        FileCopyUtils.copy(localFile, tmpFile);
    }
    
    /**
     * 删除文件
     * @param fileName 文件地址和文件名
     * @throws IOException
     */
    public static void deleteFile(String fileName) throws IOException{
        File localFile = new File(fileName);
        localFile.delete();
    }
    /**
     * 下载文件，是向页面输出流，不返回流
     * @param filePath 文件服务器存储目录
     * @param downloadName 下载文件保存的文件名
     * @param fileName 服务器存储文件名
     * @param request
     * @param response
     * @throws IOException 
     */
    @SuppressWarnings("static-access")
    public static void downloadFiles(String filePath,String downloadName,String fileName,String pk_id,String flag,HttpServletRequest request,HttpServletResponse response,String  watermark) throws IOException{
    	response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
        fileName = new java.net.URLDecoder().decode(fileName, "utf-8");
        downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
        String path = filePath;
//        response.setHeader("Content-Length", ""+GetFileSize(filePath));
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
//        try {
            //以流的形式下载文件   
        	UrlFilesToZip s = new UrlFilesToZip();
        	UrlFilesToZip.map.put(pk_id,0);//初始化进度为0
        	String image = s.getImage(filePath, pk_id,response,fileName,watermark);
        	 InputStream inStream = new FileInputStream(image);// 文件的存放路径
        	 // 循环取出流中的数据
             byte[] b = new byte[1024];
             int len;
             try {
                 while ((len = inStream.read(b)) > 0)
                     response.getOutputStream().write(b, 0, len);
                 inStream.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
    }
    /**
     * 下载文件，是向页面输出流，不返回流
     * @param filePath 文件服务器存储目录
     * @param downloadName 下载文件保存的文件名
     * @param fileName 服务器存储文件名
     * @param request
     * @param response
     * @throws IOException 
     */
    @SuppressWarnings("static-access")
    public static void downloadFile(String filePath,String downloadName,String fileName,String pk_id,String flag,HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.reset();
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
        fileName = new java.net.URLDecoder().decode(fileName, "utf-8");
        downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
        String path = filePath;
//        response.setHeader("Content-Length", ""+GetFileSize(filePath));
		response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
//        try {
            //以流的形式下载文件   
        	UrlFilesToZip s = new UrlFilesToZip();
        	UrlFilesToZip.map.put(pk_id,0);//初始化进度为0
        	byte[] buffer = s.getImageFromURL(filePath,pk_id);
        	BufferedOutputStream  toClient = new BufferedOutputStream(response.getOutputStream());
            toClient.write(buffer); 
            toClient.flush();
            toClient.close();
    }
    
    /**
     * 获取文件的is
     * @param filePath 文件服务器存储目录
     * @param fileName 服务器存储文件名
     * @param request
     * @param response
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings("static-access")
    public static InputStream getFileIS(String filePath,String fileName,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
        
        fileName = new java.net.URLDecoder().decode(fileName, "utf-8");
        String path = filePath+fileName;                        
        InputStream fis = null;
        try {
            //以流的形式下载文件   
             fis = new BufferedInputStream(new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return fis;
    }
    
    /**
     * 保存文件
     * @param datas    文件数据
     * @param pathName    文件路径
     */
    public static void saveFile(byte[] datas,String pathName){
        File file = new File(pathName);
    
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write(datas);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取文件数据
     * @param pathName    文件路径
     * @return
     */
    public static byte[] getFile(String pathName){
        File file = new File(pathName);
        byte[] buffer = null;  
        try {  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);  
            byte[] b = new byte[1000];  
            int n;  
            while ((n = fis.read(b)) != -1) {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return buffer;  

    }
    
    /**
     * 计算文件大小文件大小
     * @param filePath 文件路径例如：E:\\imgData\\afr\\9211496189393485.jpg
     * @return    文件大小 Kb
     */
    public static long GetFileSize(String filePath){
        long fileSize=0l;
         FileChannel fc= null;  
            try {  
                File f= new File(filePath);  
                if (f.exists() && f.isFile()){  
                    FileInputStream fis= new FileInputStream(f);  
                    fc= fis.getChannel();  
                    fileSize=fc.size()/1024;
                    //logger.info(fileSize); 
                }else{  
                    //logger.info("file doesn't exist or is not a file");  
                }  
            } catch (FileNotFoundException e) {  
                //logger.error(e);  
            } catch (IOException e) {  
                //logger.error(e);  
            } finally {  
                if (null!=fc){  
                    try{  
                        fc.close();  
                    }catch(IOException e){  
                        //logger.error(e);  
                    }  
                }   
            } 
            
            return fileSize;
    }
    
    /**
     * getImage    根据图片的路径获取图片给前台
     * @author sunjianbo
     * @time 2016年8月25日上午10:41:37
     * @param response
     * @param request
     * @param filePath
     * @throws Exception
     */
    //@RequestMapping(value = "/getImage.do", method = RequestMethod.GET)
    public void getImage(HttpServletResponse response, HttpServletRequest request,String filePath)
            throws Exception {
        
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(response.getOutputStream());
            
            byte[] data = getFile(filePath);
            bos.write(data);
            bos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null)
                bos.close();            
        }
    }
    
    
}
