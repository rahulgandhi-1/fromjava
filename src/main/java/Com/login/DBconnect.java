package Com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnect {

	String msg;
	public DBconnect(){
		this.msg = null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public boolean connect(String UserName, String UserPassword) throws Exception{
		String pass=null;
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "9699");
		
		try {
		String query = "Select pass from User where name=?";
		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, UserName);
		ResultSet result = pr.executeQuery();
		while(result.next()) {
			pass = result.getNString("pass");
			System.out.println(pass);
		}
		if(pass.equals(UserPassword)) {
			msg = "Logged in successfully";
			pr.close();
			System.out.println(msg);
			return true;
		}
		else {
			msg = "Invalid User Name or Password";
			pr.close();
			
			System.out.println(msg);
			return false;
		}
		
	}catch(Exception e)
		{
			System.out.println("Invalid User Name");
		}
		return false;
	}
}
