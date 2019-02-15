package com.cist;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.imageio.ImageIO;

import sun.rmi.runtime.Log;

public class Text {
public static void main(String[] args) throws IOException {
   /* Integer a=1;//今天   可为0  日环比
    Integer b=0;//昨天 不可为0
    NumberFormat numberFormat = NumberFormat.getInstance();   
    numberFormat.setMaximumFractionDigits(0);   
    String result = numberFormat.format(((float)a-(float)b)/b*100);
    System.out.println("环比:" + result + "%"); 
    System.err.println(result.equals("∞"));//100
    System.err.println(result.equals("�"));*/
/*        List<String> listtime=new ArrayList<String>();
	    for(int i=0;i<7;i++) {
	    Calendar calendar = Calendar.getInstance();  
	    calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - i);  
	    Date today = calendar.getTime();  
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	    String result = format.format(today);
	    System.err.println(result);
	    listtime.add(result);
	    }*/
System.err.println(getCurrentMonthDay());
}
/**
 * 获取当月的 天数
 */
public static int getCurrentMonthDay() {
    Calendar a = Calendar.getInstance();
    a.set(Calendar.DATE, 1);
    a.roll(Calendar.DATE, -1);
    int maxDate = a.get(Calendar.DATE);
    return maxDate;
}
}
    

