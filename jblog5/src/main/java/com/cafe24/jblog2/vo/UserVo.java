package com.cafe24.jblog2.vo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class UserVo {
	@NotEmpty
	@Length(min = 2, max = 10)
	private String userid;

	@NotEmpty
	@Length(min = 6, max = 16)
	private String userpassword;
	private String userregdate;

	@NotEmpty
	@Length(min = 2, max = 12)
	private String username;

	public String getUserid() {
		return userid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public String getUserregdate() {
		return userregdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public void setUserregdate(String userregdate) {
		this.userregdate = userregdate;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", userpassword=" + userpassword + ", userregdate=" + userregdate
				+ ", username=" + username + "]";
	}

}
