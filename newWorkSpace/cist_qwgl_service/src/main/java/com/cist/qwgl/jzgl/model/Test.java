package com.cist.qwgl.jzgl.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) throws ParseException {
		String timr="2018年11月16日".replace("年", "-").replace("月", "-").replace("日", "");
		SimpleDateFormat data=new SimpleDateFormat("yyyy-MM-dd");
          System.err.println(data.parse(timr));
	}

}
