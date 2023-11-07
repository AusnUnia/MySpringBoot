package example;


import org.myspringboot.MySpringApplication;
import org.myspringboot.MySpringBootApplication;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/7 19:42
 * @Description:
 */

@MySpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        MySpringApplication.run(MyApplication.class,args);
    }

}
