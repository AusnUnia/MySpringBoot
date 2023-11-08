package myspringboot.annotations;

import myspringboot.MyOnClassCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 17:01
 * @Description:
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(MyOnClassCondition.class)
public @interface MyConditionalOnClass {
    Class<?>[] value() default {};
    String[] name() default {};
}
