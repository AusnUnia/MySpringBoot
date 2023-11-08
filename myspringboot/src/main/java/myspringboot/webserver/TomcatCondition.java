package myspringboot.webserver;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 16:33
 * @Description:
 */
public class TomcatCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //判断什么条件下tomcat的bean（TomcatWebServer）生效
        try {
            Class<?> tomcatClass = context.getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
