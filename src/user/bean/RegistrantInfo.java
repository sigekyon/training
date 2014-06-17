package user.bean;

import java.io.Serializable;

public class RegistrantInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	String rId = null;
	String rName = null;
	String rAge = null;

	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getrAge() {
		return rAge;
	}
	public void setrAge(String rAge) {
		this.rAge = rAge;
	}
}
