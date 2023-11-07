package myspringboot;

import java.lang.annotation.*;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/7 19:40
 * @Description:
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MySpringBootApplication {

}
