package dev.ankang.design.pattern.creational.factorymethod;

import org.junit.Test;
public class VideoFactoryTest {

    @Test
    public void getVideo() {
        VideoFactory videoFactory = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.product();
    }
}