package exceptions;
//import org.apache.log4j.Logger;
public class mentorComboException extends Exception {
	//Logger log = Logger.getLogger(mentorComboException.class.getName());
	public mentorComboException(String msg) {
		super(msg);
		//log.error("ERROR: "+msg);
	}

}
