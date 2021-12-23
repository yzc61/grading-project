package Help;
import java.sql.*;


public class DBcon {

		Connection c = null;
		
		public DBcon () {
		}
		
		public Connection conDb () {
			try {
				this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/notsistemi?user=root&password=12345");
				return c;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return c;
		}
	
}
