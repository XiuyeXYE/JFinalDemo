package com.xiuye.jfinal;

import com.jfinal.config.Routes;
import com.xiuye.jfinal.controller.BlogController;
import com.xiuye.jfinal.controller.UploadController;

public class MyRoutes extends Routes{

	@Override
	public void config() {
		
		add("blog",BlogController.class);
		
		add("upload",UploadController.class,"html");
		
	}

	
	
}
