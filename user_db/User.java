package user_db;

public class User {
	
	int userId;
	String fName;
	String userName;
	String passWord;
	String emailId;
	Role rl;
	String mobile;
	
	public User(int userId, String fName, String userName, String passWord, String emailId, String mobile, Role rl) {
		super();
		this.userId = userId;
		this.fName = fName;
		this.userName = userName;
		this.passWord = passWord;
		this.emailId = emailId;
		this.rl = rl;
		this.mobile = mobile;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Role getRl() {
		return rl;
	}
	public void setRl(Role rl) {
		this.rl = rl;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fName=" + fName + ", userName=" + userName + ", passWord=" + passWord
				+ ", emailId=" + emailId + ", rl=" + rl + ", mobile=" + mobile + "]";
	}
	
	

}
