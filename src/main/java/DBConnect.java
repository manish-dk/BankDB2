import java.awt.Label;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class DBConnect {
	Connection con =null;
	Statement st = null;
	public static void create(String name, String address) {
		if(name.equals("")||name==null||address.equals("")||address==null) {
			WindowManager.generateError("Invalid input");
			return;
		}

		try {
			Connection con =null;
			Statement st = null;
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
			Connection con =null;
			Statement st = null;
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
		double deposits = 0;
		double withdraws = 0;
		try {
			Connection con =null;
			Statement st = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM deposits WHERE accountnumber="+id);
			while(rs.next()) {
				double amount1 = rs.getDouble(1);
				deposits += amount1;
				
			}
			ResultSet rsWithdraws = st.executeQuery("SELECT * FROM withdraws WHERE account_number="+id);
			while(rsWithdraws.next()) {
				double amount1 = rsWithdraws.getDouble(2);
				System.out.println(rsWithdraws.getDouble(2));
				withdraws += amount1;
			}
			if(Double.parseDouble(amount) > deposits-withdraws) {
				WindowManager.generateError("Not Enough Funds");
				return;
			}
			String query = "INSERT INTO withdraws VALUES("+Integer.parseInt(id)+","+Double.parseDouble(amount)+",CURDATE())";
			System.out.println(query);
			st.executeUpdate(query);
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
	}
	
	public static void balance(String id, Label n, Label a, Label b) {
		double deposits = 0;
		double withdraws = 0;
		if(!checkAcc(id)) {
			WindowManager.generateError("No such account");
			return;
		}
		try {
			Connection con =null;
			Statement st = null;
			String name="";
			String address="";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM deposits WHERE accountnumber="+id);
			while(rs.next()) {
				double amount = rs.getDouble(1);
				deposits += amount;
				
			}
			ResultSet rsWithdraws = st.executeQuery("SELECT * FROM withdraws WHERE account_number="+id);
			while(rsWithdraws.next()) {
				double amount = rsWithdraws.getDouble(2);
				System.out.println(rsWithdraws.getDouble(2));
				withdraws += amount;
			}
			ResultSet rsAccount = st.executeQuery("SELECT * from account WHERE accountnumber="+id);
			while(rsAccount.next()) {
				name = rsAccount.getString(2);
				address = rsAccount.getString(3);
			}
			n.setText("Name: "+name);
			a.setText("Address: "+address);
			b.setText("Balance: "+Double.toString(deposits-withdraws));
			rs.close();
			st.close();
			con.close();
		}catch(Exception se) {
			
		}
	}
	
	public static boolean checkAcc(String id) {
		try {
			Connection con =null;
			Statement st = null;
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM account WHERE accountnumber="+id);
			if(rs.next()) {
				return true;
			}
			}catch(Exception se) {
			
		}
		return false;
	}

}
