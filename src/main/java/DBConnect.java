import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBConnect {
	static Connection con =null;
	static Statement st = null;
	public static void create(String name, String address) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			String query = "INSERT INTO account(name,address) VALUES('"+name+"','"+address+"')";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
		
		
	}
	public static void deposit(String id, String amount) {
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			String query = "INSERT INTO deposits VALUES("+Double.parseDouble(amount)+",CURDATE(),"+Integer.parseInt(id)+")";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
	}
	public static void withdraw(String id, String amount) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			String query = "INSERT INTO withdraws VALUES("+Integer.parseInt(id)+","+Double.parseDouble(amount)+",CURDATE())";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
	}
	

}
