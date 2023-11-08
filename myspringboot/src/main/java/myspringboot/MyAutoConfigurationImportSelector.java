package myspringboot;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: Ausn
 * @DateTime: 2023/11/8 19:01
 * @Description:
 */
public class MyAutoConfigurationImportSelector implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回需要的自动配置类的类名
        return new String[0];
    }
}
