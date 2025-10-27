package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnection {
	private static String user="urmprpp2uajozqlp";
	private static String pass="pArFN3SPjEidAJxVghug";
	private static String url="jdbc:mysql://urmprpp2uajozqlp:pArFN3SPjEidAJxVghug@bpy1t7cqqhr4mklizzau-mysql.services.clever-cloud.com:3306/bpy1t7cqqhr4mklizzau";
	
	public static Connection getConnection() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url,user,pass);
	}
}
