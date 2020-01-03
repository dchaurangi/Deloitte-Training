package user_db;

public class Role {
	
	int roleId;
	String roleName;
	String privileges;
	
	public Role(String roleName) {
		super();
		//this.roleId = roleId;
		this.roleName = roleName;
	}
	
	

	public Role(int roleId, String roleName, String privileges) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.privileges = privileges;
	}



	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPrivileges() {
		return privileges;
	}

	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	
	
}
