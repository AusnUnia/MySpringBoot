package myspringboot;

import myspringboot.webserver.WebServer;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Map;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/7 19:51
 * @Description:
 */
public class MySpringApplication {

    private Class<?> primarySource;

    public MySpringApplication(Class<?> primarySource){
        this.primarySource=primarySource;
    }

    public void run(String... args) {
        //创建spring容器
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(primarySource);
        context.refresh();

        //启动web容器（tomcat、netty等）
        WebServer webServer=getWebServer(context);
        webServer.start();
    }

    public static void run(Class<?> primarySource,String[] args) {
        new MySpringApplication(primarySource).run(args);
    }

    private static WebServer getWebServer(WebApplicationContext webApplicationContext){
        Map<String, WebServer> beansOfType = webApplicationContext.getBeansOfType(WebServer.class);

        if(beansOfType.size()==0){
            throw new NullPointerException();
        }

        if(beansOfType.size()>1){
            throw new RuntimeException("web容器不唯一");
        }

        return beansOfType.values().stream().findFirst().get();
    }

}
