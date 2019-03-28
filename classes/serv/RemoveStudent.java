package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


import impl.MySystemImpl;
import interfaces.MySystem;

public class RemoveStudent extends HttpServlet{
	 String sid ;
	 MySystem myst = new MySystemImpl();
	 public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws ServletException, IOException {
		 sid = request.getParameter("sid");
			myst.removeStudent(sid);
			response.sendRedirect("index.html");
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	     throws ServletException, IOException {
		 doPost(request,response);
	 }
}
