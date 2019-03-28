package exceptions;
//import org.apache.log4j.Logger;
public class addUserException extends Exception {
	//Logger log = Logger.getLogger(addUserException.class.getName());
	public addUserException(String msg) {
		super(msg);
		//log.error("ERROR: "+msg);
	}
}
