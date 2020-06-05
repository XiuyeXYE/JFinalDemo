package com.xiuye.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.xiuye.jfinal.controller.HelloController;
import com.xiuye.jfinal.model.Blog;
import com.xiuye.util.log.XLog;

public class DemoConfig extends JFinalConfig {

	/**
	 * ע�⣺���������� main �������������� java ���д������ڴ˽�Ϊ������ʾ �Ž� main ���������� DemoConfig ��
	 *
	 * ������Ŀʱ�������½�һ�� App.java ���� Start.java ������ר�� ���������������������� main ����
	 */
	public static void main(String[] args) {
		UndertowServer.start(DemoConfig.class, 80, true);
//        UndertowServer.create(DemoConfig.class)
//        .configWeb(wb -> {
//           wb.getDeploymentInfo().addServlet(JspServletBuilder.createServlet("Default Jsp Servlet", "*.jsp"));
//      
//           HashMaptagLibraryInfo = new HashMap<>();
//           JspServletBuilder.setupDeployment(wb.getDeploymentInfo(), new HashMap(),
//           tagLibraryInfo, new HackInstanceManager());
//        })
//        .start();
//        UndertowServer.create(AppConfig.class)
//        .configWeb( builder -> {
//            // ���� Filter
//            builder.addFilter("myFilter", "com.abc.MyFilter");
//            builder.addFilterUrlMapping("myFilter", "/*");
//            builder.addFilterInitParam("myFilter", "key", "value");
//            
//            // ���� Servlet
//            builder.addServlet("myServlet", "com.abc.MyServlet");
//            builder.addServletMapping("myServlet", "*.do");
//            builder.addServletInitParam("myServlet", "key", "value");
//            
//            // ���� Listener
//            builder.addListener("com.abc.MyListener");
//            
//            // ���� WebSocket��MyWebSocket ��ʹ�� ServerEndpoint ע��
//            builder.addWebSocketEndpoint("com.abc.MyWebSocket");
//         })
//        .start();
	}

	Prop p;

	public void configConstant(Constants me) {
		p = PropKit.useFirstFound("mysql-pro", "mysql-dev.txt");
		me.setDevMode(true);
	}

	public void configRoute(Routes me) {

		me.add(new MyRoutes());
		// ���� baseViewPath�������� render(...) ����ʡȥ baseViewPath �ⲿ��ǰ׺
//        me.setBaseViewPath("/html");
		me.add("/hello", HelloController.class, "html");
//       me.add("hello", HelloController.class);
	}

	public void configEngine(Engine me) {
	}

	public void configPlugin(Plugins me) {
		// ���� druid ���ݿ����ӳز��
//		DruidPlugin druidPlugin = new DruidPlugin(p.get("jdbcUrl").trim(), p.get("user").trim(),
//				p.get("password").trim());
//		me.add(druidPlugin);

		// ����ActiveRecord���
//		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// ����ӳ���� MappingKit ���Զ����㶨
//		_MappingKit.mapping(arp);
//		arp.addMapping("blog", "id", Blog.class);

//		me.add(arp);

		XLog.lg(me.getPluginList());

	}

	public void configInterceptor(Interceptors me) {
	}

	public void configHandler(Handlers me) {
	}
}
