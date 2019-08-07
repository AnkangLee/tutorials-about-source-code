package dev.ankang.design.pattern.creational.simplefactory;

public class FEVideo implements Video {
    @Override
    public void product() {
        System.out.println("录制FE课程视频");
    }
}
