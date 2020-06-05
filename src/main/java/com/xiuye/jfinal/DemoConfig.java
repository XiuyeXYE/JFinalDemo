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
	 * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示 才将 main 方法放在了 DemoConfig 中
	 *
	 * 开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用 启动入口类放置用于启动的 main 方法
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
//            // 配置 Filter
//            builder.addFilter("myFilter", "com.abc.MyFilter");
//            builder.addFilterUrlMapping("myFilter", "/*");
//            builder.addFilterInitParam("myFilter", "key", "value");
//            
//            // 配置 Servlet
//            builder.addServlet("myServlet", "com.abc.MyServlet");
//            builder.addServletMapping("myServlet", "*.do");
//            builder.addServletInitParam("myServlet", "key", "value");
//            
//            // 配置 Listener
//            builder.addListener("com.abc.MyListener");
//            
//            // 配置 WebSocket，MyWebSocket 需使用 ServerEndpoint 注解
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
		// 配置 baseViewPath，可以让 render(...) 参数省去 baseViewPath 这部分前缀
//        me.setBaseViewPath("/html");
		me.add("/hello", HelloController.class, "html");
//       me.add("hello", HelloController.class);
	}

	public void configEngine(Engine me) {
	}

	public void configPlugin(Plugins me) {
		// 配置 druid 数据库连接池插件
//		DruidPlugin druidPlugin = new DruidPlugin(p.get("jdbcUrl").trim(), p.get("user").trim(),
//				p.get("password").trim());
//		me.add(druidPlugin);

		// 配置ActiveRecord插件
//		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		// 所有映射在 MappingKit 中自动化搞定
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
