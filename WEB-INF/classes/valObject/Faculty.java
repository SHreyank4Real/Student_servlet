package valObject;
//import org.apache.log4j.Logger;

public class Faculty {
	//Logger log = Logger.getLogger(Faculty.class.getName());
	String FID;
	String Name;
	String Dept;
	public String getFID() {
		//log.debug("DEBUG:getFID()"+FID);
		return FID;
	}
	public void setFID(String fID) {
		FID = fID;
		//log.debug("DEBUG:setFID()"+FID);
	}
	public String getName() {
		//log.debug("DEBUG:getName()"+Name);
		return Name;
	}
	public void setName(String name) {
		//log.debug("DEBUG:setName()"+Name);
		Name = name;
	}
	public String getDept() {
		//log.debug("DEBUG:getDept()"+Dept);
		return Dept;
	}
	public void setDept(String dept) {
		//log.debug("DEBUG:setDept()"+Dept);
		Dept = dept;
	}
}
