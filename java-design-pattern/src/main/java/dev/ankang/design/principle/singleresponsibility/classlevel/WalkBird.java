package dev.ankang.design.principle.singleresponsibility.classlevel;

public class WalkBird implements Movable {
    @Override
    public void mainMoveMode(String moveObject) {
        System.out.println(moveObject + " move on foot");
    }
}
