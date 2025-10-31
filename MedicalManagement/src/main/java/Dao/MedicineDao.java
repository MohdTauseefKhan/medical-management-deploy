package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Medicine;
import Util.DBconnection;

public class MedicineDao {
	public static List<Medicine> getMedicineList(String username) {
		List<Medicine> medicines= new ArrayList<>();
		try(Connection connection = DBconnection.getConnection()){
			PreparedStatement smt1 = connection.prepareStatement("SELECT owner_id from owner where username=?");
			smt1.setString(1, username);
			ResultSet rs1= smt1.executeQuery();
			int owner_id=0;
			if(rs1.next()) {
				owner_id=rs1.getInt("owner_id");
			}
			PreparedStatement smt= connection.prepareStatement("SELECT * FROM medicine where owner_id=?");
			smt.setInt(1, owner_id);
			ResultSet rs = smt.executeQuery();
			while(rs.next()) {
				Medicine m = new Medicine();
				m.setId(rs.getInt("medicine_id"));
                m.setName(rs.getString("name"));
                m.setCategory(rs.getString("category"));
                m.setQuantity(rs.getInt("quantity"));
                String expiryStr = rs.getString("expiry_date");
                java.sql.Date expiryDate = java.sql.Date.valueOf(expiryStr);
                m.setExpiryDate(expiryDate);
                m.setSupplier(rs.getString("supplier"));
                medicines.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return medicines;
	}
	
	public static void addMedicine(String name,String category,int quantity,java.sql.Date expiryDate,String supplierName,String owner) {
		
		try(Connection connection=DBconnection.getConnection()){
			PreparedStatement smt = connection.prepareStatement("SELECT owner_id from owner where username=?");
			smt.setString(1, owner);
			ResultSet rs= smt.executeQuery();
			int owner_id=0;
			if(rs.next()) {
				owner_id = rs.getInt("owner_id");
			}
			PreparedStatement smt1 = connection.prepareStatement("insert into medicine(name,owner_id,category,quantity,expiry_date,supplier) values(?,?,?,?,?,?)");
			smt1.setString(1, name);
			smt1.setInt(2, owner_id);
			smt1.setString(3, category);
			smt1.setInt(4, quantity);
			smt1.setDate(5, expiryDate);
			smt1.setString(6, supplierName);
			smt1.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean sellMedicine(Medicine m) {
		try(Connection conn=DBconnection.getConnection()){
			
			PreparedStatement smt1=conn.prepareStatement("select quantity from medicine where medicine_id=?");
			smt1.setInt(1, m.getId());
			ResultSet rs=smt1.executeQuery();
			int quantity=0;
			if(rs.next())quantity=rs.getInt("quantity");
			if(quantity>=m.getQuantity()) {
			PreparedStatement smt = conn.prepareStatement("update medicine set quantity = quantity - ? where medicine_id = ?");
			smt.setInt(1, m.getQuantity());
			smt.setInt(2, m.getId());
			
			if(smt.executeUpdate()>0) {
				PreparedStatement ps2 = conn.prepareStatement(
					    "DELETE FROM medicine WHERE medicine_id = ? AND quantity <= 0"
					);
					ps2.setInt(1, m.getId());
					ps2.executeUpdate();
				return true;
			}
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static List<Medicine> getSoldMedicineList(String user) {
	    List<Medicine> medicines = new ArrayList<>();
	    try (Connection conn = DBconnection.getConnection()) {
	        PreparedStatement smt = conn.prepareStatement("SELECT owner_id FROM owner WHERE username=?");
	        smt.setString(1, user);
	        ResultSet rs1 = smt.executeQuery();
	        int owner_id = 0;
	        if (rs1.next()) {
	            owner_id = rs1.getInt("owner_id");
	        }

	        PreparedStatement smt1 = conn.prepareStatement("SELECT * FROM sold_medicine WHERE owner_id=?");
	        smt1.setInt(1, owner_id);
	        ResultSet rs = smt1.executeQuery();

	        while (rs.next()) {
	            Medicine m = new Medicine();
	            m.setId(rs.getInt("medicine_id"));
	            m.setName(rs.getString("name"));
	            m.setCategory(rs.getString("category"));
	            m.setQuantity(rs.getInt("quantity"));
	            m.setExpiryDate(rs.getDate("expiry_date")); // safer
	            m.setSupplier(rs.getString("supplier"));
	            m.setSoldDate(rs.getDate("sold_date"));     // safer
	            medicines.add(m);
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // better debugging
	    }
	    return medicines;
	}
}
