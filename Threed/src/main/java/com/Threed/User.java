package com.Threed;

import java.util.Date;

public class User {

	private Date date1;

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return date1.toString();
	}
}
