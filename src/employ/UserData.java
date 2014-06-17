package employ;

public class UserData {
	private String user;
	private String pass;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		UserData ud = (UserData)obj;
		String str = ud.user;
		
			return str.equals(user);
	}
	
	
}
