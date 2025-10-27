package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.DBconnection;

public class OwnerDao {
	public static boolean validateLogin(String username,String password) throws SQLException, Exception {
		try(Connection conn = DBconnection.getConnection()){
			PreparedStatement smt = conn.prepareStatement("select username,password from owner where username=? and password=?");
			smt.setString(1, username);
			smt.setString(2, password);
			ResultSet rs = smt.executeQuery();
			return rs.next();
		}catch (Exception e) {
            e.printStackTrace();
        }
        return false;
	}
	
	public static boolean registerOwner(String username,String password,String email,String code) throws Exception{
		try(Connection conn = DBconnection.getConnection()){
			PreparedStatement smt = conn.prepareStatement("select username from owner where username=?");
			smt.setString(1, username);
			ResultSet rt = smt.executeQuery();
			if(rt.next() || !code.equals("FreeRegister101")) {
				return false;
			}else {
				PreparedStatement insert = conn.prepareStatement("insert into owner(username,password,email) values(?,?,?)");
				insert.setString(1, username);
				insert.setString(2, password);
				insert.setString(3, email);
				insert.executeUpdate();
				return true;
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
		return false;
	}
}

