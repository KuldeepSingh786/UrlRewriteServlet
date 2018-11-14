package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet
{
	public ServletContext sc;
	public Connection con;
	ArrayList<TrainBean> al;
	
	@Override
	public void init()
	{
		sc=this.getServletContext();
		con=DBConnection.getCon();
		al=new ArrayList<TrainBean>();
	}
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		try
		{
			PreparedStatement ps=con.prepareStatement("select * from trainInfo");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				TrainBean tb=new TrainBean();
				tb.setTrainId(rs.getString(1));
				tb.setTrainName(rs.getString(2));
				tb.setFromStn(rs.getString(3));
				tb.setToStn(rs.getString(4));
				tb.setAvlBearth(rs.getInt(5));
				
				al.add(tb);
				
				pw.println("<br><a href='dis?tno="+rs.getString(1)+"'>"+rs.getString(1)+"</a>");
				pw.println(rs.getString(2));				
			}
			
			sc.setAttribute("JcfRef", al);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
