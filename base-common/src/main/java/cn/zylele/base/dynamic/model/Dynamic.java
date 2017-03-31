package cn.zylele.base.dynamic.model;

import java.io.Serializable;

public class Dynamic implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4866207559047122315L;

	private Integer id;

	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
