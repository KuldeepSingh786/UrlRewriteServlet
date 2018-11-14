package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisServlet extends HttpServlet
{
	public ServletContext sc;
	ArrayList<TrainBean> al;
	
	@SuppressWarnings("unchecked")
	@Override
	public void init()
	{
		sc=this.getServletContext();
		al=(ArrayList<TrainBean>) sc.getAttribute("JcfRef");
	}
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		String tNo=req.getParameter("tno");
		Predicate<TrainBean> p1=(k)-> k.getTrainId().equals(tNo);
		
		al.forEach((z)->
		{
			if(p1.test(z))
			{
				pw.println("=====TRAIN DETAILS=====");
				pw.println("<br>TRAIN ID         : "+z.getTrainId());
				pw.println("<br>TRAIN NAME       : "+z.getTrainName());
				pw.println("<br>FROM STATION     : "+z.getFromStn());
				pw.println("<br>TO STATION       : "+z.getToStn());
				pw.println("<br>AVAILABLE BEARTH : "+z.getAvlBearth());
			}
		}

				
				);
		
		
	}

}
