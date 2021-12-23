package wiew;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ogretmen;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class Ogretmen_Menu extends JFrame {
	
	static ogretmen ogrt = new ogretmen ();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ogretmen_Menu frame = new Ogretmen_Menu(ogrt);
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
	public Ogretmen_Menu(ogretmen ogrt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hosgeldiniz Sayin " + ogrt.getOgretmenadi());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 269, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ogrenci ekle / cikar");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Ekle_Cýkar ekckr = null;
				try {
					ekckr = new Ekle_Cýkar(ogrt);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				} 
				ekckr.setVisible(true);  
				dispose();
				
			}
		});
		btnNewButton.setBounds(50, 80, 150, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Not girisi");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Not_Giris ntgrs = null;
				try {
					ntgrs = new Not_Giris(ogrt);
				} catch (SQLException e2) {
					
					e2.printStackTrace();
				} 
				ntgrs.setVisible(true);  
				dispose();
				
			}
		});
		btnNewButton_1.setBounds(220, 80, 150, 50);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cikis");
		btnNewButton_2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(170, 160, 110, 50);
		contentPane.add(btnNewButton_2);
	}
}
