package Model;

import java.sql.*;
import java.util.ArrayList;

import Help.DBcon;

public class ogretmen {
		private int ogretmenid;
		String ogretmenadi, ogretmenno , ogretmensifre ;
		static DBcon conn = new DBcon();
		static Connection con = conn.conDb();
		static Statement st = null;
		static ResultSet rs = null;
		static PreparedStatement preparedStatement = null;
		
		
		
		public ogretmen(int ogretmenid, String ogretmenadi, String ogretmenno, String ogretmensifre) {
			
			this.ogretmenid = ogretmenid;
			this.ogretmenadi = ogretmenadi;
			this.ogretmenno = ogretmenno;
			this.ogretmensifre = ogretmensifre;
		}
		
		public ogretmen () {}
		
		public static ArrayList<ogrenci> getOgrenciList () throws SQLException{
			ArrayList <ogrenci> list = new ArrayList<>();
			ogrenci obj;
			try {
				st = con.createStatement();
				rs = st.executeQuery("SELECT * FROM notsistemi.ogrenci");
				
				while(rs.next()) {
					obj = new ogrenci(rs.getInt("ogrenciid"),rs.getString("ogrenciadi"),rs.getString("ogrencino"),rs.getString("ogrencisifre"),rs.getInt("ogrencinot"));
					list.add(obj);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			} 
			
			return list;
		}
		
		public static boolean addOgrenci(String ogrenciadi, String ogrencisifre, String ogrencino) throws SQLException {
			
			String query = "INSERT INTO `notsistemi`.`ogrenci` (ogrenciadi, ogrencisifre, ogrencino, ogrencinot) VALUES " + "(?,?,?,'0')";
			boolean key = false ;
			try {
				st = con.createStatement();
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1,ogrenciadi);
				preparedStatement.setString(2,ogrencisifre);
				preparedStatement.setString(3,ogrencino);
				preparedStatement.executeUpdate();
				key = true ;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (key)
			return true;
			else 
				return false;
		}
		
	public static boolean deleteOgrenci(String ogrencino) throws SQLException {
		  
			String query = "DELETE FROM `notsistemi`.`ogrenci` WHERE (`ogrencino` = ?)";
			boolean key = false ;
			try {
				st = con.createStatement();
				preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, ogrencino);
				preparedStatement.executeUpdate();
				key = true ;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (key)
			return true;
			else 
				return false;
		}
	
	public static boolean notDuzenleme(String ogrenciid, int ogrencinot) throws SQLException {
		
		String query = "UPDATE `notsistemi`.`ogrenci` SET `ogrencinot` = ? WHERE (`ogrenciid` = ?)";
		boolean key = false ;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(2,ogrenciid);
			preparedStatement.setInt(1,ogrencinot);
			preparedStatement.executeUpdate();
			key = true ;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (key)
		return true;
		else 
			return false;
	}
		
		public int getOgretmenid() {
			return ogretmenid;
		}
		public void setOgretmenid(int ogretmenid) {
			this.ogretmenid = ogretmenid;
		}
		public String getOgretmenadi() {
			return ogretmenadi;
		}
		public void setOgretmenadi(String ogretmenadi) {
			this.ogretmenadi = ogretmenadi;
		}
		public String getOgretmenno() {
			return ogretmenno;
		}
		public void setOgretmenno(String ogretmenno) {
			this.ogretmenno = ogretmenno;
		}
		public String getOgretmensifre() {
			return ogretmensifre;
		}
		public void setOgretmensifre(String ogretmensifre) {
			this.ogretmensifre = ogretmensifre;
		}
	
	
}
