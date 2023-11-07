package myspringboot;

import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/7 19:51
 * @Description:
 */
public class MySpringApplication {

    public static void run(Class clazz,String[] args) {
        //启动web容器（tomcat、netty等）
        startWebServer();
    }

    private static void startWebServer(){
        startTomcat();
    }

    private static void startTomcat() {
        Tomcat tomcat=new Tomcat();

        Server server=tomcat.getServer();
        Service service=server.findService("Tomcat");

        Connector connector=new Connector();
        connector.setPort(8081);

        Engine engine=new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host=new StandardHost();
        host.setName("localhost");

        String contextPath="";
        Context context=new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        tomcat.addServlet(contextPath,"dispatcher",new DispatcherServlet());

        try {
            tomcat.start();
        } catch (LifecycleException e){
            e.printStackTrace();
        }
    }
}
