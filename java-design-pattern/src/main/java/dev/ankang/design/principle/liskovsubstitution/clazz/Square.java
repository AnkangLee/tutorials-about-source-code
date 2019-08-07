package dev.ankang.design.principle.liskovsubstitution.clazz;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square implements Quadrangle {

    private Long sideLength;

    @Override
    public Long getWidth() {
        return this.sideLength;
    }

    @Override
    public Long getLength() {
        return this.sideLength;
    }
}
