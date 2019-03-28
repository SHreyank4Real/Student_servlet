package exceptions;
//import org.apache.log4j.Logger;

public class addFacultyException extends Exception {
	//Logger log = Logger.getLogger(addFacultyException.class.getName());
	public addFacultyException(String msg) {
		super(msg);
		//log.error("ERROR: "+msg);
	}

}
