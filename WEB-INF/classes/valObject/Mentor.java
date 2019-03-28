package valObject;

//import org.apache.log4j.Logger;

public class Mentor {
	//Logger log = Logger.getLogger(Mentor.class.getName());
	String FID;
	String RegNo;
	public String getFID() {
		//log.debug("DEBUG:getFID()"+FID);
		return FID;
	}
	public void setFID(String fID) {
		//log.debug("DEBUG:setFID()"+FID);
		FID = fID;
	}
	public String getRegNo() {
		//log.debug("DEBUG:getRegNo()"+RegNo);
		return RegNo;
	}
	public void setRegNo(String regNo) {
		//log.debug("DEBUG:setRegNo()"+RegNo);
		RegNo = regNo;
	}
}
