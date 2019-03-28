package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


import exceptions.addFacultyException;
import exceptions.addUserException;
import valObject.Faculty;
import valObject.Mentor;
import valObject.Student;

public interface MySystem {
	void addStudent(Student sObj) throws IOException, addUserException;
	void addFaculty(Faculty fObj) throws IOException, addFacultyException;
	void addMentor(Mentor mObj) throws IOException;
	void removeStudent(String regno) throws IOException;
	void removeFaculty(String fid) throws IOException;
	void removeMentor(String regno) throws IOException;
	ArrayList<String> displayStudent() throws IOException;
	ArrayList<String> displayFaculty() throws IOException;
	ArrayList<String> displayMentor() throws IOException;
}
