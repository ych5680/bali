package cn.bdqn.bali.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo entity
 */

public class UserInfo implements java.io.Serializable {

	private Long userId;//用户id
	private Long userRoleId;//用户对应角色
	private String userName;//用户名
	private String userPwd;//用户密码

	public UserInfo(Long userId, Long userRoleId, String userName, String userPwd) {
		this.userId = userId;
		this.userRoleId = userRoleId;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public UserInfo() {
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

}