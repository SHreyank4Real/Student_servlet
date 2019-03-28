package serv;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

import impl.MySystemImpl;
import interfaces.MySystem;

public class DisplayStudent extends HttpServlet{
	 MySystem myst = new MySystemImpl();
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 ArrayList<String> Slines = myst.displayStudent();
		 
		 PrintWriter writer = response.getWriter();
		 String htmlRespone = "<html>";
		 
		 for(String Line:Slines) {
			 htmlRespone += Line;
			 htmlRespone += "<br/>";
			 //System.out.println(Line);
		 }
		 htmlRespone += "</html>";
		 writer.println(htmlRespone);
		 
	 }
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
		 throws ServletException, IOException {
		 doPost(request,response);
	}
}
