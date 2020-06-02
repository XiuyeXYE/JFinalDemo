package com.xiuye.jfinal.controller;

import com.jfinal.core.Controller;
import com.xiuye.sharp.Promise;

public class UploadController extends Controller{

	public void index() {
		render("upload.html");
	}
	
	public void send() {
		Promise.of(getFiles()).ln()
		.then(d->{
			d.forEach(f->{
				Promise.lineS(f);
			});
		}).ln();
		redirect("upload");
	}
	
	
}
