package dev.ankang.design.principle.liskovsubstitution.clazz;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Rectangle implements Quadrangle {
    private Long width;
    private Long length;

    @Override
    public Long getWidth() {
        return this.width;
    }

    @Override
    public Long getLength() {
        return this.length;
    }
}
