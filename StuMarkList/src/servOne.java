
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class serv1
 */

@WebServlet("/servOne")

public class servOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String reg=request.getParameter("reg");
		//int regi = new Integer(reg).intValue();
		int regi=Integer.valueOf(reg);  
		
	    //System.out.print(reg+regi+name);
		if(validate.val(name,regi)){
			RequestDispatcher rd=request.getRequestDispatcher("WelcmServ");
			rd.forward(request,response);
		}
		else{
			out.print("give a unique register number");
			RequestDispatcher rd=request.getRequestDispatcher("registerHere.html");
			rd.include(request,response);
		}
		
		out.close();
	}

	
}
