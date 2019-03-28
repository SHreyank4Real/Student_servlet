package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import exceptions.addFacultyException;
import impl.MySystemImpl;
import interfaces.MySystem;
import valObject.Faculty;


// Extend HttpServlet class
public class AddFaculty extends HttpServlet {
	
	 String name;
	 String fid;
	 String dept;
	 Faculty ft = new Faculty();
	 MySystem myst = new MySystemImpl();	
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   name = request.getParameter("fName");
	   ft.setName(name);
	   fid = request.getParameter("fid");
	   ft.setFID(fid);
	   dept = request.getParameter("fdept");
	   ft.setDept(dept);
	   try {
		myst.addFaculty(ft);
	} catch (addFacultyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   response.sendRedirect("index.html");
   }
   public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	   doPost(request,response);
   }
}