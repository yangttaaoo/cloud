package com.cist.core.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.util.StringUtils;


public class ImageUtils {

	private static final int height = 19;
	private static final int strokeThickness = 1;
	private static final Color topbgColor = new Color(0x0c4c9f);
	private static final Color buttombgColor = new Color(0x246dcc);
	private static final Color borderColor = new Color(0x68a3ee);
	private static final BasicStroke stroke = new BasicStroke(strokeThickness);
	private static final GradientPaint redtowhite = new GradientPaint(0,0,topbgColor,0, 10,buttombgColor,true);
	private static final RenderingHints rdhts = new RenderingHints(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
	private static final Font font=new Font("Default",Font.CENTER_BASELINE ,12); 
	 private static final Logger logger = LoggerFactory.getLogger(ImageUtils.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			
			//BufferedImage image = mergeImage("d:/gps.png","花溪大道师范大学门口500W球机监控点");
			BufferedImage bubble = drawBubble("花溪大道师范大学门口500W球机监控点");
			ImageIO.write(bubble,"PNG", new File("d:/abc.png"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static BufferedImage mergeImage(String filePath,String bubbleText)
	{
		try
		{
			BufferedImage destImg =drawBubble(bubbleText);
			BufferedImage srcImg = ImageIO.read(new File(filePath));
			int w = destImg.getWidth();
			if(destImg.getWidth()<srcImg.getWidth())
			{
				w = srcImg.getWidth();
			}
			
			int h = srcImg.getHeight() + destImg.getHeight();
			BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR ); 
			Graphics2D g = image.createGraphics();
			image = g.getDeviceConfiguration().createCompatibleImage(w, h, Transparency.TRANSLUCENT);
			g.dispose();
			g = image.createGraphics();
			g.drawImage(destImg,0,0,null);
			int posX = destImg.getWidth()/4-srcImg.getWidth()/2;
			int posY = destImg.getHeight();
			g.drawImage(srcImg,posX,posY,null);
			g.dispose();
			image.flush();
			return image;
		}catch(Exception e)
		{
			logger.error("拼接气泡图片出错",e.fillInStackTrace());
		}

		return null;
	}
	
	public static BufferedImage drawBubble(String text)
	{
		try{
				if(StringUtils.isEmpty(text))
				{
					text = "未知";
				}
				AffineTransform textAt = new AffineTransform();
				FontRenderContext textRender = new FontRenderContext(textAt,false,false);
				Rectangle2D bounds = font.getStringBounds(text,textRender);
				int width = (int) bounds.getWidth()+8;
				if(width<50)
				{
					width = 50;
				}
				BufferedImage image = new BufferedImage(width, 35, BufferedImage.TYPE_3BYTE_BGR );  
				Graphics2D g = image.createGraphics();
				image = g.getDeviceConfiguration().createCompatibleImage(width, 35, Transparency.TRANSLUCENT);
				g.dispose();
				g = image.createGraphics();
				g.setPaint(redtowhite);
				Polygon bubble = new Polygon();
				bubble.addPoint(0, 0);
				bubble.addPoint(width-1, 0);
				bubble.addPoint(width-1, height);
				bubble.addPoint(width/4+17, height);
				bubble.addPoint(width/4+3, 35);
				bubble.addPoint(width/4+3, height);
				bubble.addPoint(0, height);
				Area area = new Area();
				area.add(new Area(bubble));
				g.setRenderingHints(rdhts);
				g.setStroke(stroke);
				g.fill(area);
				g.setPaint(borderColor);
				g.draw(area);
				g.setColor(Color.WHITE);
				TextLayout textTl = new TextLayout(text, font, textRender);
				textAt.translate(4, height-6);
				Shape shape = textTl.getOutline(textAt);
				g.fill(shape);
				g.dispose();
				image.flush();
				return image;
				/**
				 int x3Points[] = {width/4, width/4+10, width/4-10};
				 int y3Points[] = {18, 18, 35};
				 GeneralPath filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
				                                                x3Points.length);
				 filledPolygon.moveTo(x3Points[0], y3Points[0]);
				    for ( int index = 1; index < x3Points.length; index++ ) {
				        filledPolygon.lineTo(x3Points[index], y3Points[index]);
				    };
				    filledPolygon.closePath();
				    g.fill(filledPolygon);
				    g.draw(filledPolygon);
				    **/
		}
		catch(Exception e)
		{
			logger.error("创建气泡图片出错",e.fillInStackTrace());
		}
		return null;
	}

}
