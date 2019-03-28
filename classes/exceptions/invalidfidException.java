package exceptions;
//import org.apache.log4j.Logger;
public class invalidfidException extends Exception {
	//Logger log = Logger.getLogger(invalidfidException.class.getName());
	public invalidfidException(String msg) {
		super(msg);
		//log.error("ERROR: "+msg);
	}

}
