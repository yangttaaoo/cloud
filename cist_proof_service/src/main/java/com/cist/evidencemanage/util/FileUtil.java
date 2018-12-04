package com.cist.evidencemanage.util;

import java.util.Date;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

	
	public static String FileUploadService(MultipartFile file) {
		
		String name="";
		//创建一个FTPClient对象
				try {
					FTPClient ftpClient = new FTPClient();
					
					//创建FTP连接,端口号可以设定，我的是22，默认是21
					ftpClient.connect("192.168.0.111",6120);
					
					//登录FTP服务器，使用用户名和密码
					ftpClient.login("adminftp", "123456");
					
					//上传文件,读取本地文件
				/*	String path = "D:\\QQ20180726110606.png";
					FileInputStream inputStream = new FileInputStream(new File(path));*/
					
					ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//************此处是重点要不就服务器的图像就被损坏
					ftpClient.enterLocalPassiveMode();
					//设置上传的路径
//					"/soft/wfsj"
					String pathname = "/data";//这个路径就是FTP服务端存储的路径，可以从FileZilla中获取
					ftpClient.changeWorkingDirectory(pathname);
					
					//参数一：服务器端文档名；参数二：上传文档的inputStream  bb983a34-f57d-4a68-b44c-6423859a7f2e.png
					int index=file.getOriginalFilename().lastIndexOf(".");
					String last =file.getOriginalFilename().substring(index,file.getOriginalFilename().length());
					Date da=new Date();
					int ra=(int)(1+Math.random()*(1000-1+1));
					name=da.getTime()+String.valueOf(ra)+last;
					
//					string url = Host.TrimEnd('/') + RemotePath + remoteFileName;
//	                FtpWebRequest request = CreateRequest(url, WebRequestMethods.Ftp.UploadFile);
//	 
//	                //上传数据
//	                using (Stream rs = request.GetRequestStream())
//	                using (FileStream fs = localFile.OpenRead())
//	                {
//	                    byte[] buffer = new byte[4096];//4K
//	                    int count = fs.Read(buffer, 0, buffer.Length);
//	                    while (count > 0)
//	                    {
//	                        rs.Write(buffer, 0, count);
//	                        count = fs.Read(buffer, 0, buffer.Length);
//	                    }
//	                    fs.Close();
//	                    result = true;
					boolean storeUniqueFile = ftpClient.storeUniqueFile(name, file.getInputStream());
					if(!storeUniqueFile) {
						return "false";
					}
					System.out.println(storeUniqueFile);
					//关闭连接
					ftpClient.logout();
				} catch (Exception e) {
					e.printStackTrace();
					return "false";
				}
		
		return "http://192.168.0.111/"+name;
		
	}
}
