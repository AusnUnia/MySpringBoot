package myspringboot.annotations;

import myspringboot.webserver.WebServerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

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
@ComponentScan
@Import(WebServerAutoConfiguration.class)
public @interface MySpringBootApplication {

}
