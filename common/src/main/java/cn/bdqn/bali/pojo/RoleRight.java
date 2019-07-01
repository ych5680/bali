package cn.bdqn.bali.pojo;

/**
 * RoleRight entity. @author MyEclipse Persistence Tools
 */

public class RoleRight implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7194812001772322311L;
	private Long rfId; //角色权限表自动编号
	private Long rfRoleId; //角色id
	private String rfRightCode; //权限编号

	private SysRight sysRight; //角色对应权限

	// Constructors

	/** default constructor */
	public RoleRight() {
	}


	/** full constructor */

	public RoleRight(Long rfId, Long rfRoleId, String rfRightCode, SysRight sysRight) {
		this.rfId = rfId;
		this.rfRoleId = rfRoleId;
		this.rfRightCode = rfRightCode;
		this.sysRight = sysRight;
	}

	// Property accessors

	public Long getRfRoleId() {
		return rfRoleId;
	}

	public void setRfRoleId(Long rfRoleId) {
		this.rfRoleId = rfRoleId;
	}

	public String getRfRightCode() {
		return rfRightCode;
	}

	public void setRfRightCode(String rfRightCode) {
		this.rfRightCode = rfRightCode;
	}

	public Long getRfId() {
		return this.rfId;
	}

	public void setRfId(Long rfId) {
		this.rfId = rfId;
	}

	public SysRight getSysRight() {
		return this.sysRight;
	}

	public void setSysRight(SysRight sysRight) {
		this.sysRight = sysRight;
	}



}