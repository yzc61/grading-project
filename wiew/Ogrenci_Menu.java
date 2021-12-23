package wiew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ogrenci;
import Model.ogretmen;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Ogrenci_Menu extends JFrame {
	static ogrenci ogrnc = new ogrenci ();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ogrenci_Menu frame = new Ogrenci_Menu(ogrnc);
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
	public Ogrenci_Menu(ogrenci ogrnc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(10, 10, 90, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(ogrnc.getOgrenciadi());
		textField.setEditable(false);
		textField.setBounds(120, 10, 90, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNo = new JLabel("No :");
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNo.setBounds(10, 50, 90, 30);
		contentPane.add(lblNo);
		
		textField_1 = new JTextField();
		textField_1.setText(ogrnc.getOgrencino());
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(120, 50, 90, 30);
		contentPane.add(textField_1);
		
		JLabel lblSifre = new JLabel("Sifre :");
		lblSifre.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblSifre.setBounds(10, 90, 90, 30);
		contentPane.add(lblSifre);
		
		textField_2 = new JTextField();
		textField_2.setText(ogrnc.getOgrencisifre());
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 90, 90, 30);
		contentPane.add(textField_2);
		
		JLabel lblNot = new JLabel("Not :");
		lblNot.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNot.setBounds(10, 130, 90, 30);
		contentPane.add(lblNot);
		
		textField_3 = new JTextField();
		textField_3.setText(Integer.toString(ogrnc.getOgrencinot()));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(120, 130, 90, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(280, 50, 120, 30);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Yeni Sifre :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel_4.setBounds(280, 10, 120, 30);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Degistir");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField_4.getText().length() == 0) {
					Help.Warnings.showMsg("fill");
				}else {
					if(Help.Warnings.confirm("sure")) {
					try {
						boolean control = ogrnc.SifreDegistir(Integer.toString(ogrnc.getOgrenciid()), textField_4.getText());
						if(control) {
							Help.Warnings.showMsg("success");
							//textField_2.setText(null);
							//textField_2.setText(ogrnc.getOgrencisifre()); // ogrenci sýnýfýnda yeni metot yaz return ile döndür
						}
						
					} catch (SQLException e1) {
						e1.printStackTrace();
						}
					}	
				}
				//textField_2.setText(btnNewButton.getActionCommand());
			}	
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton.setBounds(280, 90, 120, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cikis");
		btnNewButton_2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnNewButton_2.setBounds(280, 130, 120, 30);
		contentPane.add(btnNewButton_2);
	}
	}
	
	

