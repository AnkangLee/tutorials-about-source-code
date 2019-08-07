package dev.ankang.design.pattern.creational.simplefactory;


import java.sql.DriverManager;
import java.util.Calendar;

/**
 * 使用者只需传入参数，不关心产品的具体生产过程。
 *
 * 工厂的职责过重，新增新的产品需要修改工厂类，违背开闭原则。
 *
 * 在JDK源码里面使用简单工厂的类
 * - 通过名称获取 {@link Calendar#createCalendar(java.util.TimeZone, java.util.Locale)}
 * - 通过反射获取 {@link DriverManager#getConnection(java.lang.String, java.util.Properties, java.lang.Class)}
 *   【mysql 驱动注册代码在 com.mysql.jdbc.Driver 的静态方法中】
 */
public class VideoFactory {
    public Video getVideo(String type) {
        if ("java".equalsIgnoreCase(type)) {
            return new JavaVideo();
        } else if ("FE".equalsIgnoreCase(type)) {
            return new FEVideo();
        }
        return null;
    }

    public Video getVideo(Class clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return video;
    }
}
