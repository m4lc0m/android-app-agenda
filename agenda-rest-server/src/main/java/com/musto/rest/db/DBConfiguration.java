package com.musto.rest.db;


public class DBConfiguration {
	
	private final static String DBNAME = "agenda";
	private final static String DBHOST = "localhost";
	private final static String USER = "root";
	private final static String PWD = "xyzt370";
	private final static int PORT = 3306;
	
	public static String getDBName()
	{
		return DBNAME;
	}

	public static String getDBHost()
	{
		return DBHOST;
	}
	public static String getUser()
	{
		return USER;
	}
	public static String getPwd()
	{
		return PWD;
	}
	public static int getPort()
	{
		return PORT;
	}

	
}

