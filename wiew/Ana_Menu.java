package wiew;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

import Help.*;
import Model.*;


public class Ana_Menu extends JFrame {

	private JPanel contentPane;
	private JTextField textField_11;
	private JPasswordField passwordField_11;
	private JTextField textField_1;
	private JPasswordField passwordField_1;
	private DBcon conn = new DBcon();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ana_Menu frame = new Ana_Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ana_Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Sisteme Hosgeldiniz");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(200, 10, 180, 30);
		contentPane.add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(30, 55, 500, 350);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Ogretmen Giris", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Ogretmen No:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(50, 50, 150, 50);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sifre:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(50, 150, 150, 50);
		panel.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 50, 200, 50);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(200, 150, 200, 50);
		panel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("Giris");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().length() == 0 || passwordField_1.getText().length() == 0 ) {
					Help.Warnings.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.conDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM notsistemi.ogretmen");
						while(rs.next()) {
							if(textField_1.getText().equals(rs.getString("ogretmenno")) && passwordField_1.getText().equals(rs.getString("ogretmensifre")) ) {
								ogretmen ogrt = new ogretmen();
								ogrt.setOgretmenid(rs.getInt("ogretmenid"));
								ogrt.setOgretmensifre(rs.getString("ogretmensifre"));
								ogrt.setOgretmenadi(rs.getString("ogretmenadi"));
								ogrt.setOgretmenno(rs.getString("ogretmenno"));
								Ogretmen_Menu ogrtGUI = new Ogretmen_Menu (ogrt);
								ogrtGUI.setVisible(true);
								dispose(); }
						}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(200, 250, 200, 50);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Ogrenci Giris", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ogrenci No: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(50, 50, 150, 50);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sifre:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(50, 150, 150, 50);
		panel_1.add(lblNewLabel_2);
		
		textField_11 = new JTextField();
		textField_11.setBounds(200, 50, 200, 50);
		panel_1.add(textField_11);
		textField_11.setColumns(10);
		
		passwordField_11 = new JPasswordField();
		passwordField_11.setBounds(200, 150, 200, 50);
		panel_1.add(passwordField_11);
		
		JButton btnNewButton_1 = new JButton("Giris");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_11.getText().length() == 0 || passwordField_11.getText().length() == 0 ) {
					Help.Warnings.showMsg("fill");
				}
				else {
					try {
						Connection con = conn.conDb();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM notsistemi.ogrenci");
						while(rs.next()) {
							if(textField_11.getText().equals(rs.getString("ogrencino")) && passwordField_11.getText().equals(rs.getString("ogrencisifre")) ) {
								ogrenci ogrnc = new ogrenci();
								ogrnc.setOgrenciid(rs.getInt("ogrenciid"));
								ogrnc.setOgrencisifre(rs.getString("ogrencisifre"));
								ogrnc.setOgrenciadi(rs.getString("ogrenciadi"));
								ogrnc.setOgrencino(rs.getString("ogrencino"));
								ogrnc.setOgrencinot(rs.getInt("ogrencinot"));
								Ogrenci_Menu ogrncGUI = new Ogrenci_Menu (ogrnc);
								ogrncGUI.setVisible(true);
								dispose(); 
							}
							}
					}catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(200, 250, 200, 50);
		panel_1.add(btnNewButton_1);
	}
}
