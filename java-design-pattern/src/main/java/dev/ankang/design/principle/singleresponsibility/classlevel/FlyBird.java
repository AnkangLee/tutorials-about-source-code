package dev.ankang.design.principle.singleresponsibility.classlevel;

public class FlyBird implements Movable {
    @Override
    public void mainMoveMode(String moveObject) {
        System.out.println(moveObject + " move by fly");
    }
}
