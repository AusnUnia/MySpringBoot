package myspringboot;

import myspringboot.annotations.MyConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 18:17
 * @Description:
 */
public class MyOnClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionalOnClass.class.getName());
        String className = (String) annotationAttributes.get("name");

        try {
            Class<?> aClass = context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
