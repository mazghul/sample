import java.sql.*;

public class validate {
	public static boolean val(String name,int reg){
		boolean status=false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/students","root","aaaa");
			
			PreparedStatement ps=con.prepareStatement("select * from list where name=? and reg=?");
			ps.setString(1,name);
			ps.setInt(2,reg);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
			
		}catch(Exception e){System.out.println(e);}
		return status;
		}

}
