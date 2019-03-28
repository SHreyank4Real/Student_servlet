package serv;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import exceptions.addUserException;
import impl.MySystemImpl;
import interfaces.MySystem;
import valObject.Student;

// Extend HttpServlet class
public class AddStudent extends HttpServlet {
	
	 String name;
	 String regNo;
	 String branch;
	 Student st = new Student();
	 MySystem myst = new MySystemImpl();
   public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	   myst = new MySystemImpl();
	   st = new Student();
	   name = request.getParameter("sName");
	   st.setName(name);
	   regNo = request.getParameter("sid");
	   st.setRollNo(regNo);
	   branch = request.getParameter("sbran");
	   st.setBranch(branch);
	   try {
		myst.addStudent(st);
	} catch (addUserException e) {
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
