package myspringboot.webserver;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 16:33
 * @Description:
 */
public class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            Class<?> jettyClass = context.getClassLoader().loadClass("org.eclipse.jetty.server.Server");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
