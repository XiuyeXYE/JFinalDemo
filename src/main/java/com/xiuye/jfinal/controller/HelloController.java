package com.xiuye.jfinal.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.NotAction;
import com.xiuye.util.log.XLog;

public class HelloController extends Controller {
    public void index() {
       renderText("Hello JFinal World.");
    }
    public void qr() {
    	renderQrCode("Hello World!", 200, 200,'M');
    }
    public void index1() {
    	render("hello.html");
    	
    }
    @NotAction
    public void notAction() {
    	
    }
    @ActionKey("helloKey")
    public void hello2() {
    	render("hello.html");
    	XLog.lg(getPara());
    	XLog.lg(getRawData());
    	XLog.lg(getPara(0));
    	XLog.lg(getPara("p"));
    }
}