package Help;

import javax.swing.JOptionPane;

public class Warnings {
	
	public static void showMsg (String str) {
		String msg;
		
		switch (str) {
		case "fill":
			msg = "Lutfen tum alanlari doldurunuz.";
			break;
		case "success":
			msg = "Islem Basarili ";
			break;
		case "wrongNum":
			msg = "Lutfen gecerli bir sayi giriniz ";
			break;
		default:
			msg = str;
		
		}
		
	JOptionPane.showMessageDialog(null,msg,"Mesaj",JOptionPane.INFORMATION_MESSAGE);	
		
		
	}
	
	public static boolean confirm(String str) {
		String msg;
		switch(str) {
		case "sure":
			msg = "Bu islemi gerceklertirmek istiyor musunuz?";
			break;
		
		default:
			msg = str ;
			break;
		}	
		
		int res = JOptionPane.showConfirmDialog(null, msg, "Dikkat  !", JOptionPane.YES_NO_OPTION);
		if(res==0) {
			return true;
		}else {
			return false;
		}
	}
	
}
