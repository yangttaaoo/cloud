package com.cist.core.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	static
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection()
	{
		Connection con = null;
		try 
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.64.17.209:1521:rmsrv","rm_cdxch","rm_cdxch");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	private static boolean execute(String sqlText)
	{
		Statement stat = null;
		Connection con = null;
		try {
			con = getConnection();
			stat = con.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			return stat.execute(sqlText);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(stat != null)
				{
					stat.close();
				}
				if(con != null)
				{
					con.close();
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public static void fkzt11(String id)
	{
		String sqlText = "update vmc_alarm set fkzt=1 where yjxh="+id;
		execute(sqlText);
	}
	
	public static void ljzt12(String id)
	{
		String sqlText = "update vmc_alarm set ljzt=1 where yjxh="+id;
		execute(sqlText);
	}
	
	public static void qszt22(String id)
	{
		String sqlText = "update vmc_alarm set qszt=1 where yjxh="+id;
		execute(sqlText);
	}
	public static void qszt19(String id)
	{
		String sqlText = "update vmc_alarm set qszt=2 where yjxh="+id;
		execute(sqlText);
	}
	
	public static void main(String [] args)
	{
		fkzt11("5101001901129651");
	}
}
