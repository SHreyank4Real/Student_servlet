package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import impl.MySystemImpl;
import interfaces.MySystem;

public class RemoveFaculty extends HttpServlet{
	 String fid ;
	 MySystem myst = new MySystemImpl();
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws ServletException, IOException {
		 fid = request.getParameter("fid");
		 myst.removeFaculty(fid);
		 response.sendRedirect("index.html");
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
	     doPost(request,response);
	 }
}