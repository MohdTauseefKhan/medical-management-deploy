package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static String user="root";
	private static String pass="SyHIfGcYtRWrKBhBeMjcToohqAknJteU";
	private static String url="jdbc:mysql://root:SyHIfGcYtRWrKBhBeMjcToohqAknJteU@shuttle.proxy.rlwy.net:21237/railway";
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,pass);
	}
}
