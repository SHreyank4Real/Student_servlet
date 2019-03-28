package exceptions;
//import org.apache.log4j.Logger;
public class invalidRegnoException extends Exception {
	//Logger log = Logger.getLogger(invalidRegnoException.class.getName());
	public invalidRegnoException(String msg) {
		super(msg);
		//log.error("ERROR: "+msg);
	}
}
