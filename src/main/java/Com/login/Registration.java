package Com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "9699");
		System.out.println("Connection is Done");
		String query = "insert into User values(?,?)";
		String Email = request.getParameter("Email");
		String Password = request.getParameter("pass");
		
		System.out.println(Email+" "+Password);
		PreparedStatement pr = con.prepareStatement(query);
		pr.setString(1, Email);
		pr.setString(2, Password);
		pr.executeUpdate();
		pr.close();
		
		System.out.println("Registration Done!!");
		response.sendRedirect("login.html");  
		
		}catch(Exception e)
		{
			System.out.println("Problem in Connection");
		}
		
		
	}

}
