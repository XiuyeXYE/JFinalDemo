package com.xiuye.jfinal.model;

import com.jfinal.plugin.activerecord.Model;

public class Blog extends Model<Blog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8855056759420431181L;

	public String getTitle() {
		return getStr("title");
	}
	public void setTitle(String title) {
		set("title", title);
	}
	public String getContent() {
		return getStr("content");
	}
	public void setContent(String content) {
		set("content",content);
	}
	
	
	
}
