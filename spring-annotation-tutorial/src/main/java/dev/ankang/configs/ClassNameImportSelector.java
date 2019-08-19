package dev.ankang.configs;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * description : 自定义需要导入的组件的逻辑
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class ClassNameImportSelector implements ImportSelector {

    /**
     * 返回值就是要导入到容器中的组件的全类名
     * AnnotationMetadata ：当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {"dev.ankang.thirdparty.Green"};
    }
}
