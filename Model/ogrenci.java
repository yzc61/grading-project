package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Help.DBcon;

public class ogrenci {
	private int ogrenciid,ogrencinot;
	String ogrenciadi, ogrencino , ogrencisifre ;
	static DBcon conn = new DBcon();
	static Connection con = conn.conDb();
	static Statement st = null;
	static ResultSet rs = null;
	static PreparedStatement preparedStatement = null;
	
	public ogrenci(int ogrenciid, String ogrenciadi, String ogrencino, String ogrencisifre, int ogrencinot) {
		super();
		this.ogrenciid = ogrenciid;
		this.ogrenciadi = ogrenciadi;
		this.ogrencino = ogrencino;
		this.ogrencisifre = ogrencisifre;
		this.ogrencinot = ogrencinot;
	}
	
public  boolean SifreDegistir(String ogrenciid, String ogrencisifre) throws SQLException {
		
		String query = "UPDATE `notsistemi`.`ogrenci` SET `ogrencisifre` = ? WHERE (`ogrenciid` = ?)";
		boolean key = false ;
		try {
			st = con.createStatement();
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(2,ogrenciid);
			preparedStatement.setString(1,ogrencisifre);
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
	
	public ogrenci () {}
	
	public int getOgrenciid() {
		return ogrenciid;
	}
	public void setOgrenciid(int ogrenciid) {
		this.ogrenciid = ogrenciid;
	}
	public String getOgrenciadi() {
		return ogrenciadi;
	}
	public void setOgrenciadi(String ogrenciadi) {
		this.ogrenciadi = ogrenciadi;
	}
	public String getOgrencino() {
		return ogrencino;
	}
	public void setOgrencino(String ogrencino) {
		this.ogrencino = ogrencino;
	}
	public String getOgrencisifre() {
		return ogrencisifre;
	}
	public void setOgrencisifre(String ogrencisifre) {
		this.ogrencisifre = ogrencisifre;
	}
	public int getOgrencinot() {
		return ogrencinot;
	}
	public void setOgrencinot(int ogrencinot) {
		this.ogrencinot = ogrencinot;
	}
	
}
