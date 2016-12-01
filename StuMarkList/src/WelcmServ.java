
import java.io.PrintWriter;
import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcmServ
 */
public class WelcmServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String n=request.getParameter("name");
		out.println("<h1>Welcome "+n+"</h1>");
		String reg=request.getParameter("reg");
		int regi=Integer.valueOf(reg); 
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/students","root","aaaa");
			
			PreparedStatement ps=con.prepareStatement("select * from list where name=? and reg=?");
			ps.setString(1,n);
			ps.setInt(2,regi);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())  
			out.println("<h3><br/>name:"+rs.getString(1)+"<br/>register no:"+rs.getInt(2)+"<br/>Mark1:"+rs.getInt(3)+"<br/>Mark2:"+rs.getInt(4)+"<br/>Mark3:"+rs.getInt(5)+"<br/>total:"+(rs.getInt(3)+rs.getInt(4)+rs.getInt(5))+"<h3/>"); 
			/*out.println(" register no:"+rs.getInt(2));
			out.println(" Mark1:"+rs.getInt(3));
			out.println(" Mark2:"+rs.getInt(4));
			out.println(" Mark3:"+rs.getInt(5));
			out.println(" total:"+(rs.getInt(3)+rs.getInt(4)+rs.getInt(5)));*/
		
			con.close();  
			
		}catch(Exception e){System.out.println(e);}
		
		out.close();
	}

	
	
}
