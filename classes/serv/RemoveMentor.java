package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import impl.MySystemImpl;
import interfaces.MySystem;

public class RemoveMentor extends HttpServlet{
	 String regno ;
	 MySystem myst = new MySystemImpl();
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws ServletException, IOException {
		 regno = request.getParameter("regno");
		 myst.removeMentor(regno);
		 response.sendRedirect("index.html");
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	     doPost(request,response);
	 }
}