package com.cist.configUrl.model;

import java.io.ByteArrayInputStream;
import java.util.Date;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import com.cist.frame.springContext.SpringContextUtil;

public class LedFileUtil {

	public static String FileUploadService(byte[] file) {

		String name = "";
		String ftp_ip = "";
		int ftp_port = 21;
		String ftp_user = "";
		String ftp_pwd = "";
		String http_ip = "";
		String http_port = "";
		// 创建一个FTPClient对象
		try {
			ConfigUrlBean cfg = SpringContextUtil.getBeanByName(
					"configUrlBean", ConfigUrlBean.class);
			ftp_ip = cfg.getPicFtpUrl();
			ftp_port = Integer.parseInt(cfg.getPicFtpPort());
			ftp_user = cfg.getFtpUser();
			ftp_pwd = cfg.getFtpPwd();
			http_ip = cfg.getPicHttpUrl();
			http_port = cfg.getPicHttpPort();
			FTPClient ftpClient = new FTPClient();

			// 创建FTP连接,端口号可以设定，我的是22，默认是21
			ftpClient.connect(ftp_ip, ftp_port);

			// 登录FTP服务器，使用用户名和密码
			ftpClient.login(ftp_user, ftp_pwd);

			// 上传文件,读取本地文件
			/*
			 * String path = "D:\\QQ20180726110606.png"; FileInputStream
			 * inputStream = new FileInputStream(new File(path));
			 */

			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);// ************此处是重点要不就服务器的图像就被损坏
			ftpClient.enterLocalPassiveMode();
			// 设置上传的路径
			// "/soft/wfsj"
			String pathname = "/data";// 这个路径就是FTP服务端存储的路径，可以从FileZilla中获取
			ftpClient.changeWorkingDirectory(pathname);

			// 参数一：服务器端文档名；参数二：上传文档的inputStream
			// bb983a34-f57d-4a68-b44c-6423859a7f2e.png
			// int index = file.getName().lastIndexOf(".");
			// String last = file.getName().substring(index,
			// file.getName().length());
			Date da = new Date();
			int ra = (int) (1 + Math.random() * (1000 - 1 + 1));
			name = da.getTime() + String.valueOf(ra) + "ledpic.jpg";
			boolean storeUniqueFile = ftpClient.storeUniqueFile(name,
					new ByteArrayInputStream(file));
			if (!storeUniqueFile) {
				return "false";
			}
			System.out.println(storeUniqueFile);
			// 关闭连接
			ftpClient.logout();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "http://" + http_ip + ":" + http_port + "/" + name;

	}

}
