package wiew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import Model.*;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;

public class Not_Giris extends JFrame {

	static ogretmen ogrt = new ogretmen ();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblYeniNot;
	private JTextField textField_2;
	private JLabel lblOgrenciNo;
	private JTextField textField_3;
	private JLabel lblOg;
	private DefaultTableModel ogrenciModel = null;
	private Object[] ogrenciData = null;
	private JTable table;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Not_Giris frame = new Not_Giris(ogrt);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Not_Giris(ogretmen ogrt) throws SQLException {
		
		
		ogrenciModel = new DefaultTableModel();
		Object [] colOgrenciName = new Object [4];
		colOgrenciName[0] = "Ogrenci Id";
		colOgrenciName[1] = "Ogrenci Adi";
		colOgrenciName[2] = "Ogrenci No";
		colOgrenciName[3] = "Ogrenci Notu";
		ogrenciModel.setColumnIdentifiers(colOgrenciName);
		ogrenciData = new Object [4];
		for (int i=0; i< ogretmen.getOgrenciList().size(); i++) {
			ogrenciData[0] = ogretmen.getOgrenciList().get(i).getOgrenciid();
			ogrenciData[1] = ogretmen.getOgrenciList().get(i).getOgrenciadi();
			ogrenciData[2] = ogretmen.getOgrenciList().get(i).getOgrencino();
			ogrenciData[3] = ogretmen.getOgrenciList().get(i).getOgrencinot();
			ogrenciModel.addRow(ogrenciData);
		
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 300, 350);
		contentPane.add(scrollPane);
		
		table = new JTable(ogrenciModel);
		scrollPane.setViewportView(table);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent e) {
				try {
					textField_3.setText(table.getValueAt(table.getSelectedRow(),1).toString());
					textField_2.setText(table.getValueAt(table.getSelectedRow(),2).toString());
					textField.setText(table.getValueAt(table.getSelectedRow(),3).toString());
				} catch (Exception e2) {
					
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Guncel Not :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNewLabel.setBounds(320, 110, 120, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(450, 110, 60, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		NumberFormat format = NumberFormat.getInstance();    //to get only 0-100 input
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
	    formatter.setMinimum(0);
	    formatter.setMaximum(100);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		
	    textField_1 = new JFormattedTextField(formatter);
		textField_1.setColumns(10);
		textField_1.setBounds(450, 160, 60, 30);
		contentPane.add(textField_1);
		
		lblYeniNot = new JLabel("Yeni Not :");
		lblYeniNot.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblYeniNot.setBounds(320, 160, 120, 30);
		contentPane.add(lblYeniNot);
		
		JButton btnNewButton = new JButton("Guncelle");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				int c = Integer.parseInt(textField_1.getText());
				String b =  table.getValueAt(table.getSelectedRow(),0).toString();   //getting student id
				if(c>=0) {	
					try {
						boolean control = ogretmen.notDuzenleme(b,c );
						//textField.getText()
						if(control) {
							Help.Warnings.showMsg("success");
							textField.setText(null);
							textField_1.setText(null);
							textField_2.setText(null);
							textField_3.setText(null);
							uptadeOgrenciModel();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					Help.Warnings.showMsg("wrongNum");
				}
				
			}
		});
		btnNewButton.setBounds(400, 200, 120, 30);
		contentPane.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(450, 60, 60, 30);
		contentPane.add(textField_2);
		
		lblOgrenciNo = new JLabel("Ogrenci No :");
		lblOgrenciNo.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblOgrenciNo.setBounds(320, 60, 130, 30);
		contentPane.add(lblOgrenciNo);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(450, 10, 60, 30);
		contentPane.add(textField_3);
		
		lblOg = new JLabel("Ogrenci Adi :");
		lblOg.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblOg.setBounds(320, 10, 130, 30);
		contentPane.add(lblOg);
		
		btnNewButton_1 = new JButton("Ust Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				Ogretmen_Menu ogrtGUI = new Ogretmen_Menu (ogrt);
				ogrtGUI.setVisible(true);
				dispose(); 
			}
		});
		btnNewButton_1.setBounds(400, 250, 120, 30);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Cikis");
		btnNewButton_2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(400, 300, 120, 30);
		contentPane.add(btnNewButton_2);
	}
	
	public void uptadeOgrenciModel() throws SQLException {
		DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
		clearModel.setRowCount(0);
		for (int i=0; i< ogretmen.getOgrenciList().size(); i++) {
			ogrenciData[0] = ogretmen.getOgrenciList().get(i).getOgrenciid();
			ogrenciData[1] = ogretmen.getOgrenciList().get(i).getOgrenciadi();
			ogrenciData[2] = ogretmen.getOgrenciList().get(i).getOgrencino();
			ogrenciData[3] = ogretmen.getOgrenciList().get(i).getOgrencinot();
			ogrenciModel.addRow(ogrenciData);
		}
		}
	
}
