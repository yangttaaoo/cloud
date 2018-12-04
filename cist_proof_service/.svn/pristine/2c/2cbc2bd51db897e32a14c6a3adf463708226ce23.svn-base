package com.cist.evidencemanage.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yt
 * @Date 2018/09/20
 * @use 利用Java代码给图片加水印
 */
public class WaterMarkUtils {

	/**
	 * 给图片增加文字水印
	 * 
	 * @param imgPath
	 *            -要添加水印的图片路径
	 * @param outImgPath
	 *            -输出路径
	 * @param text-文字
	 * @param font
	 *            -字体
	 * @param color
	 *            -颜色
	 * @param x
	 *            -文字位于当前图片的横坐标
	 * @param y
	 *            -文字位于当前图片的竖坐标
	 */
	public void mark(String imgPath, String outImgPath, String text, Font font, Color color, int x, int y,HttpServletResponse response,String fileName,File file) {
		try {
			// 读取原图片信息
			File imgFile = null;
			Image img = null;
			if (imgPath != null) {
				imgFile = new File(imgPath);
			}
			
//			&& imgFile.exists() && imgFile.isFile() && imgFile.canRead()
			if (imgFile != null ) {
				img = ImageIO.read(imgFile);
			}
			int imgWidth = img.getWidth(null);
			int imgHeight = img.getHeight(null);
			// 加水印
			BufferedImage bufImg = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
			
			mark(bufImg, img, text, font, color, imgWidth-100-100-40, imgHeight-10);
			// 输出图片
			FileOutputStream outImgStream = new FileOutputStream(outImgPath);
			ImageIO.write(bufImg, "jpg", outImgStream);
//			//在输出之前不能忘记设置内容的形式哦
//	    	response.reset();
//			response.setCharacterEncoding("utf-8");
//			response.setContentType("multipart/form-data");
//	        fileName = new java.net.URLDecoder().decode(fileName, "utf-8");
//			response.setHeader("Content-Disposition", "attachment;fileName=\"" + fileName + "\"");
//			ImageIO.write(bufImg,"png(jpg,...)",response.getOutputStream());
			outImgStream.flush();
			outImgStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
		}
	}
	// 加文字水印
		public void mark(BufferedImage bufImg, Image img, String text, Font font, Color color, int x, int y) {
			Graphics2D g = bufImg.createGraphics();
			
			 //设置水印的坐标
            int m = bufImg.getWidth() - 2*getWatermarkLength(text, g);  
            int n = bufImg.getHeight() - 2*getWatermarkLength(text, g);  
			g.drawImage(img, 0, 0, bufImg.getWidth(), bufImg.getHeight(), null);
			g.setColor(color);
			g.setFont(font);

			g.drawString(text, x, y);
			g.dispose();
		}
	    public int getWatermarkLength(String waterMarkContent, Graphics2D g) {  
	        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());  
	    }  
    public static void main(String[] args) {
		Font font = new Font("宋体", Font.PLAIN, 14);
		// 原图位置, 输出图片位置, 水印文字颜色, 水印文字
		// new MarkText4J().mark("eguidMarkText2.jpg", "eguidMarkText2.jpg", "水印效果测试", font, Color.ORANGE, 0, 14);
		// 增加图片水印
        Color color=new Color(255,255,255,128);  
//		new WaterMarkUtils().mark("H:\\1537411829103855.jpg", "H:\\1537411829103855.jpg", "图片来源：http://blog.csdn.net/zjq_1314520", font, color, 0, 0);
	}

}

