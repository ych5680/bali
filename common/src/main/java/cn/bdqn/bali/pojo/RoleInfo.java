package cn.bdqn.bali.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * RoleInfo entity. @author MyEclipse Persistence Tools
 */

public class RoleInfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7073254380971376912L;
	private Long roleId;
	private String roleName;
	private Set<UserInfo> userInfos = new HashSet<UserInfo>(0);
	private Set<RoleRight> roleRights = new HashSet<RoleRight>(0);

	// Constructors

	/** default constructor */
	public RoleInfo() {
	}

	/** minimal constructor */
	public RoleInfo(String roleName) {
		this.roleName = roleName;
	}

	/** full constructor */
	public RoleInfo(String roleName, Set<UserInfo> userInfos, Set<RoleRight> roleRights) {
		this.roleName = roleName;
		this.userInfos = userInfos;
		this.roleRights = roleRights;
	}

	// Property accessors

	public Long getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserInfo> getUserInfos() {
		return this.userInfos;
	}

	public void setUserInfos(Set<UserInfo> userInfos) {
		this.userInfos = userInfos;
	}

	public Set<RoleRight> getRoleRights() {
		return this.roleRights;
	}

	public void setRoleRights(Set<RoleRight> roleRights) {
		this.roleRights = roleRights;
	}

}