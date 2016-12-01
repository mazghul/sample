// Maz da Edit da.. Git daa

import java.io.*;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class servTwo
 */
@WebServlet("/servTwo")

public class servTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          
		String a=request.getParameter("name");  
		String b=request.getParameter("reg");  
		String c=request.getParameter("m1");  
		String d=request.getParameter("m2"); 
		String e=request.getParameter("m3");
		int bb=Integer.valueOf(b); 
		int cc=Integer.valueOf(c); 
		int dd=Integer.valueOf(d); 
		int ee=Integer.valueOf(e); 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/students","root","aaaa");
			
			PreparedStatement ps=(PreparedStatement) con.prepareStatement("insert into list values(?,?,?,?,?)");  
					  
					ps.setString(1,a);  
					ps.setInt(2,bb);  
					ps.setInt(3,cc);  
					ps.setInt(4,dd); 
					ps.setInt(5,ee);
					int i=ps.executeUpdate();  
					if(i>0)  
					out.print("You are successfully registered...login to view details");  
					      
					RequestDispatcher rd=request.getRequestDispatcher("pageOne.html");
					rd.include(request,response);
					}catch (Exception e2) {System.out.println(e2);}  
					          
					out.close();  
					
					
	}

}
