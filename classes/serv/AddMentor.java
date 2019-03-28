package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import impl.MySystemImpl;
import interfaces.MySystem;
import valObject.Mentor;


// Extend HttpServlet class
public class AddMentor extends HttpServlet {	
	
	 String fid ;
	 String regno ;
	 Mentor mt = new Mentor();
	 MySystem myst = new MySystemImpl();	
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   fid = request.getParameter("fid");
	   mt.setFID(fid);
	   String regno = request.getParameter("sregno");
	   mt.setRegNo(regno);
	   myst.addMentor(mt);
	   response.sendRedirect("index.html");
   }
   public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	   doPost(request,response);
   }
}