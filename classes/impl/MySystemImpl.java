package impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

//import org.apache.log4j.Logger;


import exceptions.addFacultyException;
import exceptions.addUserException;
import exceptions.invalidRegnoException;
import exceptions.invalidfidException;
import exceptions.mentorComboException;
import interfaces.MySystem;
import valObject.Faculty;
import valObject.Mentor;
import valObject.Student;

public class MySystemImpl implements MySystem {
	static Date date = new Date();
	//Logger log = Logger.getLogger(MySystemImpl.class.getName());
	
    public void addStudent(Student sObj) throws IOException, addUserException {
    	//log.info("INFO: addStudent() function "+date);
    	Boolean flag = true;
		String name = sObj.getName();
		String regno = sObj.getRollNo();
		String branch = sObj.getBranch();
		File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Student.txt");	
		//log.debug("DEBUG: File object input file created "+date);
	    BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	   // log.debug("DEBUG: Buffered reader to input file created "+date);
	    String curLine;		
    	while((curLine = reader.readLine())!=null) {
    		String[] sent = curLine.split(",");
    			if (sent[1].equals(regno)) {
    				flag=false;
    				throw new addUserException("Register No Already Exists");
    			}
    	}
    	if(flag) {
    		FileWriter writer = new FileWriter("/home/ubuntu/javaweb/ServletPractice2/files/Student.txt", true);
    		try {
    			//log.debug("DEBUG: Writing contents to file"+date);
    			writer.write(name+','+regno+','+branch+'\n');
    			//log.debug("DEBUG: "+name+','+regno+','+branch+'\n');	
    		}
    		finally {
    			writer.close();
    		}
    	}
    }
    
    
    public void addFaculty(Faculty fObj) throws IOException,addFacultyException {
    	//log.info("INFO: addFaculty() function "+date);
    	Boolean flag = true;
    	String name = fObj.getName();
    	String fid = fObj.getFID();
    	String dept = fObj.getDept();
    	File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Faculty.txt");	 
    	//log.debug("DEBUG: File object input file created "+date);
	    BufferedReader reader = new BufferedReader(new FileReader(inputFile));   
	   // log.debug("DEBUG: Buffered reader to input file created "+date);
	    String curLine;
	    while((curLine = reader.readLine())!=null) {
    		String[] sent = curLine.split(",");
    		
    			if (sent[1].equals(fid)) {
    				flag=false;
    				throw new addFacultyException("Faculty No Already Exists");
    			}
 
    	}
	    if(flag) {
    		FileWriter writer = new FileWriter("/home/ubuntu/javaweb/ServletPractice2/files/Faculty.txt", true);
    		try {
    			//log.debug("DEBUG: Writing contents to file"+date);	
    			writer.write(name+','+fid+','+dept+'\n');
    			//log.debug("DEBUG: "+name+','+fid+','+dept+'\n');	
    		}finally {
			writer.close();
    		}
	    }
    }
    
    
    public void addMentor(Mentor mObj) throws IOException {
    	//log.info("INFO: addMentor() function "+date);
    	Boolean flag = false, flag1 = false, flag2 = true;
    	String fid = mObj.getFID();
    	String regno = mObj.getRegNo();
    	File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Student.txt");
    	//log.debug("DEBUG: File object input file created for student.txt"+date);
    	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    	//log.debug("DEBUG: Buffered reader to input file created "+date);
	    String curLine;		
    	while((curLine = reader.readLine())!=null) {
    		String[] sent = curLine.split(",");
    		if (sent[1].equals(regno)) {
    			flag=true;
    		}
    	}
    	reader.close();
    	File inputFile1 = new File("/home/ubuntu/javaweb/ServletPractice2/files/Faculty.txt");
    	//log.debug("DEBUG: File object input file created for faculty.txt"+date);
    	BufferedReader reader1 = new BufferedReader(new FileReader(inputFile1));
    	//log.debug("DEBUG: Buffered reader to input file created "+date);
    	String curLine1 = null;
    	while((curLine1 = reader1.readLine())!=null) {
    		String[] sent1 = curLine1.split(",");
    		if(sent1[1].equals(fid)) {
    				flag1=true;
    			}
    	}
    	reader1.close();
    	File inputFile3 = new File("/home/ubuntu/javaweb/ServletPractice2/files/Mentor.txt");
    	//log.debug("DEBUG: File object input file created for mentor.txt"+date);
    	BufferedReader reader3 = new BufferedReader(new FileReader(inputFile3));
    	//log.debug("DEBUG: Buffered reader to input file created "+date);
    	String curLine2;
    	while((curLine2 = reader3.readLine())!=null) {
    		String[] sent2 = curLine2.split(",");
    		try {
    			if(sent2[1].equals(regno)) {
    				flag2=false;
    				System.out.println("ERROR!!Student is already being mentored");
    				//log.error("ERROR: Student is already being mentored");
    				throw new mentorComboException("Student is already being mentored");
    			}
    		}catch(mentorComboException e) {
    			//log.error("Error: "+e);
    			}
    		}
    		if(flag && flag1 && flag2) 
    		{  
    			FileWriter writer = new FileWriter("/home/ubuntu/javaweb/ServletPractice2/files/Mentor.txt", true);
    			try {
    			//log.debug("DEBUG: Writing contents to file"+date);
    			writer.write(fid+','+regno+'\n');
    			//log.debug("DEBUG: "+fid+','+regno+'\n');	
    			writer.close();
    			}finally {
    				writer.close();
    	    		}
    		}
    		else {
    			try {
					throw new mentorComboException("Error: Please enter proper details");
				} catch (mentorComboException e) {
					// TODO Auto-generated catch block
					//log.error("Error: "+e);
				}
    		}
    		reader3.close();	
    }
    
    public void removeStudent(String regno) throws IOException{
    		//log.info("INFO: removeStudent() function "+date);
    		File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Student.txt");
    		//log.debug("DEBUG: File object input file created for student.txt"+date);
    		File tempFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/MyTempFile.txt");
		
    		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    		//log.debug("DEBUG:  Buffered writer to output  file created "+date);	
    		String lineToRemove = regno;
    		String curLine;
    		
    		while((curLine = reader.readLine())!=null) {
    			String[] sent = curLine.split(",");
    			if (sent[1].equals(lineToRemove)){
    				//log.debug("DEBUG: Removing regno:"+regno+"from file"+date);
    				System.out.println("Line Removed");
    			}else {
    				writer.write(curLine+'\n');
    			}
    		}
    		reader.close();
    		writer.close();
    		inputFile.delete();
    		if(tempFile.renameTo(inputFile)) {
    			System.out.println("Changed");
    		}
    		removeMentor(regno);
    		//log.debug("DEBUG: Calling Mentor.txt to remove the student with regno"+regno+""+date);
    }
    
    public void removeFaculty(String fid) throws IOException {
    		//log.info("INFO: removeFaculty() function "+date);
    		File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Faculty.txt");
    		//log.debug("DEBUG: File object input file created for faculty.txt"+date);
    		File tempFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/MyTempFile.txt");
    		
    		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    		//log.debug("DEBUG:  Buffered writer to output  file created "+date);
    		
    		String lineToRemove = fid;
    		String curLine;
    		
    		while((curLine = reader.readLine())!=null) {
    			String[] sent = curLine.split(",");
    			if (sent[1].equals(lineToRemove)){
    				//log.debug("DEBUG: Removing fid:"+fid+"from file"+date);
    				System.out.println("Line Removed");
    			}else {
    				writer.write(curLine+'\n');
    			}
    		}
    		reader.close();
    		writer.close();
    		inputFile.delete();
    		if(tempFile.renameTo(inputFile)) {
    			System.out.println("Changed");
    		}
    		removeFacultyMentor(fid);
    }
    
    public void removeFacultyMentor(String fid) throws IOException {
    		//log.info("INFO: removeFacultyMentor() function "+date);
    		File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Mentor.txt");
    		//log.debug("DEBUG: File object input file created for Mentor.txt"+date);
    		File tempFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/MyTempFile.txt");
    		
    		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    		//log.debug("DEBUG:  Buffered writer to output  file created "+date);
    		String lineToRemove = fid;
    		String curLine;
    		
    		while((curLine = reader.readLine())!=null) {
    			String[] sent = curLine.split(",");
    			if (sent[0].equals(lineToRemove)){
    				//log.debug("DEBUG: Removing fid:"+fid+"from file"+date);
    				System.out.println("Line Removed");
    			}else {
    				writer.write(curLine+'\n');
    			}
    		}
    		reader.close();
    		writer.close();
    		inputFile.delete();
    		if(tempFile.renameTo(inputFile)) {
    			System.out.println("Changed");
    		}
    }
    public void removeMentor(String regno) throws IOException {
    		//log.info("INFO: removeMentor() function "+date);
    		File inputFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Mentor.txt");
    		//log.debug("DEBUG: File object input file created for Mentor.txt"+date);
    		File tempFile = new File("/home/ubuntu/javaweb/ServletPractice2/files/MyTempFile.txt");
    		
    		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
    		//log.debug("DEBUG:  Buffered writer to output  file created "+date);
    		
    		String lineToRemove = regno;
    		String curLine;
    		
    		while((curLine = reader.readLine())!=null) {
    			String[] sent = curLine.split(",");
    			if (sent[1].equals(lineToRemove)){
    				//log.debug("DEBUG: Removing regno:"+regno+"from file"+date);
    				System.out.println("Line Removed");
    			}else {
    				writer.write(curLine+'\n');
    			}
    		}
    		reader.close();
    		writer.close();
    		inputFile.delete();
    		if(tempFile.renameTo(inputFile)) {
    			System.out.println("Changed");
    		}
    }
    
    public ArrayList<String> displayStudent() throws IOException{
    		//log.info("INFO: displayStudent() function "+date);
    		ArrayList<String> lines = new ArrayList<String>();
    		File inputfile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Student.txt");
    		//log.debug("DEBUG: File object input file created for Student.txt"+date);
    		BufferedReader reader = new BufferedReader(new FileReader(inputfile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		String curLine;
    		while((curLine = reader.readLine())!=null) {
    			//log.debug("DEBUG: reading :"+curLine);
    			lines.add(curLine);
    		}
    		reader.close();
    	return lines;
    }
    
    public ArrayList<String> displayFaculty() throws IOException{
    		//log.info("INFO: displayFaculty() function "+date);
    		ArrayList<String> lines = new ArrayList<String>();
    		File inputfile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Faculty.txt");
    		//log.debug("DEBUG: File object input file created for Faculty.txt"+date);
    		BufferedReader reader = new BufferedReader(new FileReader(inputfile));
    		//log.debug("DEBUG:  Buffered reader to input file created "+date);
    		String curLine;
    		while((curLine = reader.readLine())!=null) {
    			//log.debug("DEBUG: reading :"+curLine);
    			lines.add(curLine);
    		}
    		reader.close();
    	return lines;
    }
    	
    
    public ArrayList<String> displayMentor() throws IOException{
    	//log.info("INFO: displayMentor() function "+date);
    	ArrayList<String> lines = new ArrayList<String>();
    	File inputfile = new File("/home/ubuntu/javaweb/ServletPractice2/files/Mentor.txt");
    	//log.debug("DEBUG: File object input file created "+date);
    	BufferedReader reader = new BufferedReader(new FileReader(inputfile));
    	//log.debug("DEBUG:  Buffered reader to input file created "+date);
    	String curLine;
    	while((curLine = reader.readLine())!=null) {
    			//log.debug("DEBUG: reading :"+curLine);
    			lines.add(curLine);
    	}
    	reader.close();
    	return lines;
    } 
}
