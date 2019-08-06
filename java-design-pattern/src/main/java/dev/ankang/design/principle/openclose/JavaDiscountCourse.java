package dev.ankang.design.principle.openclose;

import lombok.ToString;

@ToString(callSuper=true)
public class JavaDiscountCourse extends JavaCourse {
    public JavaDiscountCourse(Integer id, String name, Double price) {
        super(id, name, price);
    }

    public Double getDiscountPrice() {
        return getPrice() * 0.8;
    }
}
