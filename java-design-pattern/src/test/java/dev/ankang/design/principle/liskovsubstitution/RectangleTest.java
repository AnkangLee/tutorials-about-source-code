package dev.ankang.design.principle.liskovsubstitution;

import dev.ankang.design.principle.liskovsubstitution.clazz.Rectangle;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void testResize() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10L);
        rectangle.setLength(20L);
        resize(rectangle);
    }

    private void resize(Rectangle rectangle) {
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
            System.out.println("width:" + rectangle.getWidth() + "length" + rectangle.getLength());
        }
        System.out.println("resize方法结束，width" + rectangle.getWidth() + "length" + rectangle.getLength());
    }
}