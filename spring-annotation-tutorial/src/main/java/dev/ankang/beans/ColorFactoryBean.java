package dev.ankang.beans;

import dev.ankang.thirdparty.Color;
import org.springframework.beans.factory.FactoryBean;

/**
 * description :
 * last-modified : 2019-08-02
 *
 * @author LeeAnkang
 * @version 1.0.0
 */
public class ColorFactoryBean implements FactoryBean {
    /**
     * 返回一个Color对象，这个对象会添加到容器中
     */
    @Override
    public Object getObject() throws Exception {
        System.out.println("ColorFactoryBean getBean....");
        return new Color();
    }

    /**
     * 返回的类型
     */
    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 控制是否为单例
     * true：表示的就是一个单实例，在容器中保存一份
     * false:多实例，每次获取都会创建一个新的bean
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
