package myspringboot.webserver;

import myspringboot.annotations.MyConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 16:31
 * @Description:
 */
@Configuration
public class WebServerAutoConfiguration {
    @Bean
    //@Conditional(TomcatCondition.class)
    @MyConditionalOnClass(name="org.apache.catalina.startup.Tomcat")
    public TomcatWebServer tomcatWebServer() {
        return new TomcatWebServer();
    }

    @Bean
    //@Conditional(JettyCondition.class)
    @MyConditionalOnClass(name="org.eclipse.jetty.server.Server")
    public JettyWebServer jettyWebServer() {
        return new JettyWebServer();
    }
}
