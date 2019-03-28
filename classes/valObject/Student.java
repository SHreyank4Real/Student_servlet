package valObject;

//import org.apache.log4j.Logger;

public class Student {
	//static Logger log = Logger.getLogger(Student.class.getName());
	String RollNo;
	String Name;
	String Branch;
	public String getRollNo() {
		//log.debug("DEBUG:getRollNo()"+RollNo);
		return RollNo;
	}
	public void setRollNo(String rollNo) {
		//log.debug("DEBUG:setRollNo()"+RollNo);
		RollNo = rollNo;
	}
	public String getName() {
		//log.debug("DEBUG:getName()"+Name);
		return Name;
	}
	public void setName(String name) {
		//log.debug("DEBUG:setName()"+Name);
		Name = name;
	}
	public String getBranch() {
		//log.debug("DEBUG:getBranch()"+Branch);
		return Branch;
	}
	public void setBranch(String branch) {
		//log.debug("DEBUG:setBranch()"+Branch);
		Branch = branch;
	}
}
