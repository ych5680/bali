package cn.bdqn.bali.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * SysRight entity. @author MyEclipse Persistence Tools
 */

public class SysRight implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9084668242869391556L;
	private String rightCode;
	private String rightParentCode;
	private String rightText;
	private String rightUrl;
	private Set<RoleRight> roleRights = new HashSet<RoleRight>(0);

	// Constructors

	/** default constructor */
	public SysRight() {
	}

	/** minimal constructor */
	public SysRight(String rightCode, String rightParentCode, String rightText,
			String rightUrl) {
		this.rightCode = rightCode;
		this.rightParentCode = rightParentCode;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
	}

	/** full constructor */
	public SysRight(String rightCode, String rightParentCode, String rightText,
			String rightUrl, Set<RoleRight> roleRights) {
		this.rightCode = rightCode;
		this.rightParentCode = rightParentCode;
		this.rightText = rightText;
		this.rightUrl = rightUrl;
		this.roleRights = roleRights;
	}

	// Property accessors

	public String getRightCode() {
		return this.rightCode;
	}

	public void setRightCode(String rightCode) {
		this.rightCode = rightCode;
	}

	public String getRightParentCode() {
		return this.rightParentCode;
	}

	public void setRightParentCode(String rightParentCode) {
		this.rightParentCode = rightParentCode;
	}

	public String getRightText() {
		return this.rightText;
	}

	public void setRightText(String rightText) {
		this.rightText = rightText;
	}

	public String getRightUrl() {
		return this.rightUrl;
	}

	public void setRightUrl(String rightUrl) {
		this.rightUrl = rightUrl;
	}

	public Set<RoleRight> getRoleRights() {
		return this.roleRights;
	}

	public void setRoleRights(Set<RoleRight> roleRights) {
		this.roleRights = roleRights;
	}

}