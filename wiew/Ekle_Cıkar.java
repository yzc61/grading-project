package wiew;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Model.ogrenci;
import Model.ogretmen;
import Help.*;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ekle_Cýkar extends JFrame {
	static ogretmen ogrt = new ogretmen ();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JLabel lblNewLabel_3;
	private JTextField textField_3;
	private JButton btnNewButton_1;
	private DefaultTableModel ogrenciModel = null;
	private Object[] ogrenciData = null;
	private JTable table;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ekle_Cýkar frame = new Ekle_Cýkar(ogrt);
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
	public Ekle_Cýkar(ogretmen ogrt) throws SQLException{
		
		ogrenciModel = new DefaultTableModel();
		Object [] colOgrenciName = new Object [4];
		colOgrenciName[0] = "Ogrenci Adi";
		colOgrenciName[1] = "Ogrenci No";
		colOgrenciName[2] = "Ogrenci Sifre";
		colOgrenciName[3] = "Ogrenci Notu";
		ogrenciModel.setColumnIdentifiers(colOgrenciName);
		ogrenciData = new Object [4];
		for (int i=0; i< ogretmen.getOgrenciList().size(); i++) {
			ogrenciData[0] = ogretmen.getOgrenciList().get(i).getOgrenciadi();
			ogrenciData[1] = ogretmen.getOgrenciList().get(i).getOgrencino();
			ogrenciData[2] = ogretmen.getOgrenciList().get(i).getOgrencisifre();
			ogrenciData[3] = ogretmen.getOgrenciList().get(i).getOgrencinot();
			ogrenciModel.addRow(ogrenciData);
		
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ogrenci Adi");
		lblNewLabel.setBounds(350, 10, 90, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(430, 10, 90, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ogrenci No");
		lblNewLabel_1.setBounds(350, 70, 90, 30);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(430, 70, 90, 30);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ogrenci Sifre");
		lblNewLabel_2.setBounds(350, 130, 90, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(430, 130, 90, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("Ekle");
		   btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( textField.getText().length() == 0 || textField_1.getText().length() == 0 || textField_2.getText().length() == 0 ) {
					Help.Warnings.showMsg("fill"); }
				else {
					try {
						boolean control = ogretmen.addOgrenci(textField.getText(),textField_2.getText(),textField_1.getText());
						if(control) {
							Help.Warnings.showMsg("success");
							textField.setText(null);
							textField_1.setText(null);
							textField_2.setText(null);
							uptadeOgrenciModel();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}		
			}
		});
		btnNewButton.setBounds(430, 170, 90, 30);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("Ogrenci No");
		lblNewLabel_3.setBounds(350, 220, 90, 30);
		contentPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(430, 220, 90, 30);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton_1 = new JButton("Cikar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if( textField_3.getText().length() == 0 ) {
					Help.Warnings.showMsg("fill");
				}else {
					if(Help.Warnings.confirm("sure")) {
						try {
							boolean control = ogretmen.deleteOgrenci(textField_3.getText());
							if(control) {
								Help.Warnings.showMsg("success");
								textField_3.setText(null);
								uptadeOgrenciModel();
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		btnNewButton_1.setBounds(430, 260, 90, 30);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 330, 400);
		contentPane.add(scrollPane);
		
		
		
		table = new JTable(ogrenciModel);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				try {
					textField_3.setText(table.getValueAt(table.getSelectedRow(),1).toString());
				} catch (Exception e2) {
					
				}
			}
		});
		
		btnNewButton_2 = new JButton("Ust Menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Ogretmen_Menu ogrtGUI = new Ogretmen_Menu (ogrt);
				ogrtGUI.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_2.setBounds(400, 310, 120, 30);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Cikis");
		btnNewButton_3.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(400, 360, 120, 30);
		contentPane.add(btnNewButton_3);
	
	}

	public void uptadeOgrenciModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
		clearModel.setRowCount(0);
		for (int i=0; i< ogretmen.getOgrenciList().size(); i++) {
			ogrenciData[0] = ogretmen.getOgrenciList().get(i).getOgrenciadi();
			ogrenciData[1] = ogretmen.getOgrenciList().get(i).getOgrencino();
			ogrenciData[2] = ogretmen.getOgrenciList().get(i).getOgrencisifre();
			ogrenciModel.addRow(ogrenciData);
		}
		}

}
