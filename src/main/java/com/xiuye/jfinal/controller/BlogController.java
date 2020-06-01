package com.xiuye.jfinal.controller;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.xiuye.jfinal.model.Blog;
import com.xiuye.util.log.XLog;

public class BlogController extends Controller {

	@Before(Tx.class)
	public void save() {
		Blog blog = getModel(Blog.class);
		XLog.ln(blog);
		XLog.ln(blog.save());
		Blog blog2 = getBean(Blog.class);
		XLog.ln(blog2);
		XLog.ln(blog2.save());
		redirect("/helloKey");
	}
	
}
