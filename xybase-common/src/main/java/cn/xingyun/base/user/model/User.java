package cn.xingyun.base.user.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4369053056358947812L;

	private String userid;

	private String nickname;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
